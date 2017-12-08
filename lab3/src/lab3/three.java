package lab3;
import java.util.Scanner;
public class three {

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter three numbers bruh: ");
		int one=in.nextInt();
		int two=in.nextInt();
		int thr=in.nextInt();
		int max=0;
		int min=0;
		
		
		if(one>two && one >thr)
		{
			max=one;
			if(thr>two)
				min=two;
			else min=thr;
		}
		else if(two>one && two >thr)
		{
			max=two;
			if(one>thr)
				min=thr;
			else min=one;
		}
		if(thr>two && thr >one)
		{
			max=thr;
			if(one>two)
				min=two;
			else min=one;
		}
		
		System.out.println("Max: "+max);
		System.out.println("Min: "+min);
		
		
		
	}
}
