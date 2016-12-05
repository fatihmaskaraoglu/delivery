package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackgroundImageJFrame  extends JFrame {

	private JFrame frame;
	JButton b1;
	JLabel l1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public BackgroundImageJFrame() {
		setTitle("Little City Prototype");
	    setSize(400,400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	/*
	    One way
	    -----------------
	    setLayout(new BorderLayout());
	    JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
	    add(background);
	    background.setLayout(new FlowLayout());
	    l1=new JLabel("Here is a button");
	    b1=new JButton("I am a button");
	    background.add(l1);
	    background.add(b1);
	*/
	// Another way
	    setLayout(new BorderLayout());
	    setContentPane(new JLabel(new ImageIcon("C:\\Users\\Imp-win\\workspace\\Delivery\\delivery\\src\\gui\\15357008_10211026941493716_944923547_n.jpg")));
	    setLayout(new FlowLayout());
	    l1=new JLabel("Here is a button");
	    b1=new JButton("I am a button");
	    add(l1);
	    add(b1);
	    // Just for refresh :) Not optional!
	    setSize(399,399);
	    setSize(400,400);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void main(String[] args) {
		new BackgroundImageJFrame();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackgroundImageJFrame window = new BackgroundImageJFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
