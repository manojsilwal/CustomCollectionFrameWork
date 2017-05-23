package org.customCollectionLinkedList;

import org.customCollection.Impl.CustomArrayList;
import org.customCollection.Impl.CustomList;

public class CustomLinkedList<T extends Object> implements CustomList<T>{
	private Node head;
	private int size = 0;
	
	
	
	public CustomLinkedList(){
		head = new Node();
	}
	
	@Override
	public void add(T item) {
		Node temp = new Node();
		temp.setValue(item);
		/*if list is empty*/
		if(head.getNext() == null){
			temp.setPrev(head);
			head.setNext(temp);
			size++;
			return;
		}
		
		/*if list is not empty then find last tail node*/
		Node next = head.getNext();
		
		while(next.getNext()!=null){
			next = next.getNext();
		}
		
		/*insert new node to last*/
		temp.setPrev(next);
		next.setNext(temp);
		size++;
	}

	@Override
	public void remove() throws NullPointerException{
		
		if(head.getNext() == null){
			throw new NullPointerException("List is empty");
		}
		
		Node next = head.getNext();
		while(next.getNext()!=null){
			next = next.getNext();
		}
		Node lastElement = next.getPrev();
		lastElement.setNext(null);
		
		size--;
		
	}

	@Override
	public T get(int index) {
		Node next = head.getNext();
		if(index >= size){
			return null;
		}
		for(int i = 0; i < index;i++){
			next = next.getNext();
		}
		return (T) next.getValue();
	}

	@Override
	public boolean isEmpty() {
		if(size>0)
			return false;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void remove(int index) {
		
	}

	@Override
	public void add(int index, T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(CustomList<T> list) {
		if(list == null){
			return;
		}
		Node next = head.getNext();
		while(next.getNext()!=null){
			next = next.getNext();
		}
		
		for(int i = 0; i< list.size(); i++){
			Node temp = new Node();
			temp.setPrev(next);
			temp.setValue(list.get(i));
			next.setNext(temp);
			next = next.getNext();
		}
		
	}

	@Override
	public void clear() {
		head.setNext(null);
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(CustomArrayList<T> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(CustomList<Object> list) {
		// TODO Auto-generated method stub
		if(list.size()!=this.size()){
			return false;
		}
		for(int i = 0; i < list.size(); i++){
			if(this.get(i)!=list.get(i)){
				return false;
			}

		}
		
		
		return true;
	}
	
}
