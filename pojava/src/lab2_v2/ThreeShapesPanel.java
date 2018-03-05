package lab2_v2;

import java.awt.BorderLayout;//
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ThreeShapesPanel extends JPanel {

	public ThreeShapesPanel() {
		kolorek1 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek2 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek3 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
			}

	public ThreeShapesPanel(LayoutManager layout) {
		super(layout);
		kolorek1 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek2 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek3 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
	}

	public ThreeShapesPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		kolorek1 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek2 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek3 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
	}

	public ThreeShapesPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		kolorek1 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek2 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		kolorek3 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(kolorek1);
		g.fillRect(50, 50, 150, 100);
		g.setColor(kolorek2);
		g.fillOval(250, 250, 150, 150);
		g.setColor(kolorek3);
		g.fillArc(250, 50, 150, 100, 180, 180);
	}

	public static void main(String[] args) {
		CloseableFrame frame = new CloseableFrame();
		JButton button1 = new JButton("Przycisk1");
		JButton button2 = new JButton("Przycisk2");
		frame.setSize(1000, 500);
		frame.setLayout(new GridLayout(1, 2));
		JPanel jpanel = new JPanel();
		jpanel.setBackground(Color.white);
		frame.add(jpanel);
		jpanel.add(button1, BorderLayout.PAGE_START);
		jpanel.add(button2, BorderLayout.PAGE_END);
		
		ThreeShapesPanel panel = new ThreeShapesPanel();
		panel.setBackground(Color.white);
		frame.add(panel);
		frame.setVisible(true);
		
		
		

	}
	Color kolorek1;
	Color kolorek2;
	Color kolorek3;
	
}
