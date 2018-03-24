package lab4_v2;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PageEndPanel extends JPanel {
	
	JButton bgColorButton;
	JButton lnColorButton;
	MainFrame frame;

	public PageEndPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		bgColorButton = new JButton("BG Color");
		lnColorButton = new JButton("LN Color");
		this.add(bgColorButton);
		this.add(lnColorButton);
		bgColorButton.addActionListener(new ColorChangeActionLinstener(frame));
		lnColorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color newColor = JColorChooser.showDialog(null,"Choose Color",Color.BLACK);
				frame.center.kolorLinii = newColor;
			}
		});
	}

	public PageEndPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public PageEndPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PageEndPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
