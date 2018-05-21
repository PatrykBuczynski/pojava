package lab9;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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

	public static void main(String[] args) throws IOException {
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
        
        JPanel panel = new JPanel();

        
        PDFGraphics2D  g2p2 = page2.getGraphics2D();
        g2p2.setRenderingHint(PDFHints.KEY_DRAW_STRING_TYPE, 
                PDFHints.VALUE_DRAW_STRING_TYPE_VECTOR);
        g2p2.setColor(new Color(0,0,0));
        g2p2.drawString("1, 1", 200, 50);
        g2p2.drawString("1, 2", 200, 100);
        g2p2.drawString("2, 4", 200, 150);
        g2p2.drawString("3, 4", 200, 200);
        g2p2.drawString("4, 2", 200, 250);
        g2p2.drawString("5, 9", 200, 300);
        g2p2.drawString("6, 10", 200, 350);
        
        PDFGraphics2D g2p3 = page3.getGraphics2D();
        g2p3.setRenderingHint(PDFHints.KEY_DRAW_STRING_TYPE, 
                PDFHints.VALUE_DRAW_STRING_TYPE_VECTOR);
        g2p3.setColor(new Color(111));
        g2p3.drawOval(400, 400, 200, 100);
        g2p3.drawLine(100, 100, 100, 300);
        g2p3.drawOval(200, 300, 200, 100);
        g2p3.drawLine(500, 100, 100, 300);
        g2p3.drawOval(300, 400, 50, 100);
        g2p3.drawLine(100, 400, 100, 200);
        URL url = MyPDF.class.getResource("images/englishFlag.png");
        Image image = ImageIO.read(url);
        g2p3.drawImage(image,600,200,100,100,new Color(0),null);
        
        File f = new File("MyPDF.pdf");
        myPDF.writeToFile(f);
        System.out.println("Zapisano do pliku: " + f.getAbsolutePath());
		
		

	}

}
