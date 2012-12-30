package info.u250.spriter.mergers;

import info.u250.spriter.converters.SpriterObjectConverter;
import info.u250.spriter.dom.Animation;
import info.u250.spriter.dom.AnimationObject;
import info.u250.spriter.dom.AnimationObjectRef;
import info.u250.spriter.dom.BoneRef;
import info.u250.spriter.dom.Key;
import info.u250.spriter.dom.MainLine;
import info.u250.spriter.dom.TimeLine;
import info.u250.spriter.objects.SpriterBone;
import info.u250.spriter.objects.SpriterKeyFrame;
import info.u250.spriter.objects.SpriterObject;

import java.util.ArrayList;
import java.util.List;

public class SpriterKeyFrameBuilder {

	final private SpriterBoneMerger boneMerger = new SpriterBoneMerger();
	final private SpriterObjectMerger objectMerger = new SpriterObjectMerger();
	final private SpriterObjectConverter objectConverter = new SpriterObjectConverter();
	
	public SpriterKeyFrame[] buildKeyFrameArray(Animation animation){
		
		MainLine mainline = animation.getMainline();
		List<TimeLine> timeLines = animation.getTimeline();
		
		List<Key> keyFrames =  mainline.getKey();

		SpriterKeyFrame[] spriterKeyFrames = new SpriterKeyFrame[keyFrames.size()];
		
		for(int k=0;k<keyFrames.size();k++){
			Key key = keyFrames.get(k);
			
			List<SpriterObject> tempObjects = new ArrayList<SpriterObject>();
			List<SpriterBone> tempBones = new ArrayList<SpriterBone>();
			
			for(BoneRef boneRef : key.getBoneRef()){
				tempBones.add(boneMerger.merge(boneRef, timeLines.get(boneRef.getTimeline()).getKey().get(boneRef.getKey())));
			}
			
			for(AnimationObjectRef objectRef : key.getObjectRef()){
				tempObjects.add(objectMerger.merge(objectRef, timeLines.get(objectRef.getTimeline()).getKey().get(objectRef.getKey())));
			}
			
			for(AnimationObject object : key.getObject()){
				tempObjects.add(objectConverter.convert(object));
			}
			
			spriterKeyFrames[k] = new SpriterKeyFrame();
			spriterKeyFrames[k].setObjects(tempObjects.toArray(new SpriterObject[tempObjects.size()]));
			spriterKeyFrames[k].setBones(tempBones.toArray(new SpriterBone[tempBones.size()]));
			
			spriterKeyFrames[k].setStartTime(key.getTime());
			spriterKeyFrames[k].setEndTime(k<keyFrames.size()-1 ? keyFrames.get(k+1).getTime()-1 : animation.getLength());
		}
		
		return spriterKeyFrames;
	}
}
