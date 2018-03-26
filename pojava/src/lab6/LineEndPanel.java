package lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LineEndPanel extends JPanel {

	public LineEndPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(5,1));
		this.frame = frame;
		URL eraserImage = getClass().getResource("images/eraser.jpeg");
		URL pencilImage = getClass().getResource("images/pencil.jpeg");
		URL lineImage = getClass().getResource("images/line.png");
		URL squareImage = getClass().getResource("images/square.png");
		URL curveImage = getClass().getResource("images/curve.png");
		String eraserString = "<html><img src=\"" + eraserImage
                + "\" height=50 width=50></html>";
		String pencilString = "<html><img src=\"" +pencilImage
                + "\" height=50 width=50></html>";
		String lineString = "<html><img src=\"" + lineImage
                + "\" height=50 width=50></html>";
		String squareString = "<html><img src=\"" + squareImage
                + "\" height=50 width=50></html>";
		String curveString = "<html><img src=\"" + curveImage
                + "\" height=50 width=50></html>";
		eraser = new JButton(eraserString);
		pencil = new JButton(pencilString);
		line = new JButton(lineString);
		square = new JButton(squareString);
		curve = new JButton(curveString);
		this.add(eraser);
		this.add(pencil);
		this.add(line);
		this.add(square);
		this.add(curve);
		
		eraser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isEraser = true;
				isPencil = false;
				isLine = false;
				isSquare = false;
				isCurve = false;
			}
		});
		pencil.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isEraser = false;
				isPencil = true;
				isLine = false;
				isSquare = false;
				isCurve = false;
			}
		});
		line.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isEraser = false;
				isPencil = false;
				isLine = true;
				isSquare = false;
				isCurve = false;
			}
		});
		square.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isEraser = false;
				isPencil = false;
				isLine = false;
				isSquare = true;
				isCurve = false;
			}
		});
		curve.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isEraser = false;
				isPencil = false;
				isLine = false;
				isSquare = false;
				isCurve = true;
			}
		});
		
	}
	JButton eraser;
	JButton pencil;
	JButton line;
	JButton square;
	JButton curve;
	MainFrame frame;
	boolean isEraser = false;
	boolean isPencil = false;
	boolean isLine = false;
	boolean isSquare = false;
	boolean isCurve = false;
}
	