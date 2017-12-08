package lab2;
	import java.util.Scanner;

	public class two {
		
		public static void main(String args[])
		{
			Scanner in=new Scanner(System.in);
			System.out.println("When were you born? ");
			int year=in.nextInt();
			System.out.println("Processing..");
			System.out.println("You are "+ (2017-year) +" years old");	
			
		}

	}


