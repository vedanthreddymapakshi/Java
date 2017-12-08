 package lab5;
import java.util.Scanner;

public class one {

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		char []one=new char[5];
		char []two=new char[5];
		System.out.println("Enter first word: ");
			one=in.next().toCharArray();
		
		System.out.println("Enter second word: ");
			two=in.next().toCharArray();
		
		int count=0;
		
		for(int i=0;i<5;i++)
		{
			if(one[i]!=two[i])
				count++;
		}
		
		if(count==0)
			System.out.println("1");
		else
			System.out.println("0");
	}
	
}