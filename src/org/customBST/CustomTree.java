package org.customBST;

public interface CustomTree<V> {
	public void add(V value);
	public boolean remove();
	public boolean isEmpty();
	public boolean contains(V value);
	public V first();
	public int size();
	
}
