package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setSize(600, 500);
		this.setLayout(new BorderLayout());
		
		noVerticesSlider = new JSlider(3,33,3);
		noVerticesLabel = new JLabel("No. of vertices");
		drawButton = new JButton("Draw");
		pageStart = new JPanel();
		pageStart.add(noVerticesLabel);
		pageStart.add(noVerticesSlider);
		pageStart.add(drawButton);
		
		lineStart = new JPanel(new GridLayout(2, 1));
		lineStart.setPreferredSize(new Dimension(100,500));
		lineStart.setBorder(BorderFactory.createTitledBorder("Polygon"));
		regularRadioButton = new JRadioButton("Regular");
		randomRadioButton = new JRadioButton ("Random");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(regularRadioButton);
		group1.add(randomRadioButton);
		lineStart.add(regularRadioButton);
		lineStart.add(randomRadioButton);
		
		center = new JPanel();
		center.setBackground(Color.WHITE);
		
		lineEnd = new JPanel(new GridLayout(1,2));
		xPosLabel = new JLabel("x pos.");
		yPosLabel = new JLabel("y pos.");
		lineEnd.add(xPosLabel);
		lineEnd.add(yPosLabel);
		
	
		
		pageEnd = new JPanel();
		this.add(pageStart, BorderLayout.PAGE_START);
		this.add(pageEnd, BorderLayout.PAGE_END);
		this.add(lineEnd, BorderLayout.LINE_END);
		this.add(lineStart, BorderLayout.LINE_START);
		this.add(center, BorderLayout.CENTER);
		
		
		
		
		
		this.setVisible(true);
		
		
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
	JPanel center;
	JPanel pageStart;
	JPanel pageEnd;
	JPanel lineStart;
	JPanel lineEnd;
	JMenu lineWidthMenu;
	JLabel noVerticesLabel;
	JLabel xPosLabel;
	JLabel yPosLabel;
	
	
	
	
	
	
}
