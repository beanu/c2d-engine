package info.u250.spriter.plugin.draw;


import info.u250.spriter.plugin.file.FileLoader;
import info.u250.spriter.plugin.file.Reference;

public abstract class AbstractDrawer<L> {
	
	private final FileLoader<L> loader;
	
	public AbstractDrawer(FileLoader<L> loader){
		this.loader=loader;
	}
	
	abstract public void draw(DrawInstruction instruction);
	
	protected L getFile(Reference reference){
		return loader.get(reference);
	}
}
