package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pageStart = new JPanel();
		noVerticesSlider = new JSlider(3,33,3);
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
			}
		});
		
		lineStart = new JPanel(new GridLayout(2, 1));
		lineStart.setPreferredSize(new Dimension(100,500));
		lineStart.setBorder(BorderFactory.createTitledBorder("Polygon"));
		regularRadioButton = new JRadioButton("Regular");
		randomRadioButton = new JRadioButton ("Random");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(regularRadioButton);
		group1.add(randomRadioButton);
		regularRadioButton.setSelected(true);
		lineStart.add(regularRadioButton);
		lineStart.add(randomRadioButton);
		
		
		lineEnd = new JPanel(new GridLayout(1,2));	
		xPosLabel = new JLabel("x pos.");
		yPosLabel = new JLabel("y pos.");
		lineEnd.add(xPosLabel);
		lineEnd.add(yPosLabel);
		
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
			revalidate();
			repaint();
			
			}
		}
		
	public class CenterPanel extends JPanel {
		
		public CenterPanel() {
			xPoints = new int [vertices];
			yPoints = new int [vertices];
			for(int i = 0; i < vertices; i++) {
			xPoints[i] = (int)(2*Math.cos(Math.PI/2 + 2*Math.PI*i)/vertices);
			yPoints[i] = (int)(2*Math.sin(Math.PI/2 + 2*Math.PI*i)/vertices);
			}
			figure = new Polygon(xPoints, yPoints, vertices);
			}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g.drawPol
		}
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
	JLabel noVerticesLabel;
	JLabel xPosLabel;
	JLabel yPosLabel;
	int vertices;
	int [] xPoints;
	int [] yPoints;
	Polygon figure;
	
	
	
	
	
	
}
