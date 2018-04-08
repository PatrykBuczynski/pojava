package lab6_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(600, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		center = new CenterPanel(this);
		lineEnd = new LineEndPanel(this);
		this.add(center, BorderLayout.CENTER);
		this.add(lineEnd, BorderLayout.LINE_END);
		menuBar = new JMenuBar();
		mainMenu = new JMenu("Menu");
		lineMenu = new JMenu("Line");
		lineWidthMenu = new JMenu ("Line Width");
		twoPx = new JMenuItem("2 px");
		fivePx = new JMenuItem("5 px");
		color = new JMenuItem ("Line Color");
		importImage = new JMenuItem("Import");
		exportImage = new JMenuItem("Export");
		clear = new JMenuItem("Clean image");
		this.setJMenuBar(menuBar);
		menuBar.add(mainMenu);
		menuBar.add(lineMenu);
		lineMenu.add(lineWidthMenu);
		lineMenu.add(color);
		lineWidthMenu.add(twoPx);
		lineWidthMenu.add(fivePx);
		mainMenu.add(clear);
		mainMenu.add(importImage);
		mainMenu.add(exportImage);
		twoPx.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lineWidth = 2;
			}
		});
		fivePx.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lineWidth = 5;
			}
		});
		color.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				lineColor = JColorChooser.showDialog(null, "Color of the lines", lineColor);
			}
		});
		clear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Graphics2D g2d = center.image.createGraphics();
				g2d.setBackground(Color.WHITE);
				g2d.clearRect(0, 0, center.image.getWidth(), center.image.getHeight());
			}
		});
		exportImage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			    fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						ImageIO.write(center.image, "jpg", file);
					} catch (IOException e1) {
						e1.printStackTrace();
						System.out.println("Błąd przy zapisywaniu");
						System.exit(1);
					}
				}
			}
				
		});
		importImage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				BufferedImage importedImage;
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			    fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						importedImage = ImageIO.read(file);
						Graphics2D g2d = center.image.createGraphics();
						g2d.drawImage(importedImage, null, 0, 0);
					} catch (IOException e1) {
						e1.printStackTrace();
						System.out.println("Błąd przy zapisywaniu");
						System.exit(1);
					}
				}
			}
				
		});
		this.setVisible(true);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();
	}
	CenterPanel center;
	LineEndPanel lineEnd;
	JMenuBar menuBar;
	JMenu mainMenu;
	JMenu lineMenu;
	JMenu lineWidthMenu;
	JMenuItem twoPx;
	JMenuItem fivePx;
	JMenuItem color;
	JMenuItem exportImage;
	JMenuItem importImage;
	JMenuItem clear;
	int lineWidth = 1;
	Color lineColor = Color.BLACK;
	
	

}
