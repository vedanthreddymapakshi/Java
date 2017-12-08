package fundango;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class hw5 {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hw5 window = new hw5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hw5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 11, 398, 116);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Vin", "Brand", "Model", "Year", "Mileage", "Price", "Colour"
			}
		));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vin,brand,model,mileage,price,colour,year="";
				if(!(textField.getText().trim().equals("")))
					vin=textField.getText();
				if(!(textField_1.getText().trim().equals("")))
					brand=textField_1.getText();
				if(!(textField_2.getText().trim().equals("")))
					model=textField_2.getText();
				if(!(textField_3.getText().trim().equals("")))
					year=textField_3.getText();
				if(!(textField_4.getText().trim().equals("")))
					mileage=textField_4.getText();
				if(!(textField_5.getText().trim().equals("")))
					price=textField_5.getText();
				if(!(textField_6.getText().trim().equals("")))
					colour=textField_6.getText();
					
				
			}
		});
		btnSearch.setBounds(10, 147, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(109, 147, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(230, 147, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(329, 147, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblVin = new JLabel("VIN");
		lblVin.setBounds(10, 181, 46, 14);
		frame.getContentPane().add(lblVin);
		
		textField = new JTextField();
		textField.setBounds(42, 181, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(138, 181, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 181, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(291, 184, 46, 14);
		frame.getContentPane().add(lblModel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(329, 181, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 216, 46, 14);
		frame.getContentPane().add(lblYear);
		
		textField_3 = new JTextField();
		textField_3.setBounds(42, 213, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setBounds(138, 216, 46, 14);
		frame.getContentPane().add(lblMileage);
		
		textField_4 = new JTextField();
		textField_4.setBounds(184, 213, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(291, 216, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		textField_5 = new JTextField();
		textField_5.setBounds(329, 213, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setBounds(138, 244, 46, 14);
		frame.getContentPane().add(lblColour);
		
		textField_6 = new JTextField();
		textField_6.setBounds(184, 241, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
