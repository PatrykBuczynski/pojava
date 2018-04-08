package lab6_v2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.white);
		straightLine = new Line();
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				if(frame.lineEnd.isLine) {
					
					straightLine.addPoint(e.getX(), e.getY());
					Graphics2D g2 = image.createGraphics();
					straightLine.draw(g2);
					frame.center.repaint();
					
				}
				if(frame.lineEnd.isSquare) {
					
					squareX = e.getX();
					squareY = e.getY();
				}
			}
			public void mouseRelease(MouseEvent e) {
				
				if(frame.lineEnd.isSquare) {
					
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
					Graphics2D g2 = image.createGraphics();
					g2.drawRect(squareX, squareY, squareW, squareH);
				}
			}
			
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				
				if(frame.lineEnd.isEraser) {
					Graphics2D g2 = image.createGraphics();
					g2.setColor(frame.center.getBackground());
					g2.fillRect(e.getX(), e.getY(), 20, 20);
				}
				if(frame.lineEnd.isPencil) {
					Graphics2D g2 = image.createGraphics();
					g2.fillOval(e.getX(), e.getY(), 5, 5);
					
				}
				
				CenterPanel.this.repaint();
				CenterPanel.this.revalidate();
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) {
			image = (BufferedImage)this.createImage(frame.center.getWidth(),frame.center.getHeight());
			Graphics2D gc = image.createGraphics();
			gc.setColor(Color.WHITE);
			gc.fillRect(0,0,frame.center.getWidth(),frame.center.getHeight());
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
		if(frame.lineEnd.isLine) {
			straightLine.draw(g2d);
		}
		
	}
	
	MainFrame frame;
	BufferedImage image;
	Line straightLine;
	int squareX;
	int squareY;
	int squareH;
	int squareW;
	
}
