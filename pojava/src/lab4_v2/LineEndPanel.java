package lab4_v2;

import java.awt.LayoutManager;

import javax.swing.*;

public class LineEndPanel extends JPanel {
	
	JLabel xPosLabel;
	JLabel yPosLabel;
	Box xPosBox;
	Box yPosBox;
	JTextField [] xPosText;
	JTextField [] yPosText;
	MainFrame frame;

	public LineEndPanel() {
		// TODO Auto-generated constructor stub
	}

	public LineEndPanel(LayoutManager layout, MainFrame frame) {
		super(layout);
		this.frame = frame;
		xPosLabel = new JLabel("X pos.");
		yPosLabel = new JLabel("Y pos.");
		xPosBox = Box.createVerticalBox();
		yPosBox = Box.createVerticalBox();
		this.add(xPosBox);
		this.add(yPosBox);
		xPosBox.add(xPosLabel);
		yPosBox.add(yPosLabel);
	}

	public LineEndPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public LineEndPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
