package lab4;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame {

	public MainFrame() {
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
		
		pageStart = new JPanel();
		noVerticesSlider = new JSlider(3,33,3);
		vertices = noVerticesSlider.getValue();
		noVerticesSlider.setMajorTickSpacing(10);
		noVerticesSlider.setMinorTickSpacing(1);
		noVerticesSlider.setPaintTicks(true);
		noVerticesSlider.setPaintLabels(true);
		noVerticesLabel = new JLabel("No. of vertices");
		drawButton = new JButton("Draw");
		pageStart.add(noVerticesLabel);
		pageStart.add(noVerticesSlider);
		pageStart.add(drawButton);
		noVerticesSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				vertices = noVerticesSlider.getValue();
				center = new CenterPanel();
				center.setBackground(Color.WHITE);
				add(center, BorderLayout.CENTER);
				center.revalidate();
				center.repaint();
			}
		});
		
		lineStart = new JPanel(new GridLayout(2, 1));
		lineStart.setBorder(BorderFactory.createTitledBorder("Polygon"));
		regularRadioButton = new JRadioButton("Regular");
		randomRadioButton = new JRadioButton ("Random");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(regularRadioButton);
		group1.add(randomRadioButton);
		regularRadioButton.setSelected(true);
		lineStart.add(regularRadioButton);
		lineStart.add(randomRadioButton);
		
		lineEnd = new JPanel(new GridLayout(1, 2));	
		xPosBox = Box.createVerticalBox();
		yPosBox = Box.createVerticalBox();
		lineEnd.add(xPosBox);
		lineEnd.add(yPosBox);
		xPosLabel = new JLabel("x pos.");
		yPosLabel = new JLabel("y pos.");
		xPosBox.add(xPosLabel);
		yPosBox.add(yPosLabel);

		pageEnd = new JPanel();
		bgButton = new JButton("BG color");
		lnButton = new JButton("LN color");
		pageEnd.add(bgButton);
		pageEnd.add(lnButton);
		this.add(pageStart, BorderLayout.PAGE_START);
		this.add(pageEnd, BorderLayout.PAGE_END);
		this.add(lineEnd, BorderLayout.LINE_END);
		this.add(lineStart, BorderLayout.LINE_START);
		drawButton.addActionListener(new DrawButtonActionListener());
		
		
		
		this.setVisible(true);
	}
	
	public class DrawButtonActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			center = new CenterPanel();
			center.setBackground(Color.WHITE);
			add(center, BorderLayout.CENTER);
			center.revalidate();
			center.repaint();
			
			}
		}
		
	public class CenterPanel extends JPanel {
		
		public CenterPanel() {

			}
		@Override
		protected void paintComponent(Graphics g) {
			if(regularRadioButton.isSelected() == true) {
				super.paintComponent(g);
				xPosBox.removeAll();
				yPosBox.removeAll();
				xPosBox.add(xPosLabel);
				yPosBox.add(yPosLabel);
				xPoints = new int [vertices];
				yPoints = new int [vertices];
				xPosText = new JTextField[vertices];
				yPosText = new JTextField[vertices];
				for(int i = 0; i < vertices; i++) {
					xPoints[i] = this.getSize().width/2 +  (int)(100*Math.cos((Math.PI/2 + 2*Math.PI*(i+1))/vertices));
					yPoints[i] = this.getSize().height/2 + (int)(100*Math.sin((Math.PI/2 + 2*Math.PI*(i+1))/vertices));
					xPosText[i] = new JTextField("" + xPoints[i]);
					yPosText[i] = new JTextField("" + yPoints[i]);
					xPosBox.add(xPosText[i]);
					yPosBox.add(yPosText[i]);
					lineEnd.validate();
					
				}
				figure = new Polygon(xPoints, yPoints, vertices);
				Graphics2D g2d = (Graphics2D) g;
				BasicStroke bs1 = new BasicStroke(lineWidth);
				g2d.setStroke(bs1);
				g.setColor(Color.BLACK);
				g.drawPolygon(figure);
			}
			if(randomRadioButton.isSelected() == true) {
				super.paintComponent(g);
				xPosBox.removeAll();
				yPosBox.removeAll();
				xPosBox.add(xPosLabel);
				yPosBox.add(yPosLabel);
				xPoints = new int [vertices];
				yPoints = new int [vertices];
				xPosText = new JTextField[vertices];
				yPosText = new JTextField[vertices];
				for(int i = 0; i < vertices; i++) {
					xPoints[i] = this.getSize().width/2 + (int) (Math.random()*200-100);
					yPoints[i] = this.getSize().height/2 + (int) (Math.random()*200-100);
					xPosText[i] = new JTextField("" + xPoints[i]);
					yPosText[i] = new JTextField("" + yPoints[i]);
					xPosBox.add(xPosText[i]);
					yPosBox.add(yPosText[i]);
					lineEnd.validate();
					
				}
				figure = new Polygon(xPoints, yPoints, vertices);
				Graphics2D g2d = (Graphics2D) g;
				BasicStroke bs1 = new BasicStroke(lineWidth);
				g2d.setStroke(bs1);
				g.setColor(Color.BLACK);
				g.drawPolygon(figure);
				
			}
		};

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();

		

	}
	
	JSlider noVerticesSlider;
	JButton drawButton;
	JButton bgButton;
	JButton lnButton;
	JRadioButton regularRadioButton;
	JRadioButton randomRadioButton;
	CenterPanel center;
	JPanel pageStart;
	JPanel pageEnd;
	JPanel lineStart;
	JPanel lineEnd;
	JMenu lineWidthMenu;
	JMenuBar menuBar;
	JMenuItem px1MenuItem;
	JMenuItem px2MenuItem;
	JLabel noVerticesLabel;
	JLabel xPosLabel;
	JLabel yPosLabel;
	Box xPosBox;
	Box yPosBox;

	JTextField [] xPosText;
	JTextField [] yPosText;
	int vertices;
	int lineWidth;
	int [] xPoints;
	int [] yPoints;
	Polygon figure;
	
	
	
	
	
	
}
