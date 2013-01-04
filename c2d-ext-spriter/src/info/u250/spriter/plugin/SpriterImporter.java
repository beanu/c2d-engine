package info.u250.spriter.plugin;

import info.u250.spriter.dom.Animation;
import info.u250.spriter.dom.AnimationObject;
import info.u250.spriter.dom.AnimationObjectRef;
import info.u250.spriter.dom.Bone;
import info.u250.spriter.dom.BoneRef;
import info.u250.spriter.dom.Entity;
import info.u250.spriter.dom.File;
import info.u250.spriter.dom.Folder;
import info.u250.spriter.dom.Key;
import info.u250.spriter.dom.MainLine;
import info.u250.spriter.dom.SpriterData;
import info.u250.spriter.dom.TimeLine;

import java.io.IOException;
import java.math.BigDecimal;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class SpriterImporter {
	public static SpriterData importFile(FileHandle fileHandle) throws IOException {

		XmlReader xmlReader = new XmlReader();
		Element rootElement = xmlReader.parse(fileHandle);
		SpriterData spriterData = new SpriterData();
		spriterData.setScmlVersion(rootElement.getAttribute("scml_version"));
		spriterData.setGenerator(rootElement.getAttribute("generator"));
		spriterData.setGeneratorVersion(rootElement.getAttribute("generator_version"));

		// folder
		Array<Element> folders = rootElement.getChildrenByName("folder");
		for (Element folderElement : folders) {
			Folder folder = new Folder();
			folder.setId(folderElement.getIntAttribute("id"));
			folder.setName(folderElement.getAttribute("name"));
			// file
			Array<Element> files = folderElement.getChildrenByName("file");
			for (Element fileElement : files) {
				File file = new File();
				file.setId(fileElement.getIntAttribute("id"));
				file.setName(fileElement.getAttribute("name"));
				file.setWidth(fileElement.getInt("width"));
				file.setHeight(fileElement.getInt("height"));
				folder.getFile().add(file);
			}
			spriterData.getFolder().add(folder);
		}

		// entity
		Array<Element> entitys = rootElement.getChildrenByName("entity");
		for (int i = 0; i < entitys.size; i++) {
			Element entityElement = entitys.get(i);
			Entity entity = new Entity();
			entity.setId(entityElement.getIntAttribute("id"));
			entity.setName(entityElement.getAttribute("name"));
			// animation
			Array<Element> animations = entityElement.getChildrenByName("animation");
			for (Element animationElement : animations) {
				Animation animation = new Animation();
				animation.setId(animationElement.getIntAttribute("id"));
				animation.setName(animationElement.getAttribute("name"));
				animation.setLength(animationElement.getIntAttribute("length"));
				animation.setLooping(animationElement.getBoolean("looping", true));
				// mainline
				Element mainlineElement = animationElement.getChildByName("mainline");
				MainLine mainline = new MainLine();
				Array<Element> keys = mainlineElement.getChildrenByName("key");
				for (Element keyElement : keys) {
					// key
					Key key = new Key();
					key.setId(keyElement.getIntAttribute("id"));
					String _time=keyElement.getAttribute("time",null);
					key.setTime(_time!=null?Integer.parseInt(_time):null);
					// key.setBone();
					// key.setSpin(value);
					Array<Element> bonerefs = keyElement.getChildrenByName("bone_ref");
					for (Element bonerefElement : bonerefs) {
						//bone_ref
						BoneRef boneref=new BoneRef();
						boneref.setId(bonerefElement.getIntAttribute("id"));
						boneref.setTimeline(bonerefElement.getIntAttribute("timeline"));
						boneref.setKey(bonerefElement.getIntAttribute("key"));
						boneref.setParent(bonerefElement.getIntAttribute("parent"));
						key.getBoneRef().add(boneref);
					}

					Array<Element> objectrefs = keyElement.getChildrenByName("object_ref");
					for (Element objectrefElement : objectrefs) {
						//object_ref
						AnimationObjectRef objectref=new AnimationObjectRef();
						objectref.setId(objectrefElement.getIntAttribute("id"));
						objectref.setTimeline(objectrefElement.getIntAttribute("timeline"));
						objectref.setKey(objectrefElement.getIntAttribute("key"));
						String _parent=objectrefElement.getAttribute("parent",null);
						objectref.setParent(_parent!=null?Integer.parseInt(_parent):null);
						objectref.setZIndex(objectrefElement.getIntAttribute("z_index"));
						key.getObjectRef().add(objectref);
					}
					mainline.getKey().add(key);
				}
				animation.setMainline(mainline);
				//timeline
				Array<Element> timelines = animationElement.getChildrenByName("timeline");
				for(Element timelineElement:timelines){
					TimeLine timeline=new TimeLine();
					timeline.setId(timelineElement.getIntAttribute("id"));
					timeline.setName(timelineElement.getAttribute("name",null));
					Array<Element> keyss = timelineElement.getChildrenByName("key");
					for(Element keyElement:keyss){
						//key
						Key key=new Key();
						key.setId(keyElement.getIntAttribute("id"));
						String _time=keyElement.getAttribute("time",null);
						key.setTime(_time!=null?Integer.parseInt(_time):null);
						//bone
						Element boneElement=keyElement.getChildByName("bone");
						if(boneElement!=null){
							Bone bone=new Bone();
							bone.setX(new BigDecimal(boneElement.getAttribute("x")));
							bone.setY(new BigDecimal(boneElement.getAttribute("y")));
							bone.setAngle(new BigDecimal(boneElement.getAttribute("angle")));
							bone.setScaleX(new BigDecimal(boneElement.getAttribute("scale_x")));
							bone.setScaleY(new BigDecimal(boneElement.getAttribute("scale_y")));
							key.setBone(bone);
						}
						//object
						Array<Element> objects = keyElement.getChildrenByName("object");
						for(Element objectElement:objects){
							AnimationObject object=new AnimationObject();
							object.setFolder(objectElement.getIntAttribute("folder"));
							object.setFile(objectElement.getIntAttribute("file"));
							object.setX(new BigDecimal(objectElement.getAttribute("x")));
							object.setY(new BigDecimal(objectElement.getAttribute("y")));
							object.setPivotX(getAttribute(objectElement,"pivot_x"));
							object.setPivotY(getAttribute(objectElement,"pivot_y"));
							object.setScaleX(getAttribute(objectElement,"scale_x"));
							object.setScaleY(getAttribute(objectElement,"scale_y"));
							object.setAngle(getAttribute(objectElement,"angle"));
							key.getObject().add(object);
						}
						timeline.getKey().add(key);
					}
					animation.getTimeline().add(timeline);
				}
				entity.getAnimation().add(animation);
			}
			spriterData.getEntity().add(entity);
		}
		System.out.println(spriterData);
		return spriterData;
	}
	
	private static BigDecimal getAttribute(Element element,String name){
		String value=element.getAttribute(name, null);
		if(value!=null){
			return new BigDecimal(value);
		}
		return null;
	}
}
