package info.u250.spriter.draw;


import info.u250.spriter.file.FileLoader;
import info.u250.spriter.file.Reference;

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
