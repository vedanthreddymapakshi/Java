package testing;
import java.util.*;

public class tt {
	public static void main(String args[])
	{
		double avg=0; double sum=0;
		for(int i=1;i<=5;i++)
		{
			Scanner in=new Scanner(System.in);
			double n=in.nextDouble();

			sum=sum+n;
			System.out.println(sum);
			avg=sum/i;
			System.out.println(i);
			System.out.println(avg);
			
		}
	}
		
}