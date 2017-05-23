package org.customCollection.Impl;

public interface CustomList<T> extends CustomCollection<T>{
	public void add(int index, T item);
	public void addAll(CustomList<T> list);
	public void clear();
	public boolean contains(T item);
	public boolean containsAll(CustomArrayList<T> list);
	public boolean equals(CustomList<Object> list);
}
