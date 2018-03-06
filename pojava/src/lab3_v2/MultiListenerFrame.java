package lab3_v2;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultiListenerFrame extends JFrame implements ChangeListener {

	public MultiListenerFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(600, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		button1 = new JButton("Zmien tytul");
		slider1 = new JSlider(0, 255, 255);
		panel1 = new JPanel();
		checkbox1 = new JCheckBox("Wylacz slider");
		String[] lista = {"Jeden", "Dwa", "Trzy"};
		comboBox1 = new JComboBox(lista);
		comboBox1Label = new JLabel((String)comboBox1.getSelectedItem());
		radioButton1 = new JRadioButton("Wybor1");
		radioButton2 = new JRadioButton("Wybor2");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(radioButton1);
		group1.add(radioButton2);
		
		
		this.add(panel1);
		panel1.add(button1);
		panel1.add(slider1);
		panel1.add(checkbox1);
		panel1.add(comboBox1);
		panel1.add(comboBox1Label);
		panel1.add(radioButton1);
		panel1.add(radioButton2);
		button1.addActionListener(new Button1ActionListener());
		slider1.addChangeListener(this);
		checkbox1.addItemListener(new Checkbox1ItemListener(slider1));
		comboBox1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox)e.getSource();
				String wybor = (String)cb.getSelectedItem();
				comboBox1Label.setText(wybor);
			}
		});
		
		
		
		
	}
	public class Button1ActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MultiListenerFrame.this.setTitle("Nowy tytul");
		}
	}
	public void stateChanged(ChangeEvent e) {
		
		Color zmienny = new Color(slider1.getValue(),slider1.getValue(),slider1.getValue());
		panel1.setBackground(zmienny);
		String value = String.format("%d", slider1.getValue());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiListenerFrame frame = new MultiListenerFrame();
		frame.setVisible(true);
	}
	JButton button1;
	JSlider slider1;
	JCheckBox checkbox1;
	JPanel panel1;
	JComboBox comboBox1;
	JLabel comboBox1Label;
	JRadioButton radioButton1;
	JRadioButton radioButton2;

}
