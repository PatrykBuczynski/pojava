package lab9;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.PDFHints;
import com.orsonpdf.Page;

public class MyPDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XYSeries series = new XYSeries("Nazwa serii");
		series.add(1, 1);
		series.add(1, 2);
		series.add(2, 4);
		series.add(3, 4);
		series.add(4, 2);
		series.add(5, 9);
		series.add(6, 10);
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
		PDFDocument myPDF = new PDFDocument();
		Page page1 = myPDF.createPage(new Rectangle(794, 1123));
		Page page2 = myPDF.createPage(new Rectangle(794, 1123));
		Page page3 = myPDF.createPage(new Rectangle(794, 1123));
        PDFGraphics2D g2 = page1.getGraphics2D();
        g2.setRenderingHint(PDFHints.KEY_DRAW_STRING_TYPE, 
                PDFHints.VALUE_DRAW_STRING_TYPE_VECTOR);
        chart.draw(g2, new Rectangle(0, 0, 612, 468));
        
        JLabel dataLabel = new JLabel();
        JPanel panel = new JPanel();
        panel.add(dataLabel);
        dataLabel.setText("<html><p>1, 1</p><p>1, 2</p> </html>");
        
        g2 = page2.getGraphics2D();
        panel.getRootPane().paint(g2);
        File f = new File("MyPDF.pdf");
        myPDF.writeToFile(f);
        System.out.println("Prostokaty zapisano do pliku: " + f.getAbsolutePath());
		
		

	}

}
