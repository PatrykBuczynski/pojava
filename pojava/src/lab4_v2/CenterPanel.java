package lab4_v2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CenterPanel extends JPanel {
	
	MainFrame frame;
	Color kolorLinii = Color.BLACK;
	Polygon figure;
	int [] xPoints;
	int [] yPoints;

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.white);


	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(frame.lineStart.regularRadioButton.isSelected() == true) {
			frame.lineEnd.xPosBox.removeAll();
			frame.lineEnd.yPosBox.removeAll();
			frame.lineEnd.xPosBox.add(frame.lineEnd.xPosLabel);
			frame.lineEnd.yPosBox.add(frame.lineEnd.yPosLabel);
			xPoints = new int [frame.pageStart.vertices];
			yPoints = new int [frame.pageStart.vertices];
			frame.lineEnd.xPosText = new JTextField[frame.pageStart.vertices];
			frame.lineEnd.yPosText = new JTextField[frame.pageStart.vertices];
			for(int i = 0; i < frame.pageStart.vertices; i++) {
				
				xPoints[i] = frame.center.getSize().width/2 +  (int)(100*Math.cos((Math.PI/2 + 2*Math.PI*(i+1))/frame.pageStart.vertices));
				yPoints[i] = frame.center.getSize().height/2 + (int)(100*Math.sin((Math.PI/2 + 2*Math.PI*(i+1))/frame.pageStart.vertices));
				frame.lineEnd.xPosText[i] = new JTextField("" + xPoints[i]);
				frame.lineEnd.yPosText[i] = new JTextField("" + yPoints[i]);
				frame.lineEnd.xPosBox.add(frame.lineEnd.xPosText[i]);
				frame.lineEnd.yPosBox.add(frame.lineEnd.yPosText[i]);
				frame.lineEnd.revalidate();
				
			}
			
		}
		if(frame.lineStart.randomRadioButton.isSelected() == true) {
			frame.lineEnd.xPosBox.removeAll();
			frame.lineEnd.yPosBox.removeAll();
			frame.lineEnd.xPosBox.add(frame.lineEnd.xPosLabel);
			frame.lineEnd.yPosBox.add(frame.lineEnd.yPosLabel);
			xPoints = new int [frame.pageStart.vertices];
			yPoints = new int [frame.pageStart.vertices];
			frame.lineEnd.xPosText = new JTextField[frame.pageStart.vertices];
			frame.lineEnd.yPosText = new JTextField[frame.pageStart.vertices];
			for(int i = 0; i < frame.pageStart.vertices; i++) {
				
				xPoints[i] = frame.center.getSize().width/2 +  (int)((Math.random()*200)- 100);
				yPoints[i] = frame.center.getSize().height/2 + (int)((Math.random()*200)- 100);
				frame.lineEnd.xPosText[i] = new JTextField("" + xPoints[i]);
				frame.lineEnd.yPosText[i] = new JTextField("" + yPoints[i]);
				frame.lineEnd.xPosBox.add(frame.lineEnd.xPosText[i]);
				frame.lineEnd.yPosBox.add(frame.lineEnd.yPosText[i]);
				frame.lineEnd.revalidate();
				
			}			
		}
		figure = new Polygon(xPoints, yPoints, frame.pageStart.vertices);
		Graphics2D g2d = (Graphics2D) g;
		BasicStroke bs1 = new BasicStroke(frame.lineWidth);
		g2d.setStroke(bs1);
		g.setColor(kolorLinii);
		g.drawPolygon(figure);
		
		

	};


}
