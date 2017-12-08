package hw5;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.*;
import java.sql.SQLException;

public class Main extends JFrame
{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private String[] columnNames = {"VIN","Brand","Model","Year","Mileage","Price","Color"};
	//private Object[][] data={{"","","","","","","",}};
	private JTable table;
	private DefaultTableModel dm;
	private JScrollPane scroll;
	private CarInventory ci = new CarInventory();
	public Main() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		super("Carmax");
		setSize(800,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		table = new JTable();
		dm = new DefaultTableModel(ci.getTableStart(), columnNames);
	    table.setModel(dm);
		scroll = new JScrollPane(table);
		scroll.setSize(700, 270);
		scroll.setLocation(50, 50);
		add(scroll);
		
		label1 = new JLabel("VIN");
		label1.setSize(100, 30);
		label1.setLocation(50, 400);
		add(label1);		
		textField1 = new JTextField();
		textField1.setSize(100, 30);
		textField1.setLocation(100, 400);
		add(textField1);
		
		label2 = new JLabel("Brand");
		label2.setSize(100, 30);
		label2.setLocation(50, 450);
		add(label2);		
		textField2 = new JTextField();
		textField2.setSize(100, 30);
		textField2.setLocation(100, 450);
		add(textField2);
		
		label3 = new JLabel("Model");
		label3.setSize(100, 30);
		label3.setLocation(250, 450);
		add(label3);		
		textField3 = new JTextField();
		textField3.setSize(100, 30);
		textField3.setLocation(300, 450);
		add(textField3);		
		
		label4 = new JLabel("Year");
		label4.setSize(100, 30);
		label4.setLocation(450, 450);
		add(label4);		
		textField4 = new JTextField();
		textField4.setSize(100, 30);
		textField4.setLocation(500, 450);
		add(textField4);		
		
		label5 = new JLabel("Mileage");
		label5.setSize(100, 30);
		label5.setLocation(50, 500);
		add(label5);		
		textField5 = new JTextField();
		textField5.setSize(100, 30);
		textField5.setLocation(100, 500);
		add(textField5);
		
		label6 = new JLabel("Price");
		label6.setSize(100, 30);
		label6.setLocation(250, 500);
		add(label6);		
		textField6 = new JTextField();
		textField6.setSize(100, 30);
		textField6.setLocation(300, 500);
		add(textField6);		
		
		label7 = new JLabel("Color");
		label7.setSize(100, 30);
		label7.setLocation(450, 500);
		add(label7);		
		textField7 = new JTextField();
		textField7.setSize(100, 30);
		textField7.setLocation(500, 500);
		add(textField7);

		button1 = new JButton("Search");
		button1.setSize(100, 30);
		button1.setLocation(50, 350);
		button1.addActionListener(new Button1Clicked());
		add(button1);
		button2 = new JButton("Delete");
		button2.setSize(100, 30);
		button2.setLocation(200, 350);
		button2.addActionListener(new Button2Clicked());
		add(button2);
		button3 = new JButton("Update");
		button3.setSize(100, 30);
		button3.setLocation(350, 350);
		button3.addActionListener(new Button3Clicked());
		add(button3);
		button4 = new JButton("Add");
		button4.setSize(100, 30);
		button4.setLocation(500, 350);
		button4.addActionListener(new Button4Clicked());
		add(button4);
		setVisible(true);
		
		button5=new JButton("Clear");
		button5.setSize(100, 30);
		button5.setLocation(650, 350);
		button5.addActionListener(new Button5Clicked());
		add(button5);
		
		
	}
	private class Button1Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String vin, brand, model, colour="";
			String year,price, mileage="";
			vin=textField1.getText();
			brand=textField2.getText();
			model=textField3.getText();
			year=textField4.getText();
			mileage=textField5.getText();
			price=textField6.getText();
			colour=textField7.getText();
			
			if(vin.equals("")&& brand.equals("")&& model.equals("")&&year.equals("")&&mileage.equals("")&&price.equals("")&&colour.equals(""))
			{
				try
				{
					dm.setDataVector(ci.getTableStart(), columnNames);
					dm.fireTableDataChanged();
				}
				catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				try 
				{
					dm.setDataVector(ci.getTable0(vin,brand,model,year,mileage,price,colour), columnNames);
					dm.fireTableDataChanged();
				} 
				catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	private class Button2Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				String vin=textField1.getText();
				ci.delcar(vin);
				dm.setDataVector(ci.getTableStart(), columnNames);
				dm.fireTableDataChanged();
			} 
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
			
	
	}
	private class Button3Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				String vin,brand,model,year,mil,price,colour="";
				vin=textField1.getText();
				brand=textField2.getText();
				model=textField3.getText();
				year=textField4.getText();
				mil=textField5.getText();
				price=textField6.getText();
				colour=textField7.getText();
				ci.updatecar(vin, brand, model, year, mil, price, colour);
				
				dm.setDataVector(ci.getTableStart(), columnNames);
				dm.fireTableDataChanged();
			} 
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	private class Button4Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				String vin,brand,model,year,mil,price,colour="";
				vin=textField1.getText();
				brand=textField2.getText();
				model=textField3.getText();
				year=textField4.getText();
				mil=textField5.getText();
				price=textField6.getText();
				colour=textField7.getText();
				ci.addcar(vin, brand, model, year, mil, price, colour);
				dm.setDataVector(ci.getTableStart(), columnNames);
				dm.fireTableDataChanged();
				
			}
			
			catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
	}	
	
	private class Button5Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			textField5.setText("");
			textField6.setText("");
			textField7.setText("");
		}
	}
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		new Main();
	}
}

