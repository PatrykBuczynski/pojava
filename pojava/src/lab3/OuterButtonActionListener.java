package lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class OuterButtonActionListener implements ActionListener {

	JFrame frame;
	
	public OuterButtonActionListener(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setTitle("Zmiana tytulu!");

	}

}
