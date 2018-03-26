package lab6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent {
	
	int squareX;
	int squareY;
	int squareW;
	int squareH;

	public RectangleComponent(int squareX, int squareY, int squareW, int squareH) {
		// TODO Auto-generated constructor stub
		this.squareX = squareX;
		this.squareY = squareY;
		this.squareW = squareW;
		this.squareH = squareH;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(squareX,squareY, squareW, squareH);
		System.out.println("Narysowany kwadrat" + squareX + " " + squareY + " " + squareW + " " + squareH);
		
		
	}

}
