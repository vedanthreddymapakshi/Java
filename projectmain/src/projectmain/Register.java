package projectmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Register {//NEED TO COMPLETE

	private JFrame frmClickIt;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void registerme() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmClickIt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClickIt = new JFrame("Fundangoo: Sign Up");
		frmClickIt.setTitle("Click It - Ticket: Sign Up");
		frmClickIt.setBounds(100, 100, 512, 398);
		frmClickIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClickIt.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblUsername.setBounds(70, 80, 61, 14);
		frmClickIt.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPassword.setBounds(70, 124, 61, 14);
		frmClickIt.getContentPane().add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblFirstName.setBounds(70, 173, 61, 14);
		frmClickIt.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblLastName.setBounds(75, 220, 79, 14);
		frmClickIt.getContentPane().add(lblLastName);
		
		textField = new JTextField();
		textField.setBounds(166, 75, 86, 20);
		frmClickIt.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 169, 86, 20);
		frmClickIt.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(166, 216, 86, 20);
		frmClickIt.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign me up!");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//connect to database & tables
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String dbURL = "jdbc:mysql://104.197.183.40:3306/db35";
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(dbURL, "user35", "4354");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//end db connection step
				
				
				String username="";
				String firstname="";
				String lastname="";
				username=textField.getText();
				char[] pass=passwordField.getPassword();
				String password=new String(pass);
				firstname=textField_2.getText();
				lastname=textField_3.getText();
				String reg = "INSERT INTO customers VALUES ('" + username + "','" + password + "','" + firstname  + "','" + 
												lastname + "');";
				
				Statement st = null;
				try {
					st = (Statement) conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					st.executeUpdate(reg);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				JOptionPane.showMessageDialog(null, "Register successful!");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(294, 130, 151, 52);
		frmClickIt.getContentPane().add(btnNewButton);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setForeground(new Color(0, 139, 139));
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startpage s=new startpage();
				s.startthepage();
			}
		});
		btnGoBack.setBounds(405, 334, 89, 23);
		frmClickIt.getContentPane().add(btnGoBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 119, 86, 20);
		frmClickIt.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/reubellejunio/Downloads/css-gradient-background.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(0, 0, 512, 376);
		frmClickIt.getContentPane().add(lblNewLabel);
	}

}