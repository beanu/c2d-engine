package info.u250.spriter.plugin.mergers;

public interface Merger<T, K, V> {

	public V merge(T from1, K from2);
}
