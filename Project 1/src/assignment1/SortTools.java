// SortTools.java 
/*
 * EE422C Project 1 submission by Hayden Lydick
 * Hayden Lydick
 * hbl297
 * 16290
 * Spring 2017
 * Slip days used: 0
 */

package Assignment1;
import java.util.Arrays;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		if(n<=0){ //solves edge condition of n=0
			return false;
		}
		//Checks if a number in the array is greater than the next number in the array
		for(int i = 0; i < n - 1; i++ ){
			if(x[i] > x[i+1]){ 			
				return false;			
			}
		}
		return true;					
	}
//Searches 
	/**
	 * This method tests to see if the array possess a value v
	 * @param x: array to be tested
	 * @param n: length of array
	 * @param v: value to search for
	 * @return index of value or -1 if not found
	 */
	public static int find(int[] x, int n, int v) {
		//binary sort
		int index1 = 0;//lower index							
		int index2 = n - 1;//higher index
		int mid; //center
		while(index2 >= index1){
			mid = (index1 + index2)/2;//find midpoint of the two index
			if(x[mid] == v){//return if mid is the location of v
				return mid;
			}
			if (x[mid] > v ){//set new upper bound if v is less than mid
				index2 = mid-1;
			}
			else{//set new lower bound if v is greater than mid
				index1 = mid+1;
			}
		}
		return (-1);//value not found
	}
	
	/**\
	 * This method returns a new array of length n+1 with the value v inserted: non decreasing order
	 * @param x array to copy and insert
	 * @param n length of array
	 * @param v value to add
	 * @return array of n+1 length if v is not within the array already, length n if already present
	 */
	
	public static int[] insertGeneral(int[] x, int n, int v) {
		//creates new array and initializes variables
		 int[] r = new int[n+1];
		 int index;
		 int flag=0;
		 if(n==0){//checks for edge case of n=0
			 r[n]=v;
			 return r;
		 }
		 for(index = 0; index < n; index++){ //cycle through all index
			 if(x[index]==v){//checks for v and return a copy of array if found
				 return(Arrays.copyOfRange(x, 0,n));
			 }
			 if(flag == 1){//shifts storage of x data by + 1 in new array r if v is placed
				 r[index+1] = x[index];
			 }
			 else{//inputs data from x into r
				 r[index] = x[index];
			 if(x[index]>v){//sets placed flag when v's location is found
				 r[index] = v;
				 r[index+1] = x[index];
				 flag = 1;
			 }
			 }
		 }
		 if(x[n-1] < v){//checks for edge condition where v> all current array values
			 r[n] = v;
		 }
		 return r;
		}
	
	/**
	 * This method edits the original array to insert the value v within it: non decreasing order
	 * @param x array to edit
	 * @param n length of array
	 * @param v value to insert
	 * @return
	 */
	
	public static int insertInPlace(int[] x, int n, int v){
		int index;
		//checks for v
		//modification of insertion sort
		if(find(x,n,v)!= -1){
			return n;
		}
		
		for(index = n; index > 0; index--) {//cycles from last array value to first
			if(x[index-1] < v) {//places v when location is found
				x[index] = v;
				break;
			}
			x[index] = x[index - 1];//shifts all data over 1 index until v location is found 
		}
		if(index==0){// checks for edge condition that v is < all values in array
			x[0] = v;
		}
		return n+1;
	}
/**
 * Sorts an array in non-decreasing order
 * @param x array to be sorted 
 * @param n length of the array
 */
	public static void insertSort(int[] x, int n){
		//insert sort algorithm
		for(int i = 1; i<n; i++){
			int v = x[i];//sets current value to be sorted
			int k;//location to sort from 
			for(k = i - 1; k>=0; k--){//shifts all data over 1 index until current value is sorted
				if(x[k] <= v){
					break;
				}
				x[k+1] = x[k];//shift data by 1 index
			}
			x[k+1] = v;
		}
	}
}
	
