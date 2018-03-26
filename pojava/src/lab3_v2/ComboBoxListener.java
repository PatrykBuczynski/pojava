package lab3_v2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboBoxListener implements ActionListener {
	MultiListenerFrame frame;

	public ComboBoxListener(MultiListenerFrame frame ) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox cb = (JComboBox)e.getSource();
		String wybor = (String)cb.getSelectedItem();
		frame.setTitle(wybor);

	}

}
