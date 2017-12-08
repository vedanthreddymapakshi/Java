package hw5;

import java.sql.*;

import javax.swing.JOptionPane;

public class CarInventory
{
	public CarInventory()
	{
		
	}
	public Object[][] getTableStart() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from cars");

		Object[][] data = new Object[100][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("colour");
			count++;
		}
		connection.close();
		return data;
	}
	public Object[][] getTable0(String vin,String brand, String model, String year, String mileage, String price, String colour) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from cars where vin='"+vin+"'"+" or brand='"+brand+"'"+" or model='"+model+"'"+" or year='"+year+"'"+" or mileage='"+mileage+"'"+" or price='"+price+"'"+" or colour='"+colour+"'");
		Object[][] data = new Object[100][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("colour");
			count++;
		}
		connection.close();
		return data;
	}
	
	public Object[][] getTable1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();		
		ResultSet rs = statement.executeQuery("select * from cars where brand='Honda'"); // This is an example. 

		Object[][] data = new Object[100][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("colour");
			count++;
		}
		connection.close();
		return data;
	}
	
	public void delcar(String vin)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();
		
		if(vin.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter vin to delete");
		}
		
		else
		{
			int rs=statement.executeUpdate("delete from cars where vin='"+vin+"'");
			JOptionPane.showMessageDialog(null, "It has been deleted");
		}
	}
	public void updatecar(String vin, String brand, String model, String year, String mileage, String price, String colour)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();
		String rs;
		
		if(vin.equals(""))
		{
			JOptionPane.showMessageDialog(null, "You need to enter vin to update");
		}
		
		else
		{
			if(!(brand.equals("")))
			{
				rs="Update cars SET brand='"+brand+"'where vin='"+vin+"'";
				statement.executeUpdate(rs);
			}
			
			if(!(model.equals("")))
			{
				rs="Update cars SET model='"+model+"'where vin='"+vin+"'";
				statement.executeUpdate(rs);
			}
			if(!(year.equals("")))
			{
				rs="Update cars SET year='"+year+"'where vin='"+vin+"'";
				statement.executeUpdate(rs);
			}
			if(!(mileage.equals("")))
			{
				rs="Update cars SET mileage='"+mileage+"'where vin='"+vin+"'";
				statement.executeUpdate(rs);
			}
			if(!(price.equals("")))
			{
				rs="Update cars SET price='"+price+"'where vin='"+vin+"'";
				statement.executeUpdate(rs);
			}
			if(!(colour.equals("")))
			{
				rs="Update cars SET colour='"+colour+"'where vin='"+vin+"'";
				statement.executeUpdate(rs);
			}
			JOptionPane.showMessageDialog(null, "Succesfully Updated");
		}
	}
	
	public void addcar(String vin, String brand, String model, String year, String mileage, String price, String colour)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String addr="104.197.183.40:3306/db24";
		String s1="jdbc:mysql://"+addr;
		Connection connection=DriverManager.getConnection(s1,"user24","9494");
		Statement statement=connection.createStatement();
		
		if(vin.equals("")||brand.equals("")||model.equals("")||year.equals("")||mileage.equals("")||price.equals("")||colour.equals(""))
		{
			JOptionPane.showMessageDialog(null, "You must fill in all fields!");
		}
		
		else
		{
			String rs="INSERT into cars VALUES('"+vin+"','"+brand+"','"
					+model+"',"+year+","+mileage+","+price+",'"+colour+"')";
					statement.executeUpdate(rs);
			JOptionPane.showMessageDialog(null, "Car Successfully added!");
		}		
			
	}
	
}
