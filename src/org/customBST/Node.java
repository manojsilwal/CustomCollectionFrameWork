package org.customBST;

public class Node<V> {
	private V value;
	private Node<V> left;
	private Node<V> right;
	
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Node<V> getLeft() {
		return left;
	}
	public void setLeft(Node<V> left) {
		this.left = left;
	}
	public Node<V> getRight() {
		return right;
	}
	public void setRight(Node<V> right) {
		this.right = right;
	}
	
	
}