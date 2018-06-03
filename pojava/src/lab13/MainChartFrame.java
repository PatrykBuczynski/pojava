package lab13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.sun.istack.internal.Nullable;

import sun.applet.Main;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainChartFrame extends JFrame {
	
	JButton drawButton;
	JTextField aFactor;
	JTextField bFactor;
	JLabel aLabel;
	JLabel bLabel;
	JLabel titleLabel;
	JPanel redConteiner;
	JPanel greyConteiner;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem exportItem;
	JMenuItem importItem;
	JMenuItem closeItem;
	ChartPanel panel = null;
	JFreeChart chart = null;
	

	public MainChartFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setSize(800,900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		setJMenuBar(menuBar);
		menuBar.add(menu);
		importItem = new JMenuItem("Wczytaj dane txt");
		exportItem = new JMenuItem("Zapisz wykres");
		closeItem = new JMenuItem("Zamknij");
		menu.add(exportItem);
		menu.add(importItem);
		menu.add(closeItem);
		drawButton = new JButton("Draw");
		aFactor = new JTextField(5);
		bFactor = new JTextField(5);
		aLabel = new JLabel("a:");
		bLabel = new JLabel("b:");
		titleLabel = new JLabel("Parametry prostej ax + b");
		redConteiner = new JPanel();
		greyConteiner = new JPanel();
		redConteiner.setLayout(new GridLayout(6, 1));
		redConteiner.setBackground(Color.red);
		greyConteiner.setBackground(Color.GRAY);
		redConteiner.add(titleLabel);
		redConteiner.add(aLabel);
		redConteiner.add(aFactor);
		redConteiner.add(bLabel);
		redConteiner.add(bFactor);
		greyConteiner.add(drawButton);
		add(redConteiner, BorderLayout.LINE_START);
		add(greyConteiner, BorderLayout.CENTER);
		closeItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainChartFrame.this.dispose();
			}
			
		});
		exportItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "png");
				    fileChooser.setFileFilter(filter);
				    int returnVal = fileChooser.showOpenDialog(MainChartFrame.this);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       
				    	if(chart == null) {
							JOptionPane.showMessageDialog(MainChartFrame.this, "Brak wykresu", "Error!", JOptionPane.ERROR_MESSAGE);

				    	}
				    	else {
				    		try {
								ChartUtilities.saveChartAsPNG(fileChooser.getSelectedFile(), chart, 500, 600);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				    	}
				    }
				
			}
			
		});
		importItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser importFileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
				    importFileChooser.setFileFilter(filter);
				    int returnVal = importFileChooser.showOpenDialog(MainChartFrame.this);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	try {
							FileReader fr = new FileReader(importFileChooser.getSelectedFile());
							BufferedReader bfr = new BufferedReader(fr);
							String linia = bfr.readLine();
							StringTokenizer tokenizer = new StringTokenizer(linia);
							aFactor.setText(tokenizer.nextToken());
							bFactor.setText(tokenizer.nextToken());
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
				
			}
			
		});
		
		drawButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(panel == null) {
						
						XYSeries series = new XYSeries("prosta");
						XYSeriesCollection dataSet = new XYSeriesCollection();
						dataSet.addSeries(series);
						chart = ChartFactory.createXYLineChart("Wielomian ax+b", "x", "y", dataSet, PlotOrientation.VERTICAL, true, true, false);
						panel = new ChartPanel(chart);
						chart.getPlot().setBackgroundPaint(Color.gray);
						greyConteiner.add(panel);
						greyConteiner.revalidate();
						series.add(0, Double.parseDouble(bFactor.getText()));
						for(int i = 1 ; i < 20; i++) {
							double y = Double.parseDouble(aFactor.getText()) * i + Double.parseDouble(bFactor.getText());
							series.add(i, y);
						}
						
					}
					}catch(NumberFormatException e1) {
						greyConteiner.remove(panel);
						panel = null;
						JOptionPane.showMessageDialog(MainChartFrame.this, "Błędny format danych", "Error!", JOptionPane.ERROR_MESSAGE);
						
					}catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(MainChartFrame.this, "Brak danych!", "Error!", JOptionPane.ERROR_MESSAGE);
						
						
					}
				
				
			}
			
		});
		
		setVisible(true);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainChartFrame frame = new MainChartFrame();
				
			}
			
		});

	}

}
