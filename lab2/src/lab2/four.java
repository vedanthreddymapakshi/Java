package lab2;
import java.util.Scanner;

public class four {

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Input the height of the cylinder: ");
		double h=in.nextDouble();
		System.out.println("Input the radius of the cylinder: ");
		double r=in.nextDouble();
		System.out.println("Processing..");
		double v=3.14*r*r*h;
		System.out.println("The volume of the cylinder is"+ v);	
		
		
	}
	
}
