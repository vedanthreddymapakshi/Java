//Vedanth Mapkashi HW1
import java.util.Scanner;
public class two {

	public static void main(String args[])
	{
		Scanner in= new Scanner(System.in);
		int first=0;
		int count=0;
		int sif=in.nextInt();
		int size=in.nextInt();
		int [][]c=new int[size][2];
		int [] a= new int[sif];
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<2;j++)
			{
				c[i][j]=in.nextInt(); //input into multidimensional array
			}
		}
		
		first=in.nextInt();
		
		for(int i=0;i<sif;i++)
		{
			a[i]=0; //initialize
		}
		 //checking for the first first time
		for(int i=0;i<size;i++)
		{
			int j=0;
				if(first==c[i][j])
				{
					count++;
					a[i]=c[i][j+1];
				}

		}
			
		for(int i=0;i<count;i++)
		{
			for(int j=0;j<size;j++)
			{
				int k=0;
				
				if(a[i]==c[j][k])
				{	int cc=0;
					for(int x=0;x<count;x++)
					{
						if(c[j][k+1]==a[x])
							cc++;
					}
					if(cc==0)
					count++;
				}
			}
		}
		System.out.println(count);
	}
}