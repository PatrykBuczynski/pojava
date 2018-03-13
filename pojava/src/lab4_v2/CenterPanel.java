package lab4_v2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Polygon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lab4_v2.PageStartPanel;

public class CenterPanel extends JPanel {
	
	int [] xPoints;
	int [] yPoints;
	LineEndPanel lineEnd;
	LineStartPanel lineStart;
	PageStartPanel pageStart;

	Polygon figure;
	

	public CenterPanel(LineEndPanel lineEnd, LineStartPanel lineStart, PageStartPanel pageStart) {
		// TODO Auto-generated constructor stub
		this.lineEnd = lineEnd;
		this.lineStart = lineStart;
		this.pageStart = pageStart;

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(lineStart.regularRadioButton.isSelected() == true) {
			super.paintComponent(g);
			lineEnd.xPosBox.removeAll();
			lineEnd.yPosBox.removeAll();
			lineEnd.xPosBox.add(lineEnd.xPosLabel);
			lineEnd.yPosBox.add(lineEnd.yPosLabel);
			xPoints = new int [pageStart.vertices];
			yPoints = new int [pageStart.vertices];
			lineEnd.xPosText = new JTextField[pageStart.vertices];
			lineEnd.yPosText = new JTextField[pageStart.vertices];
			for(int i = 0; i < pageStart.vertices; i++) {
				xPoints[i] = this.getSize().width/2 +  (int)(100*Math.cos((Math.PI/2 + 2*Math.PI*(i+1))/pageStart.vertices));
				yPoints[i] = this.getSize().height/2 + (int)(100*Math.sin((Math.PI/2 + 2*Math.PI*(i+1))/pageStart.vertices));
				lineEnd.xPosText[i] = new JTextField("" + xPoints[i]);
				lineEnd.yPosText[i] = new JTextField("" + yPoints[i]);
				lineEnd.add(lineEnd.xPosText[i]);
				lineEnd.yPosBox.add(lineEnd.yPosText[i]);
				lineEnd.validate();
				
			}
			figure = new Polygon(xPoints, yPoints, pageStart.vertices);
			Graphics2D g2d = (Graphics2D) g;
//			BasicStroke bs1 = new BasicStroke(frame.lineWidth);
//			g2d.setStroke(bs1);
			g.setColor(Color.BLACK);
			g.drawPolygon(figure);
		}
		if(lineStart.randomRadioButton.isSelected() == true) {
			super.paintComponent(g);
			lineEnd.xPosBox.removeAll();
			lineEnd.yPosBox.removeAll();
			lineEnd.xPosBox.add(lineEnd.xPosLabel);
			lineEnd.yPosBox.add(lineEnd.yPosLabel);
			xPoints = new int [pageStart.vertices];
			yPoints = new int [pageStart.vertices];
			lineEnd.xPosText = new JTextField[pageStart.vertices];
			lineEnd.yPosText = new JTextField[pageStart.vertices];
			for(int i = 0; i < pageStart.vertices; i++) {
				
				lineEnd.xPosText[i] = new JTextField("" + (this.getSize().width/2 + ((int)(Math.random()*200)- 100)));
				lineEnd.yPosText[i] = new JTextField("" + (this.getSize().height/2 + ((int) (Math.random()*200)-100)));
				xPoints[i] = Integer.parseInt(lineEnd.xPosText[i].getText());
				yPoints[i] = Integer.parseInt(lineEnd.yPosText[i].getText());
				
//				xPoints[i] = this.getSize().width/2 + (int) (Math.random()*200-100);
//				yPoints[i] = this.getSize().height/2 + (int) (Math.random()*200-100);
//				lineEnd.xPosText[i] = new JTextField("" + xPoints[i]);
//				yPosText[i] = new JTextField("" + yPoints[i]);
				lineEnd.xPosBox.add(lineEnd.xPosText[i]);
				lineEnd.yPosBox.add(lineEnd.yPosText[i]);
				lineEnd.validate();
				
			}
			figure = new Polygon(xPoints, yPoints, pageStart.vertices);
			Graphics2D g2d = (Graphics2D) g;
//			BasicStroke bs1 = new BasicStroke(lineWidth);
//			g2d.setStroke(bs1);
			g.setColor(Color.BLACK);
			g.drawPolygon(figure);
			
		}

	};


}
