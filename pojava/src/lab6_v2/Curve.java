package lab6_v2;

import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;


public class Curve {


	public Curve() {
		// TODO Auto-generated constructor stub
		q = new QuadCurve2D.Double();
	}
	
	public void addStartPoint(Integer x, Integer y) {
		startX = x;
		startY = y;
		isStart = false;
		isEnd = true;

	}
	public void addControlPoint(Integer x, Integer y) {
		xCtrl = x;
		yCtrl = y;
		isControl = false;

	}
	public void addEndPoint(Integer x, Integer y) {
		endX = x;
		endY = y;
		isEnd = false;
		isControl = true;

	}
	public boolean getIsStart() {
		return isStart;
	}
	public boolean getIsControl() {
		return isControl;
	}
	public boolean getIsEnd() {
		return isEnd;
	}
	public void reset() {
		isStart = true;
		isControl = false;
		isEnd = false;
	}
	
	public void draw(Graphics2D g2d) {
		
		q.setCurve(startX, startY, xCtrl, yCtrl, endX, endY);
		g2d.draw(q);

	}
	
	private Integer startX;
	private Integer startY;
	private Integer xCtrl;
	private Integer yCtrl;
	private Integer endX;
	private Integer endY;
	private QuadCurve2D q;
	private boolean isStart = true; // Sprawdza kolejność co ma być teraz wprowadzone według rotacji start > end > control > start > end ... (jeżeli trzeba teraz wprowadzić start, to isStart będzie prawdziwe)
	private boolean isControl = false;
	private boolean isEnd = false;

}
