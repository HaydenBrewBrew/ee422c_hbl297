package assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SortToolsTest {
	
	@Test(timeout = 2000)
	public void testIsSorted(){
		int[] bad = new int[] {6,5,4,3,2,1};
		int[] x = new int[]{1, 2, 3, 4, 5, 6};
		int[] y = new int[]{1};
		int[] z = new int[]{0};
		int[] rep = new int[] {1,1,1,1,1,1,1,1,1,1,};
		assertEquals(true, SortTools.isSorted(x, 3));
		assertEquals(true, SortTools.isSorted(y, 1));
		assertEquals(false, SortTools.isSorted(z, 0));
		assertEquals(false, SortTools.isSorted(bad,5));
		assertEquals(false, SortTools.isSorted(bad, 0));
		assertEquals(true, SortTools.isSorted(rep, 7));
	}
	@Test(timeout = 2000)
	public void testFindFoundFull(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(3, SortTools.find(x, 6, 1));
		assertEquals(1, SortTools.find(x, 6, -1));
		
	}
	
	@Test(timeout = 2000)
	public void testInsertGeneralPartialEnd(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30};
		int[] expected2 = new int[]{10, 20, 30,35};
		int[] expected3 = new int[]{5, 10, 20, 30};
		int[] expected4 = new int[]{ 10, 20, 25, 30};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 20));
		assertArrayEquals(expected3, SortTools.insertGeneral(x, 3, 5));
		assertArrayEquals(expected2, SortTools.insertGeneral(x, 3, 35));
		assertArrayEquals(expected4, SortTools.insertGeneral(x, 3, 25));
		assertArrayEquals(x,SortTools.insertGeneral(x, 5, 20));
		
	}
	@Test(timeout = 2000)
	public void testinsertSortPartialEnd(){
		int[] x = new int[]{20, 10, 30, 40, 50};
		int[] result1 = new int[] {10,20,30,40,50};
		SortTools.insertSort(x,5);
 		assertArrayEquals(result1, x );
	}
}
