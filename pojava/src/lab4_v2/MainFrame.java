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
				center.revalidate();
				center.repaint();
				
				}
			
		});
		px2MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lineWidth = 2;
				center.revalidate();
				center.repaint();
				
				}
			
		});
		
		lineWidthMenu.add(px1MenuItem);
		lineWidthMenu.add(px2MenuItem);
		menuBar.add(lineWidthMenu);
		this.setJMenuBar(menuBar);
		
		pageStart = new PageStartPanel(this);
		lineStart = new LineStartPanel(new GridLayout(2,1));
		lineEnd = new LineEndPanel(new GridLayout(1,2));
		pageEnd = new PageEndPanel();
		center = new CenterPanel(lineEnd, lineStart, pageStart);
		this.add(pageStart, BorderLayout.PAGE_START);
		this.add(lineStart, BorderLayout.LINE_START);
		this.add(center, BorderLayout.CENTER);
		this.add(lineEnd, BorderLayout.LINE_END);
		this.add(pageEnd, BorderLayout.PAGE_END);
		
		lineStart.setBorder(BorderFactory.createTitledBorder("Polygon"));
		
		
		
		this.setVisible(true);
		
	}

	public MainFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public MainFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public MainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();

	}

}
