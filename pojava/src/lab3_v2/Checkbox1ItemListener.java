package lab3_v2;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSlider;

public class Checkbox1ItemListener implements ItemListener {
	
	JSlider slider;
	public Checkbox1ItemListener(JSlider slider) {
		// TODO Auto-generated constructor stub
		this.slider = slider;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			
			slider.setEnabled(true);
		}
		else {
			
			slider.setEnabled(false);
		}
	}

}
