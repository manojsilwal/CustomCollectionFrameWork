package org.customCollection.Impl;

public interface CustomCollection <T>{
	public void add(T item);
	public void remove();
	public T get(int index);
	public boolean isEmpty();
	public int size();
	void remove(int index);
}
