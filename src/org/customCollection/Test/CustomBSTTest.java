package org.customCollection.Test;

import static org.junit.Assert.*;

import org.customBST.CustomBST;
import org.junit.Before;
import org.junit.Test;

public class CustomBSTTest {
	CustomBST<Integer> empty ;
	CustomBST<Integer> one ;
	CustomBST<Integer> many ;
	
	@Before
	public void setup(){
		empty = new CustomBST<Integer>(); 
		one = new CustomBST<Integer>();
		many = new CustomBST<Integer>();
		
		one.add(10);
		many.add(14);
		many.add(8);
		many.add(16);
		many.add(4);
	}
	
	/*@Test
	public void isEmptyTest(){
		one.add(10);
		many.add(14);
		many.add(8);
		many.add(16);
		
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(many.isEmpty());
	}
	*/
	
	@Test
	public void addTest(){
		assertEquals(1,one.size());
		assertEquals(4,many.size());
		assertTrue(one.contains(10));
		assertFalse(one.contains(11));
		assertTrue(many.contains(16));
		
	}
	
}
