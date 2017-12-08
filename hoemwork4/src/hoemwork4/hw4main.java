package hoemwork4;

import java.util.*;
import java.io.*;
import java.sql.*;

public class hw4main 
{
	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Scanner in = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr = "104.197.183.40:3306/db24";
		String s1 = "jdbc:mysql://" + addr;
		Connection connection = DriverManager.getConnection(s1, "user24", "9494");
		Statement st = connection.createStatement();
		String sqlstr = "";
		
		// ResultSet rs=statement.executeQuery("select * from cars");

		String adminid = "admin"; // admin id
		String adminpwd = "password";// admin password

		System.out.println("Welcome to Carmax!");
		int l1 = 0; // outer loop variable
		while (l1 != 3) 
		{
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit");
			l1 = in.nextInt(); // users choice

			if (l1 == 2)// for signup
			{
				boolean b = false;
				while (b == false) 
				{
					System.out.println("Please input user id: ");
					String uid = in.next();
					System.out.println("Please input password: ");
					String pwd = in.next();
					System.out.println("Please input password again: ");
					String pwdcheck = in.next(); // checker
					if (pwd.equals(pwdcheck)) 
					{
						System.out.println("Please input first name: ");
						String fn = in.next();
						System.out.println("Please input last name: ");
						String ln = in.next();
						System.out.println("Please input your email: ");
						String email = in.next();
						sqlstr = "INSERT INTO members" + " VALUES ('"+uid+ "','"+pwd+"','"+fn+"','"+ln+"','"+email+"')";
						st.executeUpdate(sqlstr); // insert into the table
						b = true;
						System.out.println("You have Succesfully signed up");
					} 
					else 
					{
						System.out.println("Passwords didnt match");
					}
				} // while
			} // if

			else if (l1 == 1)// for login
			{
				System.out.println("Please input your userID: ");
				String uid = in.next();
				System.out.println("Please input your password: ");
				String pwd = in.next();
				if (!(uid.equals(adminid) && pwd.equals(adminpwd))) 
				{
					sqlstr = "select * from members where userid='"+uid+"'";
					ResultSet rs = st.executeQuery(sqlstr); // selecting users
															// row
					rs.next();
					System.out.println("Welcome back " + rs.getString(3) + " " + rs.getString(4) + " !");

					int l2 = 0;// 2nd loop
					while (l2 != 5) 
					{
						System.out.println("1. Display inventory");
						System.out.println("2. Sort cars");
						System.out.println("3. Save a car");
						System.out.println("4. Display saved cars");
						System.out.println("5. Log out");
						l2 = in.nextInt();

						if (l2 == 1) // display cars
						{
							sqlstr = "select * from cars";
							rs = st.executeQuery(sqlstr);
							System.out.println("VIN   BRAND   MODEL   YEAR   MILEAGE   PRICE   COLOUR");
							while (rs.next()) 
							{
								for(int i=1;i<=7;i++)
								{
									System.out.print(rs.getString(i)+" ");
								}
								System.out.println();
							} // while
						} // if

						else if (l2 == 2)// sort cars
						{
							System.out.println("1. Sort by VIN");
							System.out.println("2. Sort by BRAND");
							System.out.println("3. Sort by MODEL");
							System.out.println("4. Sort by YEAR");
							System.out.println("5. Sort by MILEAGE");
							System.out.println("6. Sort by PRICE");
							System.out.println("7. Sort by COLOUR");

							int sortby = in.nextInt();
							if (sortby == 1)
								sqlstr = "select * from cars ORDER BY vin DESC";
							else if (sortby == 2)
								sqlstr = "select * from cars ORDER BY brand DESC";
							else if (sortby == 3)
								sqlstr = "select * from cars ORDER BY model DESC";
							else if (sortby == 4)
								sqlstr = "select * from cars ORDER BY year DESC";
							else if (sortby == 5)
								sqlstr = "select * from cars ORDER BY mileage DESC";
							else if (sortby == 6)
								sqlstr = "select * from cars ORDER BY price DESC";
							else if (sortby == 7)
								sqlstr = "select * from cars ORDER BY colour DESC";
							rs = st.executeQuery(sqlstr);
							System.out.println("VIN   BRAND   MODEL   YEAR   MILEAGE   PRICE   COLOUR");
							while (rs.next())
							{
								for(int i=1;i<=7;i++)
								{
									System.out.print(rs.getString(i)+" ");
								}
								System.out.println();
							} // while
						} // sort cars
						else if (l2 == 3)// save a car
						{
							DatabaseMetaData dbm = connection.getMetaData();
							ResultSet tables = dbm.getTables(null, null, uid, null);
							System.out.println("Enter the VIN of the car you wanna save: ");
							String savecar = in.next();
							
							if(tables.next())
							{
								sqlstr = "INSERT INTO " + uid + " VALUES('"+savecar+"')";
								st.executeUpdate(sqlstr);
							}
							else
							{
								sqlstr = "CREATE TABLE " + uid + "(vin VARCHAR(5))";
								st.executeUpdate(sqlstr); // creating table with
								sqlstr = "INSERT INTO " + uid + " VALUES('"+savecar+"')";
								st.executeUpdate(sqlstr);
							}
							System.out.println("Car has been saved");

						}

						else if (l2 == 4)// display saved cars
						{
							sqlstr = "select * from " + uid;
							rs = st.executeQuery(sqlstr);
							while(rs.next())
							{
								///System.out.println("11111");
								String temp=rs.getString(1);
								
								sqlstr="select * from cars where vin='"+temp+"'";
								Statement st2 = connection.createStatement();
								ResultSet rs2=st2.executeQuery(sqlstr);
								while(rs2.next())
								{
									for(int i=1;i<=5;i++)
									{
										System.out.print(rs2.getString(i)+" ");
									}
									System.out.println();
								}
								rs2.close();
								//System.out.println("2222");
							}
								
						} // else if
					} // while
					rs.close();
				} // if
				else if (uid.equals(adminid) && pwd.equals(adminpwd)) // admin menu													
				{
					System.out.println("Welcome back admin!");
					int l3=0;
					while(l3!=10)
					{
						System.out.println("1. Display inventory");
						System.out.println("2. Add car");
						System.out.println("3. Delete Car");
						System.out.println("4. Update Car");
						System.out.println("5. Display users");
						System.out.println("6. Add user");
						System.out.println("7. Delete user");
						System.out.println("8. Update user");
						System.out.println("9. Display saved cars by user");
						System.out.println("10. logout");
						l3=in.nextInt();
						
						if(l3==1)//display inventory
						{
							sqlstr="select * from cars";
							ResultSet rs=st.executeQuery(sqlstr);
							System.out.println("VIN   BRAND   MODEL   YEAR   MILEAGE   PRICE   COLOUR");
							while (rs.next()) 
							{
								for(int i=1;i<=7;i++)
								{
									System.out.print(rs.getString(i)+" ");
								}
								System.out.println();	
							}//while
						}//if
						
						else if(l3==2)//add car
						{
							System.out.println("VIN: ");
							String vin=in.next();
							System.out.println("BRAND: ");
							String brand=in.next();
							System.out.println("MODEL: ");
							String model=in.next();
							System.out.println("YEAR: ");
							int year=in.nextInt();
							System.out.println("MILEAGE: ");
							int mil=in.nextInt();
							System.out.println("PRICE: ");
							int price=in.nextInt();
							System.out.println("COLOUR: ");
							String colour=in.next();
							sqlstr="INSERT into cars VALUES('"+vin+"','"+brand+"','"
							+model+"',"+year+","+mil+","+price+",'"+colour+"')";
							st.executeUpdate(sqlstr);
							System.out.println("This car has been succesfully added");
								
						}//else if
						
						else if(l3==3)//delete car
						{
							System.out.println("Enter vin");
							String vin=in.next();
							sqlstr="delete from cars where vin='"+vin+"'";
							st.executeUpdate(sqlstr);
							System.out.println("This car has been succesfully deleted");
							
						}//else if
						
						else if(l3==4)//update car
						{
							System.out.println("Enter VIN: ");
							String vin=in.next();
							System.out.println("1. update brand");
							System.out.println("2. update model");
							System.out.println("3. update year");
							System.out.println("4. update mileage");
							System.out.println("5. update price");
							System.out.println("6. update colour");
							int choice=in.nextInt();
							if(choice==1)
							{
								System.out.println("Enter new brand: ");
								String brand=in.next();
								sqlstr="Update cars SET brand='"+brand+"'where vin='"+vin+"'";
							}
							else if(choice==2)
							{
								System.out.println("Enter new model: ");
								String model=in.next();
								sqlstr="Update cars SET model='"+model+"'where vin="+vin+"'";
							}
							else if(choice==3)
							{
								System.out.println("Enter new year: ");
								int year=in.nextInt();
								sqlstr="Update cars SET year="+year+"where vin="+vin+"'";
							}
							else if(choice==4)
							{
								System.out.println("Enter new mileage: ");
								int mil=in.nextInt();
								sqlstr="Update cars SET mileage="+mil+"where vin="+vin+"'";
							}
							else if(choice==5)
							{
								System.out.println("Enter new price: ");
								int price=in.nextInt();
								sqlstr="Update cars SET price="+price+"where vin="+vin+"'";
							}
							else if(choice==6)
							{
								System.out.println("Enter new colour: ");
								String col=in.next();
								sqlstr="Update cars SET colour='"+col+"'where vin="+vin+"'";
							}
							st.executeUpdate(sqlstr);
							System.out.println("Its been updated! TQ");
							
						}//else if
						
						else if(l3==5)//display users
						{
							System.out.println("ID     PASSWORD     FIRSTNAME     LASTANME     EMAIL");
							sqlstr="select * from members";
							ResultSet rs=st.executeQuery(sqlstr);
							while(rs.next())
							{
								for(int i=1;i<=5;i++)
								{
									System.out.print(rs.getString(i)+" ");
								}
								System.out.println();
							}//while
						}//else if
						else if(l3==6)//Add user
						{
							System.out.println("Enter ID: ");
							String id=in.next();
							System.out.println("Enter Password: ");
							String p=in.next();
							System.out.println("Enter First Name: ");
							String fn=in.next();
							System.out.println("Enter Last Name: ");
							String ln=in.next();
							System.out.println("Enter email: ");
							String e=in.next();
							
							sqlstr="insert into members values('"+id+"','"+p+"','"+fn+"','"+ln+"','"+e+"')";
							st.executeUpdate(sqlstr);
							System.out.println("This user has been succesfully added");
							
						}//else if
						else if(l3==7)//delete user
						{
							System.out.println("Enter id: ");
							String id=in.next();
							sqlstr="delete from members where userid='"+id+"'";
							st.executeUpdate(sqlstr);
							System.out.println("This user has been successfully deleted");
							
						}//else if
						
						else if(l3==8)//update user
						{
							System.out.println("Enter ID: ");
							String id=in.next();
							
							System.out.println("1. Update password");
							System.out.println("2. Update first name");
							System.out.println("3. Update last name");
							System.out.println("4. Update email");
							int c=in.nextInt();
							
							if(c==1)
							{
								System.out.println("Enter new password: ");
								String p=in.next();
								sqlstr="update members SET pwd='"+p+"'where userid='"+id+"'";
							}
							else if(c==2)
							{
								System.out.println("Enter first name: ");
								String fn=in.next();
								sqlstr="update members SET firstname='"+fn+"'where userid='"+id+"'";
							}
							else if(c==3)
							{
								System.out.println("Enter last name: ");
								String ln=in.next();
								sqlstr="update members SET lastname='"+ln+"'where userid='"+id+"'";
							}
							else if(c==4)
							{
								System.out.println("Enter email: ");
								String em=in.next();
								sqlstr="update members SET email='"+em+"'where userid='"+id+"'";
							}
							
							st.executeUpdate(sqlstr);
							System.out.println("Its been updated");
						}//else if
						
						else if(l3==9)//display users by car
						{
							sqlstr="select * from members";
							ResultSet rs=st.executeQuery(sqlstr);
							while(rs.next())
							{
								for(int i=1;i<=5;i++)
								{
									System.out.print(rs.getString(i)+" ");
								}
								System.out.println();
							}
							System.out.println("Enter id: ");
							String id=in.next();
							sqlstr = "select * from " + id;
							rs = st.executeQuery(sqlstr);
							while(rs.next())
							{
								///System.out.println("11111");
								String temp=rs.getString(1);
								
								sqlstr="select * from cars where vin='"+temp+"'";
								Statement st2 = connection.createStatement();
								ResultSet rs2=st2.executeQuery(sqlstr);
								while(rs2.next())
								{
									for(int i=1;i<=5;i++)
									{
										System.out.print(rs2.getString(i)+" ");
									}
									System.out.println();
								}
								rs2.close();
								//System.out.println("2222");
							}
								
							
						}//else if
					}//while
				}//else if
			}//else if
		}//while

	 connection.close();
	
}
}

						
						

