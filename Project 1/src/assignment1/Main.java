/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package Assignment1;
import java.util.Arrays;
public class Main {
	public static void main(String [] args) {

		//test everything except time complexity
        int[] e = {};
        int [] a = {1};
        int [] aa = {2,1};//multiple instances
        int [] b = {0,1,7,4,2,1,7,5,2,1,45,6,8,4,1,1,4,6,8,34,6,6,4}; //multiple instances
        int [] c = {0,1,2,3,4,5,6,7,8,9};//in order
        int [] d = {9,8,7,6,5,4,3,2,1}; //in reserve order
        System.out.println("~~~~~~ISSORTED~~~~~~");
        System.out.println("false: " + SortTools.isSorted(e, 0));
        System.out.println("false: " + SortTools.isSorted(a, 0));
        System.out.println("false: " + SortTools.isSorted(b, 0));
        System.out.println("true: " + SortTools.isSorted(a, 1));
        System.out.println("false: " + SortTools.isSorted(aa, 2));
        System.out.println("true: " + SortTools.isSorted(b, 2));
        System.out.println("false: " + SortTools.isSorted(b, b.length));
        System.out.println("true: " + SortTools.isSorted(c, c.length));
        System.out.println("true: " + SortTools.isSorted(c, 5));
        System.out.println("false: " + SortTools.isSorted(d, d.length));
        System.out.println("false: " + SortTools.isSorted(d, d.length-3));
        
        System.out.println("\n~~~~~~INSERTSORT~~~~~~");
        SortTools.insertSort(a, 1);
        System.out.println("[1]: " + Arrays.toString(a));
        SortTools.insertSort(aa, 2);
        System.out.println("[1,2]: " + Arrays.toString(aa));
        SortTools.insertSort(b, 10);
        System.out.println("[0,1,1,1,1,1,2,2,5,7 + the rest]: " + Arrays.toString(b));
        SortTools.insertSort(b, b.length);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45]: " + Arrays.toString(b));
        SortTools.insertSort(c, 6);
        System.out.println("[0,1,2,3,4,5,6,7,8,9]: " + Arrays.toString(c));
        SortTools.insertSort(c, c.length);
        System.out.println("[0,1,2,3,4,5,6,7,8,9]: " + Arrays.toString(c));
        SortTools.insertSort(c, c.length);
        System.out.println("[0,1,2,3,4,5,6,7,8,9]: " + Arrays.toString(c));
        SortTools.insertSort(d, d.length);
        System.out.println("[1,2,3,4,5,6,7,8,9]: " + Arrays.toString(d));
       
        System.out.println("\n~~~~~~FIND~~~~~~");
        System.out.println("-1: " + SortTools.find(a, 1, 0));
        System.out.println("0: " + SortTools.find(a, 1, 1));
        System.out.println("0: " + SortTools.find(aa, 2, 1));
        System.out.println("1: " + SortTools.find(aa, 2, 2));
        System.out.println("-1: " + SortTools.find(b, 10, 5));
        System.out.println("6 or 7: " + SortTools.find(b, 10, 2));
        System.out.println("12: " + SortTools.find(b, b.length, 5));
        System.out.println("0: " + SortTools.find(b, b.length, 0));
        System.out.println( b.length -1 +": " + SortTools.find(b, b.length, 45));
        System.out.println("-1: " + SortTools.find(b, b.length, 46));
        System.out.println("22: " + SortTools.find(b, b.length, 45));
        System.out.println("5: " + SortTools.find(c, c.length, 5));
        System.out.println("-1: " + SortTools.find(c, c.length, 50));
        
        System.out.println("\n~~~~~~INSERTGENERAL~~~~~~");
        int [] x = SortTools.insertGeneral(a, 0, 1);
        System.out.println("[1]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(a, 1, 1);
        System.out.println("[1]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(a, 1, 2);
        System.out.println("[1,2]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, 0, 3);
        System.out.println("[3]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, 10, 1);
        System.out.println("[0,1,1,1,1,1,2,2,4,4]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, 10, 3);
        System.out.println("[0,1,1,1,1,1,2,2,3,4,4]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, 10, 5);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,5]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, b.length, 0);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, b.length, 4);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, b.length, 45);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, b.length, 10);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,10,34,45]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, b.length, -5);
        System.out.println("[-5,0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45]: " + Arrays.toString(x));
        x = SortTools.insertGeneral(b, b.length, 46);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45,46]: " + Arrays.toString(x));
                
        System.out.println("\n~~~~~~INSERTINPLACE~~~~~~");
        int al = SortTools.insertInPlace(a, 1,1);
        System.out.println("[1] 1: " + Arrays.toString(a)+ " " + al);
        al = SortTools.insertInPlace(aa, 1,2);
        System.out.println("[1,2] 2: " + Arrays.toString(aa)+ " " + al);
        al = SortTools.insertInPlace(aa, 1, 0);
        System.out.println("[0,1] 2: " + Arrays.toString(aa)+ " " + al);
        al = SortTools.insertInPlace(b, b.length-1, 0);
        System.out.println("[0,1,1,1,1,1,2,2,4,4,4,4,5,6,6,6,6,7,7,8,8,34,45] "+ (b.length-1)  + ": " + Arrays.toString(b)+ " " + al);
        al = SortTools.insertInPlace(b, b.length-1, 3);
        System.out.println("[0,1,1,1,1,1,2,2,3,4,4,4,4,5,6,6,6,6,7,7,8,8,34] "+ (b.length)  + ": " + Arrays.toString(b)+ " " + al);
        al = SortTools.insertInPlace(b, b.length-1, 46);
        System.out.println("[0,1,1,1,1,1,2,2,3,4,4,4,4,5,6,6,6,6,7,7,8,8,34,46] "+ (b.length)  + ": " + Arrays.toString(b)+ " " + al);
        al = SortTools.insertInPlace(b, b.length-1, 46);
        System.out.println("[0,1,1,1,1,1,2,2,3,4,4,4,4,5,6,6,6,6,7,7,8,8,34,46] "+ (b.length)  + ": " + Arrays.toString(b)+ " " + al);
        al = SortTools.insertInPlace(b, 10, 5);
        System.out.println("[0,1,1,1,1,1,2,2,3,4,5,DONT CARE-->4,4,5,6,6,6,6,7,7,8,8,34,45] "+ 11  + ": " + Arrays.toString(b)+ " " + al);
        al = SortTools.insertInPlace(b, 10, -5);
        System.out.println("[-5,0,1,1,1,1,1,2,2,3,4,DONT CARE-->4,4,5,6,6,6,6,7,7,8,8,34,45] "+ 11  + ": " + Arrays.toString(b)+ " " + al);
        al = SortTools.insertInPlace(b, 10, -5);
        System.out.println("[-5,0,1,1,1,1,1,2,2,3,DONT CARE-->4,4,5,6,6,6,6,7,7,8,8,34,45] "+ 10  + ": " + Arrays.toString(b)+ " " + al);
                  
	}
}
