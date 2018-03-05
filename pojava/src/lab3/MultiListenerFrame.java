package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultiListenerFrame extends JFrame implements ItemListener {
	
	JButton outerButton;
	JSlider innerSlider;
	JCheckBox checkBox;
	JLabel sliderLabel;
	JLabel sliderValueLabel;
	JPanel panel;

	public MultiListenerFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		outerButton = new JButton("Zmien tytul");
		innerSlider = new JSlider(JSlider.HORIZONTAL, 0, 250 , 250);
		checkBox = new JCheckBox("Disable slider");
		sliderLabel = new JLabel("Change color of panel");
		sliderValueLabel = new JLabel(String.format("%d", innerSlider.getValue()));
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.add(panel);
		panel.add(innerSlider);
		panel.add(sliderLabel);
		panel.add(sliderValueLabel);
		panel.add(outerButton);
		panel.add(checkBox);
		
		innerSlider.addChangeListener(new SliderChangeListener());
		outerButton.addActionListener(new OuterButtonActionListener(this));
		checkBox.addItemListener(this);
	}
	public class SliderChangeListener implements ChangeListener{
		
		@Override
		public void stateChanged(ChangeEvent arg0) {
			Color zmienny = new Color(innerSlider.getValue(),innerSlider.getValue(),innerSlider.getValue());
			panel.setBackground(zmienny);
			String value = String.format("%d", innerSlider.getValue());
			sliderValueLabel.setText(value);
		}
		
	}

	public MultiListenerFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public MultiListenerFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public MultiListenerFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	//@SuppressWarnings("deprecation")
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			innerSlider.setEnabled(true);
		}
		else
		{
			innerSlider.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiListenerFrame frame = new MultiListenerFrame();
		frame.setVisible(true);
	}

}
