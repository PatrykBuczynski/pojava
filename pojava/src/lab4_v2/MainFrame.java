package lab4_v2;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	
	PageStartPanel pageStart;
	LineStartPanel lineStart;
	CenterPanel center;
	LineEndPanel lineEnd;
	PageEndPanel pageEnd;
	JMenu lineWidthMenu;
	JMenuBar menuBar;
	JMenuItem px1MenuItem;
	JMenuItem px2MenuItem;
	int lineWidth;

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(600, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		menuBar = new JMenuBar();
		lineWidthMenu = new JMenu("Line Width");
		px1MenuItem = new JMenuItem("1px");
		px2MenuItem = new JMenuItem("2px");
		px1MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lineWidth = 1;
				}
			
		});
		px2MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lineWidth = 2;
				
				}
			
		});
		
		lineWidthMenu.add(px1MenuItem);
		lineWidthMenu.add(px2MenuItem);
		menuBar.add(lineWidthMenu);
		this.setJMenuBar(menuBar);
		
		pageStart = new PageStartPanel(this);
		lineStart = new LineStartPanel(new GridLayout(2,1), this);
		lineEnd = new LineEndPanel(new GridLayout(1,2), this);
		pageEnd = new PageEndPanel(this);
		center = new CenterPanel(this);
		
		this.add(pageStart, BorderLayout.PAGE_START);
		this.add(lineStart, BorderLayout.LINE_START);
		this.add(lineEnd, BorderLayout.LINE_END);
		this.add(pageEnd, BorderLayout.PAGE_END);
		this.add(center, BorderLayout.CENTER);
		
		lineStart.setBorder(BorderFactory.createTitledBorder("Polygon"));
		
		
		
		this.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();

	}

}
