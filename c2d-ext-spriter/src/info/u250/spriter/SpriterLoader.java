package info.u250.spriter;

import info.u250.spriter.dom.SpriterData;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.utils.Array;

//TODO
public class SpriterLoader extends AsynchronousAssetLoader<SpriterData, SpriterLoader.SpriterParameter> {

	static public class SpriterParameter extends AssetLoaderParameters<SpriterData> {
	}

	public SpriterLoader(FileHandleResolver resolver) {
		super(resolver);
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, SpriterParameter parameter) {
		// TODO Auto-generated method stub

	}

	@Override
	public SpriterData loadSync(AssetManager manager, String fileName, SpriterParameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName, SpriterParameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
