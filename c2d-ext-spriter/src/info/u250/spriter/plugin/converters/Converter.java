package info.u250.spriter.plugin.converters;

public interface Converter<F,T> {
	
	public T convert(F from);
}
