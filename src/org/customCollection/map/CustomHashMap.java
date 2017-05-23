package org.customCollection.map;

import java.util.Iterator;
import java.util.LinkedList;

import org.customCollectionException.KeyAlreadyExistException;

public class CustomHashMap<K,V> implements CustomMap<K,V>{
	private int tableSize;
	private int size = 0;
	private LinkedList<Node<K,V>>[] elements;
	
	public CustomHashMap(){
		tableSize = 10;
		elements = new LinkedList[tableSize];
	}
	
	public CustomHashMap(int value){
		tableSize = value;
		elements = new LinkedList[tableSize];
	}

	@Override
	public void put(K key, V value) throws KeyAlreadyExistException{
		
		/*check weather key already exist or not*/
		if(this.containsKey(key)){
			throw new KeyAlreadyExistException("Key already exist");
		}
		
		Node<K,V> node = new Node<K,V>();
		node.setKey(key);
		node.setValue(value);
		int index = this.hashValue(key.hashCode());
		if(elements[index] == null){
			elements[index] = new LinkedList<Node<K,V>>();
			elements[index].add(node);
		}
		else
			elements[index].add(node);
		
		size++;
		
	}

	@Override
	public void remove(K key) {
		int index = this.hashValue(key.hashCode());
		if(elements[index] == null){
			return;
		}
		Node<K,V> temp;
		Iterator<Node<K,V>> it = elements[index].iterator();
		while(it.hasNext()){
			temp = it.next();
			if(temp.getKey().equals(key));{
				it.remove();
			}
		}
		size--;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size > 0)
			return false;
		return true;
	}

	@Override
	public V get(K key) {
		int index = this.hashValue(key.hashCode());
		if(elements[index] == null){
			return null;
		}
		Node<K,V> temp;
		Iterator<Node<K,V>> it = elements[index].iterator();
		while(it.hasNext()){
			temp = it.next();
			if(temp.getKey().equals(key))
				return temp.getValue();
		}
		return null;
	}

	@Override
	public int hashValue(int hash) {
		return hash % tableSize;
	}

	@Override
	public boolean containsKey(K key) {
		int index = this.hashValue(key.hashCode());
		if(elements[index] == null){
			return false;
		}
		Iterator<Node<K,V>> it = elements[index].iterator();
		Node<K,V> temp;
		while(it.hasNext()){
			temp = it.next();
			if(temp.getKey().equals(key)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
		
}
