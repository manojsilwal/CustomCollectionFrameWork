package org.customCollection.map;

import org.customCollectionException.KeyAlreadyExistException;

public interface CustomMap<K,V> {
	public void put(K key, V value) throws KeyAlreadyExistException;
	public void remove(K key);
	public int size();
	public boolean isEmpty();
	public V get(K key);
	public int hashValue(int hash);
	public boolean containsKey(K key);
	public boolean containsValue();
	
}
