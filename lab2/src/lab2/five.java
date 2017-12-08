package lab2;
import java.util.Scanner;

public class five {
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Whats your name? ");
		String name=in.nextLine();
		System.out.println("Hi "+name);
		System.out.println("What is your favourite sport team? ");
		String team=in.nextLine();
		System.out.println("Do you think the "+team +" will win the league? ");
		String ans=in.nextLine();
		System.out.println("Thank you!");
		
	}

}
