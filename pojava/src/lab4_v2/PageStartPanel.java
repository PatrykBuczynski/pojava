package lab4_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
		noVerticesLabel = new JLabel("No. of vertices");
		noVerticesSlider = new JSlider(3,33,3);
		drawButton = new JButton("Draw");
		this.add(noVerticesLabel);
		this.add(noVerticesSlider);
		this.add(drawButton);
		
		vertices = noVerticesSlider.getValue();
		noVerticesSlider.setMajorTickSpacing(10);
		noVerticesSlider.setMinorTickSpacing(1);
		noVerticesSlider.setPaintTicks(true);
		noVerticesSlider.setPaintLabels(true);
		drawButton.addActionListener(new DrawButtonActionListener());
		noVerticesSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				vertices = noVerticesSlider.getValue();
				frame.center.revalidate();
				frame.center.repaint();
			}
		});
		
	}
	public class DrawButtonActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.center = new CenterPanel(frame.lineEnd, frame.lineStart, frame.pageStart);
			frame.center.setBackground(Color.WHITE);
			frame.add(frame.center, BorderLayout.CENTER);
			frame.center.revalidate();
			frame.center.repaint();
			
			}
		}
	
	public int getVertices() {
		return vertices;
	}



}
