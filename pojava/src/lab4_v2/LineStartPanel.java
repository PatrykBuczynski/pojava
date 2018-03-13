package lab4_v2;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.*;

public class LineStartPanel extends JPanel {
	
	JRadioButton regularRadioButton;
	JRadioButton randomRadioButton;
	ButtonGroup group1;
	

	public LineStartPanel() {
		// TODO Auto-generated constructor stub
	}

	public LineStartPanel(LayoutManager layout) {
		super(layout);
		regularRadioButton = new JRadioButton("Regular");
		randomRadioButton = new JRadioButton("Random");
		group1 = new ButtonGroup();
		group1.add(randomRadioButton);
		group1.add(regularRadioButton);
		this.add(regularRadioButton);
		this.add(randomRadioButton);
		// TODO Auto-generated constructor stub
	}

	public LineStartPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public LineStartPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
