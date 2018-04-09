package pw.java.wyk6.animacje;

import static java.util.concurrent.TimeUnit.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RysowanieUproszczone{
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {

			public void run() {
		        JFrame f = new JFrame("Rysowanie");
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		        MyPanel8 panel = new MyPanel8() ;
		        f.add(panel);
		        f.setSize(450,450);
		        f.setVisible(true);
		        panel.stworzObrazek();
		        panel.rozpocznijRuch();
			}
		});

    }

}

class MyPanel9 extends JPanel {

    int incr = 1;
	int iteracja = 0;
	
	BufferedImage im, im2 ;
	Graphics2D g2im;
	
	
	void stworzObrazek(){
		im = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
		im2 = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
	    g2im = im.createGraphics();
	}
	

    void rozpocznijRuch(){
        
     	ScheduledExecutorService scheduler = 
			       Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate( (new Runnable() {
			
			@Override
			public void run() {
				
				iteracja += incr;
				if (iteracja > getWidth()-50) { incr = -incr;}
				if (iteracja < 0) { incr = -incr;}
				
				g2im.setColor(Color.white);
				g2im.fillRect(0, 0, im.getWidth(), im.getHeight());
				
				//Tworzenie grafiki w buforowanym obrazku
				g2im.setColor(Color.red);
				g2im.fillRect(iteracja, 100, 50, 50);
		    	    
		    	// dodawanie dalszych elementow sceny....	 
		    		 
		    	
				// "podmiana" obrazka wyswietlanego metoda paintComponent:
				im2.getGraphics().drawImage(im, 0, 0, null);
				
				repaint();		
		
					
			}
		}),  0, 1, MILLISECONDS);
    	
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(450,450);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);              
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(im2, null, 0, 0);
        
       
        
    }  
}


