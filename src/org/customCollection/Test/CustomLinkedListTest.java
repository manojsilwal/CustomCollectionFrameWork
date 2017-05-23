package org.customCollection.Test;

import static org.junit.Assert.*;

import org.customCollection.Impl.CustomList;
import org.customCollectionLinkedList.CustomLinkedList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomLinkedListTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	CustomList<Object> one;
	CustomList<Object> empty;
	CustomList<Object> many;
	
	@Before
	public void setup(){
		one = new CustomLinkedList<Object>();
		many = new CustomLinkedList<Object>();
		empty = new CustomLinkedList<Object>();
		
		one.add("one");
		many.add("one");
		many.add("two");
		many.add("three");
	}

	@Test
	public void isEmptyTest(){
		assertTrue(empty.isEmpty());
		assertFalse(many.isEmpty());
		assertFalse(one.isEmpty());
	}
	
	@Test
	public void add(){
		CustomList<Object> cus = new CustomLinkedList<Object>();
		assertEquals(0,cus.size());
		cus.add("one");
		assertEquals(1,cus.size());
		assertEquals("one",cus.get(0));
		assertNotSame("two",cus.get(0));
	}
	
	@Test
	public void removeTest(){
		thrown.expect(NullPointerException.class);
        thrown.expectMessage("List is empty");
        empty.remove();
		one.remove();
		many.remove();
        //you can test the exception message like     
        assertEquals(0,one.size());
        assertEquals(2,many.size());
		assertFalse(many.contains("three"));
		
	}
	
	@Test
	public void addAllTest(){
		CustomList<Object> list = new CustomLinkedList<Object>();
		list.add("one");
		assertTrue(list.equals(one));
		assertFalse(list.equals(many));
	}
	
	
}
