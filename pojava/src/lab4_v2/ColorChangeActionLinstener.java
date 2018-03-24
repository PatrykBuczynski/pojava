package lab4_v2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ColorChangeActionLinstener implements ActionListener {
	
	MainFrame frame;
	public ColorChangeActionLinstener(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Color newColor = JColorChooser.showDialog(null,"Choose Color",Color.WHITE);
		frame.center.setBackground(newColor);
	}

}
