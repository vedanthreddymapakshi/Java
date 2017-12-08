import java.sql.*;
public class test 
{
	public static void main(String args[])throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from cars");
		while(rs.next())
		{
			System.out.print(rs.getString(1));
			System.out.print(" ");
			System.out.print(rs.getString(2));
			System.out.print(" ");
			System.out.print(rs.getString(3));
			System.out.print(" ");
			System.out.print(rs.getString(4));
			System.out.print(" ");
			System.out.print(rs.getString(5));
			System.out.print(" ");
			System.out.print(rs.getString(6));
			System.out.print(" ");
			System.out.println(rs.getString(7));
			System.out.println();
		}
		
		connection.close();
		System.out.println("No error");
	}

}
