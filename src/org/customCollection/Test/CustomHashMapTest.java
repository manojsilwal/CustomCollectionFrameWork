package org.customCollection.Test;

import static org.junit.Assert.*;

import org.customCollection.map.CustomHashMap;
import org.customCollection.map.CustomMap;
import org.customCollectionException.KeyAlreadyExistException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomHashMapTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	CustomMap<Object, Object> empty;
	CustomMap<Object, Object> one;
	CustomMap<Object, Object> many;
	
	@Before
	public void setup(){
		empty = new CustomHashMap<Object,Object>();
		one = new CustomHashMap<Object,Object>();
		many = new CustomHashMap<Object,Object>();

	}
	
	@Test
	public void isEmptyTest() throws KeyAlreadyExistException{
		
		many.put("manoj", "manoj");
		one.put("manoj", "manoj");
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(many.isEmpty());
	}
	
	@Test
	public void putTest() throws KeyAlreadyExistException{
		thrown.expect(KeyAlreadyExistException.class);
		thrown.expectMessage("Key already exist");
		
		many.put("manoj", "manoj");
		one.put("manoj", "manoj");
		many.put("manoj", "manoj");
		
		assertEquals("manoj",one.get("manoj"));
		assertEquals(1,one.size());
		assertEquals(1,many.size());
	}
}
