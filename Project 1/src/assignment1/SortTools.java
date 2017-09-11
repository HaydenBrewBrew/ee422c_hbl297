// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * <Student Name>
 * <Student EID>
 * <5-digit Unique No.>
 * Spring 2017
 * Slip days used: 
 */

package assignment1;
import java.util.Arrays;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		if(n<=0){ //This test is to ensure all n=0 inputs return false
			return false;
		}
		for(int i = 0; i < n - 1; i++ ){//checks if a number is 
			if(x[i] > x[i+1]){ 			//greater than the previous number
				return false;			
			}
		}
		return true;					//true the if statement is not triggered
	}

	public static int find(int[] x, int n, int v) {//Searches the first n elements of 
		int index1 = 0;							// array for the input , returns index	
		int index2 = n - 1;
		int mid; 
		while(index2 > index1){
			mid = (index1 + index2)/2;
			if(x[mid] == v){
				return mid;
			}
			if (x[mid] > v ){
				index2 = mid;
			}
			else{
				index1 = mid;
			}
		}
		return (-1);
	}

	public static int[] insertGeneral(int[] x, int n, int v) {
		 int[] r = new int[n+1];
		 int index;
		 int flag=0;
		 for(index = 0; index < n; index++){ 
			 if(x[index]==v){
				 return(Arrays.copyOfRange(x, 0,n));
			 }
			 if(flag == 1){
				 r[index+1] = x[index];
			 }
			 else{
				 r[index] = x[index];
			 if(x[index]>v){
				 r[index] = v;
				 r[index+1] = x[index];
				 flag = 1;
			 }
			 }
		 }
		 if(x[n-1] < v){
		 r[n] = v;
		 }
		 return r;
		}
	public static int insertInPlace(int[] x, int n, int v){
		
		return 0;
	}

	public static void insertSort(int[] x, int n){
		for(int i = 1; i<n; i++){
			int v = x[i];
			int k;
			for(k = i - 1; k>=0; k--){
				if(x[k] <= v){
					break;
				}
				x[k+1] = x[k];
			}
			x[k+1] = v;
		}
	}
}
	
