package lab6_v2;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LineEndPanel extends JPanel {

	public LineEndPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setLayout(new GridLayout(5,1));
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
		pencilButton = new JButton(pencilString);
		eraserButton = new JButton(eraserString);
		lineButton = new JButton(lineString);
		squareButton = new JButton(squareString);
		curveButton = new JButton(curveString);
		this.add(pencilButton);
		this.add(eraserButton);
		this.add(lineButton);
		this.add(squareButton);
		this.add(curveButton);
		
		pencilButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isPencil = true;
				isEraser = false;
				isLine = false;
				isSquare = false;
				isCurve = false;
				
				
			}
		});
		eraserButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isPencil = false;
				isEraser = true;
				isLine = false;
				isSquare = false;
				isCurve = false;
				
				
			}
		});
		lineButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isPencil = false;
				isEraser = false;
				isLine = true;
				isSquare = false;
				isCurve = false;
			}
		});
		squareButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isPencil = false;
				isEraser = false;
				isLine = false;
				isSquare = true;
				isCurve = false;
			}
		});
		curveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isPencil = false;
				isEraser = false;
				isLine = false;
				isSquare = false;
				isCurve = true;
			}
		});
		
		
		
		
	}
	MainFrame frame;
	JButton pencilButton;
	JButton eraserButton;
	JButton lineButton;
	JButton squareButton;
	JButton curveButton;
	boolean isPencil = false;
	boolean isEraser = false;
	boolean isLine = false;
	boolean isSquare = false;
	boolean isCurve = false;

}
