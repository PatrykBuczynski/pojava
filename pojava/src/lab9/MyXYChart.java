package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MyXYChart {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XYSeries series = new XYSeries("Seria1");
		JFileChooser fc = new JFileChooser();
		String linia = "";
		FileReader fr = null;
		int returnVal = fc.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				fr = new FileReader(file);
				BufferedReader bfr = new BufferedReader(fr);
				
				while((linia = bfr.readLine())!= null) {
					String [] xyTokenizer = linia.split("\\s");
					series.add(Double.parseDouble(xyTokenizer[0]), Double.parseDouble(xyTokenizer[1]));
					
				}
			}catch(FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("File not found!");
				
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Cannot read file");
			}try {
				fr.close();
			} catch(IOException e1) {
				System.out.println("Cannot close file");
			}
		}
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		dataset.addSeries(series);
		//Tworzymy wykres XY
		JFreeChart chart = ChartFactory.createXYLineChart(
			"Wykres XY",//Tytul
			"Opis osi X", // opisy osi
			"Opis osi Y", 
			dataset, // Dane 
			PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
			true, // legenda
			true, // tooltips
			false
		);
		ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(500,400);
	}

}
