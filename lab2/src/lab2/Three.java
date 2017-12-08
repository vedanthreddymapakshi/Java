package lab2;
import java.util.Scanner;


public class Three {

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please input the first integer value: ");
		int first=in.nextInt();
		System.out.println("Please input the second integer value: ");
		int second=in.nextInt();
		System.out.println("Processing..");
		System.out.println("Addition: "+(first+second));
		System.out.println("Subtraction: "+(first-second));
		System.out.println("Integer division: "+(first/second));
		System.out.println("Modulus: " +(first%second));
		
	}
}
