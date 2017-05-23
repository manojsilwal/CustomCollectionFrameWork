package org.customBST;

public class CustomBST<V extends Comparable<V>> implements CustomTree<V>{
	private Node<V> root;
	private int size;
	
	@Override
	public void add(V value) {
		size++;
		Node<V> temp = new Node<V>();
		temp.setValue(value);
		
		if(root == null){
			root = temp;
			return;
		}
		recursiveAdd(root, temp);
		
	}
	
	private boolean recursiveAdd(Node<V> root, Node<V> value ){
		
		if(root.getValue().compareTo(value.getValue())>0){
			
			if(root.getLeft() == null){
				root.setLeft(value);
				return true;
			}
				
			return recursiveAdd(root.getLeft(),value);
		}
		else{
			if(root.getRight() == null){
				root.setRight(value);
				return true;
			}
			return recursiveAdd(root.getRight(),value);
		}
	}

	@Override
	public boolean remove() {
		return false;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(V value) {
		
		if(value == null)
			return false;
		else
			return recursiveContains(root, value);
		
	}
	
	private boolean recursiveContains(Node<V> root, V value){
		if(root.getLeft() == null && root.getRight() == null){
			if(root.getValue().equals(value))
				return true;
			else
				return false;
		}
		
		if(root.getValue().equals(value)){
			System.out.println(root.getValue().equals(value));
			return true;
		}
		else if(root.getValue().compareTo(value) > 0)
			return recursiveContains(root.getLeft(),value);
		else
			return recursiveContains(root.getRight(),value);
	}

	@Override
	public V first() {
		if(root == null)
			return null;
		else 
			return recursiveFirst(root);
	}
	
	public void inorder(){
		if(root == null)
			return;
		
		else
			recursiveInorder(root);
	}
	
	private void recursiveInorder(Node<V> root){
		if(root == null){
			return; 
		}
		
		else{
			recursiveInorder(root.getLeft());
			System.out.println(root.getValue());
			recursiveInorder(root.getRight());
		}
		
		
	}
	
	private V recursiveFirst(Node<V> root){
		if(root.getLeft() == null && root.getRight() == null){
			return root.getValue();
		}
		return recursiveFirst(root.getLeft());
	}


	@Override
	public int size() {
		return size;
	}
	
	
}
