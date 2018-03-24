package lab4_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import javax.swing.*;

public class PageStartPanel extends JPanel {
	
	JLabel noVerticesLabel;
	JSlider noVerticesSlider;
	JButton drawButton;
	int vertices;
	MainFrame frame;

	
	public PageStartPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		noVerticesSlider = new JSlider(3,33,3);
		vertices = noVerticesSlider.getValue();
		noVerticesSlider.setMajorTickSpacing(10);
		noVerticesSlider.setMinorTickSpacing(1);
		noVerticesSlider.setPaintTicks(true);
		noVerticesSlider.setPaintLabels(true);
		noVerticesLabel = new JLabel("No. of vertices");
		drawButton = new JButton("Draw");
		this.add(noVerticesLabel);
		this.add(noVerticesSlider);
		this.add(drawButton);
		
		noVerticesSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				vertices = noVerticesSlider.getValue();
				frame.center.repaint();

		
			}
		});
		
		drawButton.addActionListener(new DrawButtonActionListener());
		
		
		}
	
	public class DrawButtonActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.center.revalidate();
			frame.center.repaint();

			
			
			}
		}
		

	
}
