package org.customCollection.Test;

import static org.junit.Assert.*;

import org.customCollection.Impl.CustomArrayList;
import org.junit.Before;
import org.junit.Test;

public class CustomArrayListTest {
	CustomArrayList<Object> empty;
	CustomArrayList<Object> one;
	CustomArrayList<Object> many;
	
	@Before
	public void setup(){
		
		empty = new CustomArrayList<Object>();
		one = new CustomArrayList<Object>();
		many = new CustomArrayList<Object>();
		
		one.add("one");
		many.add("one");
		many.add("two");
		many.add("three");
		
	}
	
	@Test
	public void isEmptyTest(){
		assertEquals(true,empty.isEmpty());
		assertEquals(false,one.isEmpty());
		assertEquals(false,many.isEmpty());
	}
	
	@Test
	public void addTest(){
		many.add("four");
		assertEquals(0,empty.size());
		assertEquals(1,one.size());
		assertEquals(4,many.size());
	}
	
	@Test
	public void removeTest(){
		one.remove();
		many.remove();
		many.remove();
		assertEquals(0,one.size());
		assertEquals(false, one.contains("one"));
		assertEquals(1,many.size());
	}
	
	@Test
	public void getTest(){
		assertEquals("one",one.get(0));
		assertEquals("two",many.get(1));
		assertEquals(null,many.get(-1));
		assertEquals(null,many.get(5));
	}
	
	@Test 
	public void removeAtIndex(){
		many.remove(1);
		assertEquals(2,many.size());
		assertEquals("three",many.get(1));
	}
	
	@Test
	public void addAtIndex(){
		many.add(1,"1");
		many.add(3,"manoj sir");
		assertEquals(5,many.size());
		assertEquals("1",many.get(1));
	}
	
	
	@Test
	public void addAllTest(){
		CustomArrayList<Object> temp = new CustomArrayList<Object>();
		temp.add("one");
		temp.add("two");
		temp.add("three");
		temp.add("one");
		many.addAll(one);
		assertEquals(4,many.size());
		assertTrue(temp.equals(many));
	}

	@Test
	public void equalTest(){
		CustomArrayList<Object> temp = new CustomArrayList<Object>();
		assertTrue(temp.equals(empty));
		assertFalse(temp.equals(many));
		temp.add("one");
		temp.add("two");
		temp.add("three");
		assertTrue(temp.equals(many));
		assertFalse(temp.equals(one));
	}

}
