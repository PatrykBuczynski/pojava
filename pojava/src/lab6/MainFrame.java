package lab6;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(800,500);
		this.setTitle("Ubuntu Paint");
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		lineWidth = new JMenu("Line Width");
		lineColor = new JMenuItem("Color of the line");
		exportImage = new JMenuItem("Export");
		importImage = new JMenuItem("Import");
		clean = new JMenuItem("Clean");
		px1 = new JMenuItem("1 px");
		px2 = new JMenuItem("2 px");
		px5 = new JMenuItem("5 px");
		panel = new CenterPanel(this);
		lineEnd = new LineEndPanel(this);
		this.setJMenuBar(menuBar);
		this.add(panel, BorderLayout.CENTER);
		this.add(lineEnd, BorderLayout.LINE_END);
		menuBar.add(menu);
		menuBar.add(lineWidth);
		menu.add(lineColor);
		menu.add(exportImage);
		menu.add(importImage);
		menu.add(clean);
		lineWidth.add(px1);
		lineWidth.add(px2);
		lineWidth.add(px5);
		
		
		
		this.setVisible(true);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();

	}
	
	JMenuBar menuBar;
	JMenu menu;
	JMenu lineWidth;
	JMenuItem lineColor;
	JMenuItem importImage;
	JMenuItem exportImage;
	JMenuItem clean;
	JMenuItem px1;
	JMenuItem px2;
	JMenuItem px5;
	CenterPanel panel;
	LineEndPanel lineEnd;
	
	

}
