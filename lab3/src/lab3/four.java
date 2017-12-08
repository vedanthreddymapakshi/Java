package lab3;

import java.util.Random;

public class four {

	public static void main(String args[])
	{
		Random rand=new Random();
		int r=Math.abs(rand.nextInt()%3+1);
		System.out.println("Random Number Generation: "+ r);
	}
}
