package lab4;
import java.util.Scanner;
import java.util.Random;

public class five {
	public static void main(String args[])
	{
		String [] a={"Rock","Paper","Scissors"};
		Scanner in=new Scanner(System.in);
		Random rand=new Random();
		
		System.out.println("Start game");
		boolean t=true;
		while(t=true)
		{
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
		System.out.println("What do you wanna throw? ");
		int n=in.nextInt();
		int r=Math.abs(rand.nextInt()%3+1);
		String comp="";
		String msg="";
		String user="";
		if(r==1)
		{
			comp="Rock";
			if(n==1)
				msg="Its a draw!";
			else if(n==2)
				msg="You win!";
			else if(n==3)
				msg="You lose!";
		}
		else if(r==2)
		{
			comp="Paper";
			if(n==1)
				msg="You lose!!";
			else if(n==2)
				msg="Its a draw";
			else if(n==3)
				msg="You win!";
		}
		else if(r==3)
		{
			comp="Scissors";
			if(n==1)
				msg="You win!";
			else if(n==2)
				msg="You lose!";
			else if(n==3)
				msg="Its a draw!";
		}
		
		if(n==1)
			user="Rock";
		else if(n==2)
			user="Paper";
		else if(n==3)
			user="Scissors";
		
		System.out.println("Computer: " +comp +" vs " + "You: "+ user );
		System.out.println(msg);
		
		System.out.println("Do you wanna play again?: ");
		char ch=in.next().charAt(0);
		if(ch=='y'||ch=='Y')
			t=true;
		else if(ch=='n'||ch=='N')
		{
			t=false;
			break;
		}
		}
		if(t==false)
		System.out.println("Coool bye");
	}
	}

