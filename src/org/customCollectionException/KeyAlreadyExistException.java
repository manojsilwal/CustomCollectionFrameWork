package org.customCollectionException;

public class KeyAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public KeyAlreadyExistException(){
		super("Key Already Exist");
	}
	
	public KeyAlreadyExistException(String msg){
		super(msg);
	}
	
}
