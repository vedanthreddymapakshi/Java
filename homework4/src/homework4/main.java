package homework4;
import java.io.*;
import java.util.*;

public class main
{
	public static void main(String args[]) throws IOException
	{
		customers c=new customers();
		inventory iv=new inventory();
		String adminusername="admin";
		String adminpassword="password";
		Scanner in=new Scanner(System.in);
		System.out.println("Welcome to Carmax!");
		c.initmems();
		iv.initcars();
		int loopn=0; //outer loop variable
		while(loopn!=3)
		{
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit");
			loopn=in.nextInt();//get user choice for outer loop
			
			if(loopn==1)
			{
					String uid="";
					String upwd="";
					System.out.println("Enter user id: ");
					uid=in.next();
					System.out.println("Enter password:");
					upwd=in.next();
					if(uid.equals(adminusername) && upwd.equals(adminpassword))
					{
						System.out.println("Welcome Back Admin!");
						int adminchoice=0;
							
						while(adminchoice!=9)
						{
							System.out.println("1. Display inventory");
							System.out.println("2. Add cars");
							System.out.println("3. Delete Car");
							System.out.println("4. Update Car");
							System.out.println("5. Display users");
							System.out.println("6. Add user");
							System.out.println("7. Update user");
							System.out.println("8. Delete user");
							System.out.println("9. logout");
							adminchoice=in.nextInt();
								
							if(adminchoice==1)
							{
								iv.display();
							}
							else if(adminchoice==2)
							{
								iv.addcar();
							}
							else if(adminchoice==3)
							{
								iv.deletecar();
							}
							else if(adminchoice==4)
							{
								iv.updatecar();
							}
							else if(adminchoice==5)
							{
								c.display();
							}
							else if(adminchoice==6)
							{
								c.adduser();
							}
							else if(adminchoice==7)
							{
								c.updateuser();
							}
							else if(adminchoice==8)
							{
								c.deleteuser();
							}
								
						}
					}
					else
					{		
						int custindex=c.login(uid,upwd);
						if(custindex!=10000)
						{
							System.out.println("Welcome back "+ c.mems[custindex].fn+c.mems[custindex].fn);
							int loopn2=0;
							while(loopn2!=5)
							{
								System.out.println("1. Display inventory");
								System.out.println("2. Sort Cars");
								System.out.println("3. Save a car");
								System.out.println("4. Display Saved Cars");
								System.out.println("5. Exit");
								loopn2=in.nextInt();
								
								if(loopn2==1)
								{
									iv.display();
								}
								
								else if(loopn2==2)
								{
									iv.sort();
									iv.display(); 
								}
								else if(loopn2==3)
								{
									iv.saveacar();
									
								}
							}
						}
					}
			}//outer if
			else if(loopn==2)
			{
				c.signup();
			}
		}//while
		
		c.save();
		iv.save();
	}
}

