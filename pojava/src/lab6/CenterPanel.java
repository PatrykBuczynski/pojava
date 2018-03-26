package lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.Console;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.WHITE);
		adapter = new MouseAdapter() {
			
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
				Graphics2D g2 = image.createGraphics();
				g2.drawRect(squareX, squareY, squareW, squareH);
			}
			CenterPanel.this.repaint();
		}
			
		};
		motionListener = new MouseMotionListener() {
			
			public void mouseMoved(MouseEvent e) {}
			public void mouseDragged(MouseEvent e) {
				
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
				CenterPanel.this.repaint();
				CenterPanel.this.revalidate();
				
			}
			
		};
		this.addMouseListener(adapter);
		this.addMouseMotionListener(motionListener);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(image == null) {
			image = (BufferedImage)this.createImage(frame.panel.getWidth(),frame.panel.getHeight());
			Graphics2D gc = image.createGraphics();
			gc.setColor(Color.WHITE);
			gc.fillRect(0,0,frame.panel.getWidth(),frame.panel.getHeight());
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
		
		if(frame.lineEnd.isSquare) {

			g.drawRect(squareX, squareY, squareW, squareH);
		}
			
		
	}
	MainFrame frame;
	int squareX;
	int squareY;
	int squareH;
	int squareW;
	MouseAdapter adapter;
	MouseMotionListener motionListener;
	BufferedImage image;
	


}











//public void mouseDragged(MouseEvent e) {
//	System.out.println("" + squareX + " " + squareY + " " + squareW + " " + squareH );
//	CenterPanel.this.repaint();
//}