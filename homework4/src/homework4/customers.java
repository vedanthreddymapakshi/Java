package homework4;

	import java.io.*;
	import java.util.*;

	public class customers 
	{
		int nm=0;
		member[] mems = new member[100];

		public void initmems() throws FileNotFoundException 
		{
			for(int i=0;i<100;i++)
			{
				mems[i]=new member();
			}
			
			File textfile = new File("customers.txt");
			Scanner in=new Scanner(textfile);
		
			while (in.hasNextLine()) 
			{
				String line = in.nextLine();
				StringTokenizer st = new StringTokenizer(line, "/");
				while (st.hasMoreTokens()) 
				{
					mems[nm].id = st.nextToken();
					mems[nm].pwd = st.nextToken();
					mems[nm].fn = st.nextToken();
					mems[nm].ln = st.nextToken();
					mems[nm].email = st.nextToken();
				}
				nm++;
			}
		}
		

		public void display() 
		{
			System.out.println("ID" +"  " + "PASSWORD" + "  " + "FIRSTNAME" + "  " + "LASTNAME" + "  " + "EMAIL");
			for (int i = 0; i < nm; i++) 
			{
				System.out.println(mems[i].id + " " + mems[i].pwd + " " + mems[i].fn + " " + mems[i].ln + " "
						+ mems[i].email);
			}
			System.out.println(nm);
		}

		public void save() throws FileNotFoundException 
		{
			PrintWriter op = new PrintWriter("customers.txt");

			for (int i = 0; i < nm; i++) 
			{
				op.println(mems[i].id + "/" + mems[i].pwd + "/" + mems[i].fn + "/" + mems[i].ln + "/"
						+ mems[i].email);
			}

			op.close();

		}
		
		public void signup()
		{
			Scanner in=new Scanner(System.in);
			boolean t=false;
			while(t==false)
			{
				System.out.println("Enter id: ");
				mems[nm].id=in.next();
				System.out.println("Enter password: ");
				String temp=in.next();
				System.out.println("Re enter Password: ");
				String temp1=in.next();
				if(temp.equals(temp1))
				{
					mems[nm].pwd=temp;
					System.out.println("Enter first name: ");
					mems[nm].fn=in.next();
					System.out.println("Enter last name: ");
					mems[nm].ln=in.next();
					System.out.println("Enter mail: ");
					mems[nm].email=in.next();
					t=true;
					nm++;
				}
				
				else
				{
					System.out.println("Passwords didnt match bro");
				}
			}
			
			if(t==true)
			{
				System.out.println("Sign up successful");
			}
		}
		
		public int login(String tempid,String temppwd)
		{
			Scanner in=new Scanner(System.in);
			int i=0;
			boolean found=false;
				for(i=0;i<nm;i++)
				{
					if(mems[i].id.equals(tempid) && mems[i].pwd.equals(temppwd))
					{
						found=true;
						break;
					}
				}
				
				if(found==false)
				{
					System.out.println("Username and Password didnt match lol");
					return 10000;
				}
				
				else
				{
					return i;
				}
		}
		
		public void adduser()
		{
			Scanner in=new Scanner(System.in);
			System.out.println("Enter id: ");
			mems[nm].id=in.next();
			System.out.println("Enter password: ");
			mems[nm].pwd=in.next();
			System.out.println("Enter first name: ");
			mems[nm].fn=in.next();
			System.out.println("Enter last name: ");
			mems[nm].ln=in.next();
			System.out.println("Enter email: ");
			mems[nm].email=in.next();
			
			System.out.println("ID" + "  " +"PASSWORD"+"  "+ "FIRSTNAME"+"  "+"LASTNAME"+"  "+"EMAIL");
			
			System.out.println(mems[nm].id+ " "+ mems[nm].pwd+" "+mems[nm].fn+" "+ mems[nm].ln+" "+mems[nm].email);
			nm++;
			
			System.out.println("This user has been successfully added!");
		}
		
		public void deleteuser()
		{
			Scanner in=new Scanner(System.in);
			System.out.println("Enter id: ");
			String id=in.next();
			
			int pos=0;
			for(int i=0;i<nm;i++)
			{
				if(mems[i].id.equals(id))
				{
					pos=i;
					break;
				}
			}
			
			for(int i=pos;i<nm;i++)
			{
				mems[i].id=mems[i+1].id;
				mems[i].pwd=mems[i+1].pwd;
				mems[i].fn=mems[i+1].fn;
				mems[i].ln=mems[i+1].ln;
				mems[i].email=mems[i+1].email;
			}
			nm--;
			System.out.println(id+" "+ "has been successfully deleted");
		}
		
		public void updateuser()
		{
			Scanner in=new Scanner(System.in);
			System.out.println("Enter id: ");
			String id=in.next();
			
			int i=0;
			for(i=0;i<nm;i++)
			{
				if(mems[i].id.equals(id))
					break;
			}
			
			System.out.println("1. Update password");
			System.out.println("2. Update first name");
			System.out.println("3. Update last name");
			System.out.println("4. Update email");
			int c=in.nextInt();
			
			if(c==1)
			{
				boolean t=false;
				while(t=false)
				{
					System.out.println("Enter password: ");
					String p1=in.next();
					System.out.println("Re enter password: ");
					String p2=in.next();
					if(p1.equals(p2))
					{
						t=true;
						mems[i].pwd=p1;
						System.out.println("Password successfully updated");
					}
				}		
			}
			else if(c==2)
			{
				System.out.println("Enter first name: ");
				mems[i].fn=in.next();
				System.out.println("First name successfully updated");
			}
			else if(c==3)
			{
				System.out.println("Enter last name: ");
				mems[i].ln=in.next();
				System.out.println("Last name successfully updated");
			}
			
			else if(c==4)
			{
				System.out.println("Enter email: ");
				mems[i].email=in.next();
				System.out.println("Email successfully updated");
			}
			
		}
		
		public void setw(int n)
		{
			for(int i=0;i<n;i++)
			System.out.print(" ");
		}
	}


}
