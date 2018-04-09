package pw.java.wyk6.animacje;

import static java.util.concurrent.TimeUnit.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class PlikiGraficzneTimer extends JFrame {

	
	ImageIcon[] obrazki = new ImageIcon[5];
	JLabel etykieta = new JLabel();
	boolean running = false;
	int i = 0;

    Timer timer;

    ActionListener listener1 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(!running){
				wczytajObrazki();
				uruchomAnimacje();				
			}
		}
	};
	
	
	ActionListener listener2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(running){
				timer.stop();
				running = false;
			}
		}
	};
	
	
	ActionListener listener3 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(running){
				if (timer.getDelay() > 100) timer.setDelay(timer.getDelay()-100);
				
			}
		}
	};
	
	
	void wczytajObrazki(){
				
		for (int i = 0; i<5; i++){
			String s = "obrazki/obrazek" + i + ".jpg";
			URL sciezka = getClass().getResource(s);  
			
				obrazki[i] = new ImageIcon(sciezka, "");
		
		}
		  
	}
	
	
	void uruchomAnimacje(){
		timer = new Timer(500, null);
	  	timer.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (i<4) i++; else i = 0;

        		//jestesmy wewnatrz actionPerformed, czyli w EDT
				etykieta.setIcon(obrazki[i]);
        	}
    	});	
	  	timer.start();
	  	running = true;
	}
	
	
	public PlikiGraficzneTimer(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setLayout(new FlowLayout());
		JButton b1 = new JButton("Animacja start");
		b1.addActionListener(listener1);
		add(b1);
		JButton b2 = new JButton("Animacja stop");
		b2.addActionListener(listener2);
		add(b2);
		JButton b3 = new JButton("Animacja szybciej");
		b3.addActionListener(listener3);
		add(b3);
	
		etykieta.setPreferredSize(new Dimension(200,200));
		add(etykieta);
		
		
	}
	
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
		
			public void run() {
				PlikiGraficzneTimer f = new PlikiGraficzneTimer();
				f.setVisible(true);
				
			}
		});

	}

}
