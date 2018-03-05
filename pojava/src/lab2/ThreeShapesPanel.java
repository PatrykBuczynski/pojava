package lab2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class ThreeShapesPanel extends JPanel {

	public ThreeShapesPanel() {
			}

	public ThreeShapesPanel(LayoutManager layout) {
		super(layout);
	}

	public ThreeShapesPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public ThreeShapesPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color kolorek1 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		Color kolorek2 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		Color kolorek3 = new Color((int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1),(int) (Math.random()*255 + 1));
		g.setColor(kolorek1);
		g.fillRect(50, 50, 150, 100);
		g.setColor(kolorek2);
		g.fillOval(250, 250, 150, 150);
		g.setColor(kolorek3);
		g.fillArc(250, 50, 150, 100, 180, 180);
	}

	public static void main(String[] args) {
		CloseableFrame frame = new CloseableFrame();
		
		ThreeShapesPanel panel = new ThreeShapesPanel();
		panel.setBackground(Color.white);
		frame.add(panel);
		frame.setVisible(true);
		
		
		

	}
	
}
