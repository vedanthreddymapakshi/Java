package projectmain;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db
{
	/*Function to print out by title
	 * corresponds with Search button(?)
	 * 
	 * */
	public Object[][] getTable(String title) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Object[][] data = new Object[100][2];
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String str1 = "104.197.183.40:3306/db28";
		
		String s = "jdbc:mysql://" + str1;
		Connection connection = DriverManager.getConnection(s, "user28", "6263");
		Statement statement = (Statement) connection.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from movies where title='"+title+"';");
		//System.out.println(s);
		int i = 0;
		while(rs.next())
		{
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			i++;
		}
		connection.close();
		
		return data;
	}
	
	/*
	 * Plainly display all database
	 * corresponds with Display Movies button
	 * */
	public Object[][] getTable1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Object[][] data = new Object[100][2];
	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String str1 = "104.197.183.40:3306/db28";
	
		String s = "jdbc:mysql://" + str1;
		Connection connection = DriverManager.getConnection(s, "user28", "6263");
		Statement statement = (Statement) connection.createStatement();
	
		ResultSet rs = statement.executeQuery("select * from movies");
		//System.out.println(s);
		int i = 0;
		while(rs.next())
		{
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);

			i++;
		}
		connection.close();
	
		return data;
	}
	
	/*Sort by Title */
	public Object[][]sortbyTitle() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Object data[][] = new Object[100][2];
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String str1 = "104.197.183.40:3306/db28";
	
		String s = "jdbc:mysql://" + str1;
		Connection connection = DriverManager.getConnection(s, "user28", "6263");
		Statement statement = (Statement) connection.createStatement();
	
		ResultSet rs = statement.executeQuery("select * from movies order by title");
		int i = 0;
		while(rs.next())
		{
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);

			i++;
		}
		
		return data;
		
	}
	/*Sort by Date release*/
	public Object[][]sortbyDate() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Object data[][] = new Object[100][2];
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String str1 = "104.197.183.40:3306/db28";
	
		String s = "jdbc:mysql://" + str1;
		Connection connection = DriverManager.getConnection(s, "user28", "6263");
		Statement statement = (Statement) connection.createStatement();
	
		ResultSet rs = statement.executeQuery("select * from movies order by ReleaseDate");
		int i = 0;
		while(rs.next())
		{
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);

			i++;
		}
		
		return data;
		
	}
	
}
