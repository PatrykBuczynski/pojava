package lab6_v2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class CenterPanel extends JPanel {

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.white);
		straightLine = new Line();
		curveLine = new Curve();

		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				gridX = e.getX();
				gridY = e.getY();


				if(frame.lineEnd.isLine) {
					
					straightLine.addPoint(e.getX(), e.getY());
					Graphics2D g2 = image.createGraphics();
					g2.setStroke(new BasicStroke(frame.lineWidth));
					g2.setColor(frame.lineColor);
					straightLine.draw(g2);
					frame.center.repaint();
				}
				if(frame.lineEnd.isPencil) {
					straightLine.clear();
				}
				if(frame.lineEnd.isCurve) {
					
					if(curveLine.getIsStart()){
						curveLine.addStartPoint(e.getX(), e.getY());
					}
					else {
						
						if(curveLine.getIsEnd()) {
							curveLine.addEndPoint(e.getX() ,  e.getY());
						}
						else {
							if(curveLine.getIsStart() == false && curveLine.getIsControl() == false && curveLine.getIsEnd() == false){
								curveLine.addControlPoint( e.getX(), e.getY());
								Graphics2D g2 = image.createGraphics();
								g2.setStroke(new BasicStroke(frame.lineWidth));
								g2.setColor(frame.lineColor);
								curveLine.draw(g2);
								curveLine.reset();
							}
						}
					}
				}
				wasMousePressed = true;
				repaint();
				revalidate();
			}
			public void mouseReleased(MouseEvent e) {
				
				if(frame.lineEnd.isSquare) {
					
					if (e.getX() > gridX) squareW = e.getX() -  gridX;
					else {
						 squareW =  gridX - e.getX();
						 gridX = e.getX();
					}
					if (e.getY() >  gridY)  squareH = e.getY() -  gridY;
					else {
						 squareH =  gridY - e.getY();
						 gridY = e.getY();
					}
					Graphics2D g2 = image.createGraphics();
					g2.setStroke(new BasicStroke(frame.lineWidth));
					g2.setColor(frame.lineColor);
					g2.drawRect(gridX, gridY, squareW, squareH);
					repaint();
					revalidate();
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
					straightLine.addPoint(e.getX(), e.getY());
					Graphics2D g2 = image.createGraphics();
					g2.setStroke(new BasicStroke(frame.lineWidth));
					g2.setColor(frame.lineColor);
					straightLine.draw(g2);
				}
				if(frame.lineEnd.isSquare) {
					
					if (e.getX() > gridX) squareW = e.getX() -  gridX;
					else {
						 squareW =  gridX - e.getX();
						 gridX = e.getX();
					}
					if (e.getY() >  gridY)  squareH = e.getY() -  gridY;
					else {
						 squareH =  gridY - e.getY();
						 gridY = e.getY();
					}
				}


				CenterPanel.this.repaint();
				CenterPanel.this.revalidate();
			}
			public void mouseMoved(MouseEvent e) {
				
				gridSecondX = e.getX();
				gridSecondY = e.getY();
				if(frame.lineEnd.isCurve) {
					curveLine.addControlPoint(e.getX(), e.getY());
				}
				repaint();
				revalidate();
				
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(frame.lineWidth));
		g2.setColor(frame.lineColor);
		if(image == null) {
			image = (BufferedImage)this.createImage(frame.center.getWidth(),frame.center.getHeight());
			Graphics2D gc = image.createGraphics();
			gc.setColor(Color.WHITE);
			gc.fillRect(0,0,frame.center.getWidth(),frame.center.getHeight());
		}
		Graphics2D g2d = g2;
		g2d.drawImage(image, 0, 0, this);
		
		if(frame.lineEnd.isLine) {
			if(wasMousePressed) {
				g.drawLine(gridX, gridY, gridSecondX, gridSecondY);
			}
		}
		if(frame.lineEnd.isSquare) {
			g.drawRect(gridX, gridY, squareW, squareH);
			}
		if(frame.lineEnd.isCurve) {
			if(curveLine.getIsStart() == false && curveLine.getIsControl() == false && curveLine.getIsEnd() == false ) {
				curveLine.draw(g2);
			}
		}
		
	}
	
	MainFrame frame;
	BufferedImage image;
	Line straightLine;
	Curve curveLine;
	int gridX;
	int gridY;
	int squareH;
	int squareW;
	int gridSecondX;
	int gridSecondY;
	
	boolean wasMousePressed = false;

	
}
