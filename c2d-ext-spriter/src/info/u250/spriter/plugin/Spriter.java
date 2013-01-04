package info.u250.spriter.plugin;

import info.u250.spriter.dom.SpriterData;
import info.u250.spriter.plugin.file.FileLoader;
import info.u250.spriter.plugin.file.Reference;

/**
 * 
 * @author Discobeard.com
 * 
 */
public class Spriter {

	/**
	 * Creates a spriter object.
	 * 
	 * @param path
	 * @param drawer
	 *            a drawer extended from the AbstractDrawer
	 * @param loader
	 *            a loader extended from the AbstractLoader
	 * @return a Spriter Object
	 */

	public static Spriter getSpriter(String file, FileLoader<?> loader) {
		return new Spriter(file, loader);
	}
	
	final private FileLoader<?> loader;
//	final private InputStream scmlFile;
	final private SpriterData spriterData;

	private Spriter(String scmlFile, FileLoader<?> loader) {
//		this.scmlFile = scmlFile;
		this.spriterData = new SCMLParser(scmlFile).parse();
		this.loader = loader;
		loadResources();
	}

	private void loadResources() {
		for (int folder = 0; folder < spriterData.getFolder().size(); folder++) {
			for (int file = 0; file < spriterData.getFolder().get(folder).getFile().size(); file++) {
				loader.load(new Reference(folder, file),
						spriterData.getFolder().get(folder).getFile().get(file).getName());
			}
		}
	}
	
	public SpriterData getSpriterData(){
		return this.spriterData;
	}
}
