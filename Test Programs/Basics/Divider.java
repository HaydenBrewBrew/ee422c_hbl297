import java.util.Scanner;

public class Divider{

	public static void main(String[] args){
	Scanner in  = new Scanner(System.in);
	
	System.out.println("Input First Number:");
	float num1 = in.nextFloat();
	
	System.out.println("Input Second Number:");
	float num2 = in.nextFloat();

	System.out.println(num1 + " / " + num2 + " = " + num1/num2);
}
}
