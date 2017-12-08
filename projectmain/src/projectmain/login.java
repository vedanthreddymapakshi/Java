package projectmain;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class login {

	private JFrame frmClickItTicket;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void loginpage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmClickItTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClickItTicket = new JFrame();
		frmClickItTicket.setTitle("Click It- Ticket: Log In ");
		frmClickItTicket.setBounds(100, 100, 512, 399);
		frmClickItTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClickItTicket.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			
				startpage s=new startpage();
				s.startthepage();
			}
		});
		label.setIcon(new ImageIcon("/Users/reubellejunio/Documents/Semester4/Java/anotherhome.png"));
		label.setBounds(430, 297, 82, 74);
		frmClickItTicket.getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 250));
		passwordField.setBounds(216, 189, 160, 20);
		frmClickItTicket.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("User name");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUsername.setBounds(112, 151, 89, 17);
		frmClickItTicket.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 250));
		textField.setBounds(216, 148, 160, 23);
		frmClickItTicket.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(112, 191, 74, 14);
		frmClickItTicket.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");//NEED TO ADD MYSQL CONNECTIVITY HERE
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
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
				
				Statement st = null;
				try {
					st = (Statement) conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				String username="";
				username=textField.getText();
				char[] pass=passwordField.getPassword();
				String password=new String(pass);
				
				String fn = "";
				String ln = "";
				
				
				String query = "SELECT * FROM customers WHERE username = '" + username + "' AND passwd = '" + password + "';";
				
				
				ResultSet rs = null;
				try {
					rs = st.executeQuery(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//look for user row
				
				
				try {
					if (rs.next())
					{
						try {
							fn = rs.getString(3);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//set first name
						
						try {
							ln = rs.getString(4);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//set last name
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				JOptionPane.showMessageDialog(null, "Welcome to Click It - Ticket, " + fn + " " + ln + "!");
				GuiMan gm = new GuiMan();
				gm.screen2();
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnLogin.setBounds(216, 219, 89, 23);
		frmClickItTicket.getContentPane().add(btnLogin);
		
		JLabel lblFundangoo = new JLabel("");
		lblFundangoo.setBackground(new Color(255, 255, 255));
		lblFundangoo.setIcon(new ImageIcon("/Users/reubellejunio/Downloads/css-gradient-background.png"));
		lblFundangoo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblFundangoo.setBounds(-136, 0, 648, 383);
		frmClickItTicket.getContentPane().add(lblFundangoo);
	}
}