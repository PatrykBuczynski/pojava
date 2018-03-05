package lab2_v2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeButtonFrame extends JFrame {

	public ThreeButtonFrame() throws HeadlessException {
		exitButton = new JButton("Exit");
		changeTitleButton = new JButton("Zmien Tytul");
		changeColorButton = new JButton("Zmien Kolor ");
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		this.add(panel1);
		
		ActionListener exitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		};
		exitButton.addActionListener(exitListener);
		ActionListener changeTitleListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				ThreeButtonFrame.this.setTitle("Nowy Tytul");
			}
			
		};
		changeTitleButton.addActionListener(changeTitleListener);
		ActionListener changeColor = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				panel1.setBackground(Color.cyan);
			}
		};
		changeColorButton.addActionListener(changeColor);
		panel1.add(exitButton);
		panel1.add(changeTitleButton);
		panel1.add(changeColorButton);
		
		
	}

	public ThreeButtonFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ThreeButtonFrame frame = new ThreeButtonFrame();
		frame.setSize(600, 600);
		
		
		frame.setVisible(true);
		
	}
	JButton exitButton;
	JButton changeTitleButton;
	JButton changeColorButton;

}
