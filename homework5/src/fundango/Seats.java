package fundango;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JButton;

public class Seats {

	private JFrame frmSeats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seats window = new Seats();
					window.frmSeats.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Seats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeats = new JFrame();
		frmSeats.setTitle("Seats");
		frmSeats.setBounds(100, 100, 450, 300);
		frmSeats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeats.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ground Level");
		lblNewLabel.setBounds(24, 66, 82, 16);
		frmSeats.getContentPane().add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("G1");
		tglbtnNewToggleButton.setBounds(145, 61, 41, 29);
		frmSeats.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnG = new JToggleButton("G2");
		tglbtnG.setBounds(189, 61, 41, 29);
		frmSeats.getContentPane().add(tglbtnG);
		
		JToggleButton tglbtnG_1 = new JToggleButton("G3");
		tglbtnG_1.setBounds(282, 61, 41, 29);
		frmSeats.getContentPane().add(tglbtnG_1);
		
		JToggleButton tglbtnG_2 = new JToggleButton("G4");
		tglbtnG_2.setBounds(323, 61, 41, 29);
		frmSeats.getContentPane().add(tglbtnG_2);
		
		JLabel lblNewLabel_1 = new JLabel("Middle Level");
		lblNewLabel_1.setBounds(26, 124, 78, 16);
		frmSeats.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Upper Level");
		lblNewLabel_2.setBounds(28, 175, 73, 16);
		frmSeats.getContentPane().add(lblNewLabel_2);
		
		JToggleButton tglbtnU = new JToggleButton("U1");
		tglbtnU.setBounds(145, 170, 41, 29);
		frmSeats.getContentPane().add(tglbtnU);
		
		JToggleButton tglbtnU_1 = new JToggleButton("U2");
		tglbtnU_1.setBounds(184, 170, 41, 29);
		frmSeats.getContentPane().add(tglbtnU_1);
		
		JToggleButton tglbtnU_2 = new JToggleButton("U3");
		tglbtnU_2.setBounds(223, 170, 41, 29);
		frmSeats.getContentPane().add(tglbtnU_2);
		
		JToggleButton tglbtnU_3 = new JToggleButton("U4");
		tglbtnU_3.setBounds(282, 170, 41, 29);
		frmSeats.getContentPane().add(tglbtnU_3);
		
		JToggleButton tglbtnU_4 = new JToggleButton("U5");
		tglbtnU_4.setBounds(323, 170, 41, 29);
		frmSeats.getContentPane().add(tglbtnU_4);
		
		JToggleButton tglbtnM = new JToggleButton("M1");
		tglbtnM.setBounds(176, 119, 49, 29);
		frmSeats.getContentPane().add(tglbtnM);
		
		JToggleButton tglbtnM_1 = new JToggleButton("M2");
		tglbtnM_1.setBounds(228, 119, 49, 29);
		frmSeats.getContentPane().add(tglbtnM_1);
		
		JToggleButton tglbtnM_2 = new JToggleButton("M3");
		tglbtnM_2.setBounds(282, 119, 49, 29);
		frmSeats.getContentPane().add(tglbtnM_2);
		
		JLabel lblBookSeats = new JLabel("Book Seats ");
		lblBookSeats.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblBookSeats.setBounds(323, 231, 91, 16);
		frmSeats.getContentPane().add(lblBookSeats);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblBack.setBounds(41, 232, 61, 16);
		frmSeats.getContentPane().add(lblBack);
	}
}
