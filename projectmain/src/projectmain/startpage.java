package projectmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class startpage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startpage window = new startpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void startthepage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startpage window = new startpage();
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
	public startpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 511, 398);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnContinueAsGuest = new JButton("Continue as Guest");
		btnContinueAsGuest.setForeground(new Color(32, 178, 170));
		//btnContinueAsGuest.setOpaque(true);
		btnContinueAsGuest.setBackground(new Color(255, 255, 255));
		btnContinueAsGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GuiMan g = new GuiMan();
				g.screen2();
			}
		});
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				login l=new login();
				l.loginpage();
			}
		});
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(new Color(0, 139, 139));
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register r=new register();
				r.registerme();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnRegister.setBounds(211, 199, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnLogin.setBounds(211, 164, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/reubellejunio/Documents/Semester4/Java/mm.png"));
		label.setBounds(78, -16, 378, 222);
		frame.getContentPane().add(label);
		btnContinueAsGuest.setBounds(182, 234, 154, 23);
		frame.getContentPane().add(btnContinueAsGuest);
		
		JLabel lblWelcomeToFundangoo = new JLabel("");
		lblWelcomeToFundangoo.setLabelFor(lblWelcomeToFundangoo);
		lblWelcomeToFundangoo.setIcon(new ImageIcon("/Users/reubellejunio/Downloads/curtains-001587-royal-blue.jpg"));
		lblWelcomeToFundangoo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeToFundangoo.setBounds(0, 0, 511, 376);
		frame.getContentPane().add(lblWelcomeToFundangoo);
	}
}