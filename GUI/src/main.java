import javax.swing.*;
public class main {
	private JLabel ml1;
	private JTextField tf;
	private JButton b;
	public main()
	{
		//JOptionPane.showMessageDialog(null,"Hello World");
		//String name;
		//name=JOptionPane.showInputDialog("Enter your name");
		//System.out.println(name);
		final int WINDOW_WIDTH=800,WINDOW_HEIGHT=600;
		JFrame window=new JFrame("test window");
		window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);;
		
		ml1=new JLabel("Enter a value");
		ml1.setSize(100,30);
		ml1.setLocation(50,50);
		window.add(ml1);
		tf=new JTextField(10);
		tf.setSize(100,30);
		tf.setLocation(150,150);
		window.add(tf);
		b=new JButton("Button 1");
		b.setSize(100,30);
		b.setLocation(250,250);
		window.add(b);
		
		window.setVisible(true);
		
	}
	
	public static void main(String args[])
	{
		new main();
	}
	
	public 
	}

}
