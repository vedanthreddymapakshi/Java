package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class proj {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proj window = new proj();
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
	public proj() {
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
		
		JLabel lblWelcomeToFundango = new JLabel("Welcome to Fundangoo!");
		lblWelcomeToFundango.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				proj2 p=new proj2();
				p.screen2();
			}
		});
		lblWelcomeToFundango.setBounds(0, 0, 434, 261);
		lblWelcomeToFundango.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToFundango.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		frame.getContentPane().add(lblWelcomeToFundango);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBounds(167, 164, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		JLabel lblF = new JLabel("FUNDANGOO!");
		lblF.setForeground(Color.BLUE);
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 32));
		lblF.setBounds(48, 30, 336, 60);
		frame.getContentPane().add(lblF);
	}

}
