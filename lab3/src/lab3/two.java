package lab3;
import java.util.Scanner;

public class two {

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please input your grades: " );
		String one=in.next();
		String two=in.next();
		String thr=in.next();
		double f=0;
		double s=0;
		double t=0;
		
		if(one.equals("A"))
		{
			f=4;
		}
		
		else if(one.equals("B"))
		{
			f=3;
		}
		
		else if(one.equals("C"))
		{
			f=2;
		}
		else if(one.equals("D"))
		{
			f=1;
		}
		else f=0;
		
		if(two.equals("A"))
		{
			s=4;
		}
		
		else if(two.equals("B"))
		{
			s=3;
		}
		
		else if(two.equals("C"))
		{
			s=2;
		}
		else if(two.equals("D"))
		{
			s=1;
		}
		else s=0;
		
		if(thr.equals("A"))
		{
			t=4;
		}
		
		else if(thr.equals("B"))
		{
			t=3;
		}
		
		else if(thr.equals("C"))
		{
			t=2;
		}
		else if(thr.equals("D"))
		{
			t=1;
		}
		else t=0;
		
		double gpa=(f+s+t)/3;
		
	System.out.println("Your gpa is: "+gpa );
	}

		
	}

