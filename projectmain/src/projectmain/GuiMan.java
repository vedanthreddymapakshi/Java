package projectmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMan 
{
	private JLabel sortBy, searchLbl;
	private JTextField searchField;
	private JButton searchBtn;
	private String[] columnNames = {"Title", "Release Date"}; 
	private Object[][] data={{"",""}}; 
	private DefaultTableModel dm; 
	//private JScrollPane scroll;
	private JFrame frmNowPlaying;
	
	Db db = new Db();
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JLabel lblSortBy;
	private JTable table;
	
	public GuiMan()
	{
		//set window
		frmNowPlaying = new JFrame();
		frmNowPlaying.setTitle("NOW PLAYING");
		frmNowPlaying.setBounds(100, 100, 513, 399);
		frmNowPlaying.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNowPlaying.getContentPane().setLayout(null);
		dm = new DefaultTableModel(data, columnNames); 
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 47, 478, 282);
		frmNowPlaying.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(dm);
		scrollPane.setViewportView(table);
		
		//Search button with search text field
		JButton searchBtn = new JButton("Browse");
		searchBtn.setBounds(344, 6, 85, 29);
		searchBtn.addActionListener(new SearchBtn());
		frmNowPlaying.getContentPane().add(searchBtn);
		searchField = new JTextField();
		//SearchBtn listener = new SearchBtn(searchField);
		
		searchField.setBounds(237, 6, 111, 26);
		frmNowPlaying.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		String [] by = {"Title", "Release Date", "Genre"};
		comboBox = new JComboBox(by);
		comboBox.addActionListener(new comboBox());
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Title", "Release Date", "Genre"}));
		comboBox.setSelectedIndex(2);
		comboBox.setBounds(63, 8, 68, 27);
		frmNowPlaying.getContentPane().add(comboBox);
		
		lblSortBy = new JLabel("Sort By");
		lblSortBy.setBounds(15, 11, 61, 16);
		frmNowPlaying.getContentPane().add(lblSortBy);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(369, 341, 117, 29);
		frmNowPlaying.getContentPane().add(btnSelect);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				startpage pg = new startpage();
				pg.startthepage();
			}
		});
		label.setIcon(new ImageIcon("/Users/reubellejunio/Documents/Semester4/Java/home.png"));
		label.setBounds(15, 341, 44, 29);
		frmNowPlaying.getContentPane().add(label);
		
		frmNowPlaying.setVisible(true);
		
		
		
	}
	
	private class comboBox implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			
			
		}
	
	}
	private class SearchBtn implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if (searchField.getText().equals(""))
			{
				try {
					dm.setDataVector(db.getTable1(), columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				try {
					dm.setDataVector(db.getTable(searchField.getText()), columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			dm.fireTableDataChanged();
		}
		
		
		
	}
	
	public static void screen2() 
	{
		new GuiMan();

	}
}
