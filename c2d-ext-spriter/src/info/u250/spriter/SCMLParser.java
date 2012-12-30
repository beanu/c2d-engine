package info.u250.spriter;

import info.u250.spriter.dom.SpriterData;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.badlogic.gdx.Gdx;

public class SCMLParser {

	// final private File scmlFile;
	private final String path;

	public SCMLParser(String path) {
		// this.scmlFile=scmlFile;
		this.path = path;
	}

	public SpriterData parse() {
		try {
			return parseSpriterData(path);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: SCML File Not Found :");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: SCML File IO ERROR :");
			e.printStackTrace();
		}
		return null;
	}

	private SpriterData parseSpriterData(String SCMLFile) throws IOException {

		// JAXBContext jc;
		// jc = JAXBContext.newInstance("com.discobeard.spriter.dom");
		// Unmarshaller u = jc.createUnmarshaller();
		//
		// @SuppressWarnings("unchecked")
		// JAXBElement<SpriterData> root = (JAXBElement<SpriterData>)
		// u.unmarshal(SCMLFile);
		SpriterData spriterData = SpriterImporter.importFile(Gdx.files.internal(SCMLFile));
		return spriterData;

	}
}
