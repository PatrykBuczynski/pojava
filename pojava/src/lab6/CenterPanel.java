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
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.WHITE);
		xLineList = new ArrayList<Integer>();
		yLineList = new ArrayList<Integer>();
		xCurveList = new ArrayList<Integer>();
		yCurveList = new ArrayList<Integer>();
		adapter = new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
			squareX = e.getX();
			squareY = e.getY();
			
			if(frame.lineEnd.isLine) {
				xLineList.add(e.getX());
				yLineList.add(e.getY());
				for (int i = 0; i < xLineList.size() - 1; ++i) {
					
					 Graphics2D g2 = image.createGraphics();
		             g2.drawLine(xLineList.get(i), yLineList.get(i), xLineList.get(i + 1), yLineList.get(i + 1));
		          }
			}
			else {
				xLineList.clear();
				yLineList.clear();
			}
			if(frame.lineEnd.isCurve) {
				xCurveList.add(e.getX());
				yCurveList.add(e.getY());
			}

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
			if(frame.lineEnd.isCurve) {
				QuadCurve2D q = new QuadCurve2D.Double();
				for (int i = 0; i < xCurveList.size() - 1; i++) {
					
					 Graphics2D g2 = image.createGraphics();
					 q.setCurve(xCurveList.get(i), yCurveList.get(i), e.getX(), e.getY(), xCurveList.get(i + 1), yCurveList.get(i + 1));
					 g2.draw(q);

		       
		          }

				
			}
			CenterPanel.this.repaint();
		}
			
		};
		motionListener = new MouseMotionListener() {
				
			public void mouseMoved(MouseEvent e) {}
			public void mouseDragged(MouseEvent e) {
				
				if(frame.lineEnd.isEraser) {
					Graphics2D g2 = image.createGraphics();
					g2.setColor(frame.panel.getBackground());
					g2.fillRect(e.getX(), e.getY(), 15, 15);
				}
				if(frame.lineEnd.isPencil) {
					Graphics2D g2 = image.createGraphics();
					g2.fillOval(e.getX(), e.getY(), 5, 5);
					
				}
				if(frame.lineEnd.isCurve) {
					ctrX = e.getX();
					ctrY = e.getY();
			
				}
				
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
		if(frame.lineEnd.isCurve) {
			QuadCurve2D q = new QuadCurve2D.Double();
			for (int i = 0; i < xCurveList.size() - 1; i++) {
				
				 q.setCurve(xCurveList.get(i), yCurveList.get(i), ctrX, ctrY, xCurveList.get(i + 1), yCurveList.get(i + 1));
				 g2d.draw(q);
	          }
			if(xCurveList.size() == 3)
			{
				xCurveList.clear();
				yCurveList.clear();
			}
			
		}
			
		
	}
	MainFrame frame;
	int squareX;
	int squareY;
	int squareH;
	int squareW;
	int ctrX;
	int ctrY;
	MouseAdapter adapter;
	MouseMotionListener motionListener;
	BufferedImage image;
	List<Integer> xLineList;
	List<Integer> yLineList;
	
	List<Integer> xCurveList;
	List<Integer> yCurveList;
	List<Integer> xCtrlCurveList;
	List<Integer> yCtrlCurveList;
	


}











//public void mouseDragged(MouseEvent e) {
//	System.out.println("" + squareX + " " + squareY + " " + squareW + " " + squareH );
//	CenterPanel.this.repaint();
//}