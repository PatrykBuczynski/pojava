package lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			squareX = e.getX();
			squareY = e.getY();
			CenterPanel.this.repaint();
		}
		public void mouseReleased(MouseEvent e) {
			if (e.getX() > squareX) squareW = e.getX() - squareX;
			else {
				squareW = squareX - e.getX();
				squareX = e.getX();
			}
			if (e.getY() > squareY) squareH = e.getY() - squareY;
			else {
				squareH = squareY - e.getY();
				squareY = e.getY();
			}
			if(frame.lineEnd.isSquare) {
				
				System.out.println("Test");
			}
			CenterPanel.this.repaint();
		}
		});
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(frame.lineEnd.isSquare) {
			System.out.println("Test2");
			g.setColor(Color.BLACK);
			g.drawRect(squareX, squareY, squareW, squareH);
		}
	}
	MainFrame frame;
	int squareX;
	int squareY;
	int squareH;
	int squareW;


}
