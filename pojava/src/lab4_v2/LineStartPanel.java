package lab4_v2;

import java.awt.LayoutManager;

import javax.swing.*;

public class LineStartPanel extends JPanel {
	
	JRadioButton regularRadioButton;
	JRadioButton randomRadioButton;
	ButtonGroup group1;
	MainFrame frame;
	

	public LineStartPanel() {
		// TODO Auto-generated constructor stub
	}

	public LineStartPanel(LayoutManager layout, MainFrame frame) {
		super(layout);
		this.frame = frame;
		ButtonGroup group1 = new ButtonGroup();
		regularRadioButton = new JRadioButton("Regular");
		randomRadioButton = new JRadioButton("Random");
		group1.add(regularRadioButton);
		group1.add(randomRadioButton);
		this.add(regularRadioButton);
		this.add(randomRadioButton);
		regularRadioButton.setSelected(true);
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
