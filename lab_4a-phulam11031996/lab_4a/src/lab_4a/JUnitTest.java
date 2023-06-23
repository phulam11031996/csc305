package lab_4a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTest {
	private Multiset<Integer> testIntObj = new MyLinkedList<Integer>();
	private Multiset<String> testStrObj = new MyLinkedList<String>();

	@Test
	void testAddInt() {
		this.testIntObj.add(1);
		assertEquals(1, this.testIntObj.size());
	}

	@Test
	void testAddStr() {
		this.testStrObj.add("hello");
		assertEquals(1, this.testStrObj.size());
	}

	@Test
	void testRemoveStrFalse() {
		this.testStrObj.add("hello");
		this.testStrObj.add("there");
		boolean res = this.testStrObj.remove("yo");
		assertFalse(res);
	}

	@Test
	void testRemoveIntFalse() {
		this.testIntObj.add(1);
		this.testIntObj.add(2);
		boolean res = this.testIntObj.remove(3);
		assertFalse(res);
	}

	@Test
	void testRemoveTrue() {
		this.testStrObj.add("hello");
		this.testStrObj.add("there");
		boolean res = this.testStrObj.remove("there");
		assertTrue(res);
	}

	@Test
	void testRemoveIntTrue() {
		this.testIntObj.add(1);
		this.testIntObj.add(2);
		boolean res = this.testIntObj.remove(1);
		assertTrue(res);
	}

	@Test
	void testCountStr() {
		this.testStrObj.add("hello");
		this.testStrObj.add("hello");
		this.testStrObj.add("there");
		assertEquals(2, this.testStrObj.count("hello"));
	}

	@Test
	void testCountInt() {
		this.testIntObj.add(1);
		this.testIntObj.add(2);
		this.testIntObj.add(2);
		assertEquals(2, this.testIntObj.count(2));
	}

	//	ask about this
	@Test
	void testGrabStr() {
		assertEquals("hello", this.testStrObj.grab());
	}

	@Test
	void testGrabInt() {
		this.testIntObj.add(1);
		this.testIntObj.add(2);
		this.testIntObj.add(2);
		assertEquals(1, this.testIntObj.grab());
	}

}
