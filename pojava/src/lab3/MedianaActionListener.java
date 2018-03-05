package lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MedianaActionListener implements ActionListener {
	
	MedianFrame frame;

	public MedianaActionListener(MedianFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.wartoscMediany.setText("= " + frame.policzMediane());
		String text = "Zbior liczb: ";
		for(int i = 0; i < frame.liczby.size(); i++) {
			text = text + frame.liczby.get(i) + " ";
		}
		frame.wypisaneLiczby.setText(text);
		

	}

}
