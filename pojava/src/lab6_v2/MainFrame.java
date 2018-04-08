package lab6_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(600, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		center = new CenterPanel(this);
		lineEnd = new LineEndPanel(this);
		this.add(center, BorderLayout.CENTER);
		this.add(lineEnd, BorderLayout.LINE_END);
		menuBar = new JMenuBar();
		mainMenu = new JMenu("Menu");
		lineMenu = new JMenu("Line");
		this.setJMenuBar(menuBar);
		menuBar.add(mainMenu);
		menuBar.add(lineMenu);
		
		this.setVisible(true);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();
	}
	CenterPanel center;
	LineEndPanel lineEnd;
	JMenuBar menuBar;
	JMenu mainMenu;
	JMenu lineMenu;
	int LineWidth = 1;
	Color lineColor = Color.BLACK;
	
	

}
