package pw.java.wyk6.animacje;

import static java.util.concurrent.TimeUnit.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Rysowanie8 {
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {

			public void run() {
		        JFrame f = new JFrame("Rysowanie Uproszczone");
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		        MyPanel9 panel = new MyPanel9() ;
		        f.add(panel);
		        f.setSize(450,450);
		        f.setVisible(true);
		        panel.stworzObrazek();
		        panel.rozpocznijRuch();
			}
		});

    }

}

class MyPanel8 extends JPanel {

    List<Prostokat> prostakaty = new ArrayList<Prostokat>();
    Prostokat p = new Prostokat();
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
				int i = 1; 
			
				
				iteracja += incr;
				if (iteracja > 1000) { incr = -incr-1;}
				if (iteracja < -1000) { incr = -incr+1;}
				
				g2im.setColor(Color.white);
				g2im.fillRect(0, 0, im.getWidth(), im.getHeight());
				
				for(Prostokat pr : prostakaty){
		         	 if (i > 3) i=1 ; else i++;
		    		 // cztery warunki - cztery rozne kierunki poruszania
		         	 if (i == 1 ) pr.setX( pr.getX() + incr );
		    		 if (i == 2 ) pr.setX( pr.getX() - incr );
		    		 if (i == 3 ) pr.setY( pr.getY() + incr );
		    		 if (i == 4 ) pr.setY( pr.getY() - incr );
		   		
		    	     pr.paint(g2im);
		    	    
		    		 
		    		 
		    		
		         }
				//repaint mozna umiescic w metodzie "invokeLater()"
				
				im2.getGraphics().drawImage(im, 0, 0, null);
				repaint();		
						
						
				
			}
		}),  0, 25, MILLISECONDS);
    	
    	
    	
    }
    
    
    public MyPanel8() {
        
    	Random r = new Random();
    	
        for (int i = 1; i< 2000; i++)
        	{
            	p = new Prostokat();	
            	p.setX( r.nextInt(2000) - 1000);
            	p.setY( r.nextInt(2000) - 1000);
            	p.setWidth(r.nextInt(80));
            	p.setHeight(r.nextInt(80));
         	
              	p.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));            	
            	
              	prostakaty.add( p);
					
			}
        

    }

    public Dimension getPreferredSize() {
        return new Dimension(450,450);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);              
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(im2, null, 0, 0);
        //g2.drawImage(im, null, 0, 0); //- widoczny efekt migotania przy duzej szybkosci
       
        
    }  
}


