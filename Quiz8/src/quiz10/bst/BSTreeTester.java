package quiz10.bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTreeTester {

	@Test
	public void test_add() {
		BSearchTree<Integer> intTree = new BSearchTree<Integer>(new Integer[] { 4, 3, 6, 1, 7, 5 });
		assertEquals(intTree.toString(), "4 3 6 1 5 7 ");
	}

	@Test
	public void test_find() {
		BSearchTree<Integer> intTree = new BSearchTree<Integer>(new Integer[] { 4, 3, 6, 1, 7, 5 });
		assertTrue(intTree.find(3));
		assertTrue(intTree.find(1));
		assertTrue(intTree.find(7));
		assertFalse(intTree.find(8));
		assertFalse(intTree.find(0));
	}

	@Test
	public void test_remove() {
		BSearchTree<Integer> intTree = new BSearchTree<Integer>(new Integer[] { 4, 3, 6, 1, 7, 5 });
		intTree.remove(4);
		String str = intTree.toString();
		assertTrue(str.equals("5 3 6 1 7 ") || str.equals("3 1 6 5 7 "));
	}
	
	@Test
	public void tes_remove2() {
		BSearchTree<Integer> intTree = new BSearchTree<Integer>(new Integer[] {4,3,6,1,7,5});
		intTree.remove(5);
		String str = intTree.toString();
		assertTrue()
		
	}
}
