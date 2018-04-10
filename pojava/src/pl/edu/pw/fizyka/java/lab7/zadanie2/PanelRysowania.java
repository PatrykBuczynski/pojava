package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class PanelRysowania extends JPanel {

	private static final long serialVersionUID = 1L;
	List<Prostokat> prostakaty = new ArrayList<Prostokat>();
	ImageIcon[] obrazki = new ImageIcon[5];
	JLabel etykieta = new JLabel();


	public PanelRysowania() {
       // domyslny konstruktor
		Timer timer = new Timer(true);
		for (int i = 0; i < 5; i++) {
			String s = "obrazki/obrazek" + i + ".jpg";
			URL sciezka = getClass().getResource(s);

			obrazki[i] = new ImageIcon(sciezka, "");
			add(etykieta);

		}
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						etykieta.setPreferredSize(new Dimension(prostakaty.get(5).getWidth(), prostakaty.get(5).getHeight()));
						
						if(i<4) {
							i++;
						}
						else {
							i = 0;
						}
						etykieta.setIcon(obrazki[i]);
						etykieta.setLocation(prostakaty.get(5).getX(), prostakaty.get(5).getY());
						prostakaty.get(5).setEtykieta(etykieta);
						
						for(Prostokat pr : prostakaty) {
							if(pr.getX() + pr.getWidth() + pr.getXVelocity() > PanelRysowania.this.getWidth()) {
								pr.setXVelocity(-1*pr.getXVelocity());
							}
							if(pr.getY() + pr.getHeight() + pr.getYVelocity() > PanelRysowania.this.getHeight()) {
								pr.setYVelocity(-1*pr.getYVelocity());
							}
							if(pr.getX() < 0) {
								pr.setXVelocity(-1*pr.getXVelocity());
							}
							if(pr.getY() < 0) {
								pr.setYVelocity(-1*pr.getYVelocity());
							}
							pr.setX(pr.getX() + pr.getXVelocity());
							pr.setY(pr.getY() + pr.getYVelocity());
							repaint();
							
	
						}
						etykieta.setLocation(prostakaty.get(5).getX(), prostakaty.get(5).getY());
						prostakaty.get(5).setEtykieta(etykieta);
						repaint();
					}});
				
			}}, 0, 100);
	}
	
	public void dodajLosowyProstokat(){
		Random r = new Random();
		
		Prostokat p = new Prostokat();
		p.setX(r.nextInt(550));
		p.setY(r.nextInt(550));
		p.setWidth(r.nextInt(80));
		p.setHeight(r.nextInt(80));
		p.setColor(new Color(r.nextInt(255), r.nextInt(255),
				r.nextInt(255), r.nextInt(255)));
		p.setXVelocity(r.nextInt(10));
		p.setYVelocity(r.nextInt(10));

		prostakaty.add(p);		
	}
	
	public void dodajProstokat(int x, int y, int width, int height, Color c, int xV, int yV){
		Prostokat p = new Prostokat();
		p.setX(x);
		p.setY(y);
		p.setWidth(width);
		p.setHeight(height);
		p.setColor(c);
		p.setXVelocity(xV);
		p.setYVelocity(yV);

		prostakaty.add(p);		
		
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Prostokat pr : prostakaty) {
			pr.paint(g);
		}

	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
