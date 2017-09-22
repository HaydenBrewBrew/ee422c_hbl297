package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSortTest {

	@Test(timeout=2000)
	public void test() {
		//detects error in the x.length -1 limit in the for loop
		 int[] bad = new int[] {5,4,3,2,1};
		 int[] bad1 = new int[] {1,2,3,4,5};
 		SelectionSort.sort(bad);
 		assertArrayEquals(bad,bad1);
	}
	
	@Test(timeout=2000)
	public void test1() {
		//detects error in duplicates
		 int[] bad = new int[] {4,4,3,2,2};
		 int[] bad1 = new int[] {2,2,3,4,4};
 		SelectionSort.sort(bad);
 		assertArrayEquals(bad,bad1);
	}

	@Test(timeout=2000)
	public void test2() {
		//detects errors in the swap function
		int[] good = new int[] {1,1,1,1,0};
		int[] good1 = new int[] {0,1,1,1,1};
		SelectionSort.sort(good);
		assertArrayEquals(good, good1);
	}	
	
	@Test(timeout=2000)
	public void test3() {
		//detects errors with small arrays
		int[] good = new int[] {11,12};
		int[] good1 = new int[] {12,11};
		SelectionSort.sort(good1);
		assertArrayEquals(good, good1);
	}
	
	@Test(timeout=2000)
	public void test4() {
		//detects errors with all duplicates 
		int[] good = new int[] {2,2,2,2,2,2};
		int[] good1 = new int[] {2,2,2,2,2,2};
		SelectionSort.sort(good1);
		assertArrayEquals(good, good1);
	}
}
