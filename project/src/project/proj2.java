package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class proj2 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void screen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proj2 window = new proj2();
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
	public proj2() {
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
		
		JLabel lblMovies = new JLabel("MOVIES");
		lblMovies.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblMovies.setBounds(189, 11, 46, 14);
		frame.getContentPane().add(lblMovies);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 36, 212, 160);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"TITLE", "DATE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(227);
		
		JButton btnDisplayMovies = new JButton("Display Movies");
		btnDisplayMovies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnDisplayMovies.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnDisplayMovies.setBounds(10, 36, 137, 23);
		frame.getContentPane().add(btnDisplayMovies);
		
		JButton btnNewButton = new JButton("Sort by Title");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(10, 80, 137, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sort by Date");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(10, 125, 137, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
