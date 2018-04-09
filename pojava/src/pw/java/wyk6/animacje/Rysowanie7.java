package pw.java.wyk6.animacje;

import static java.util.concurrent.TimeUnit.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pw.java.wyk6.animacje.Prostokat;

public class Rysowanie7 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame f = new JFrame("Prostokaty");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MyPanel6 panel = new MyPanel6();
				f.add(panel);
				f.setSize(450, 450);
				f.setVisible(true);
				panel.rozpocznijRuch();
			}
		});

	}

}

class MyPanel6 extends JPanel {

	List<Prostokat> prostakaty = new ArrayList<Prostokat>();
	Prostokat p = new Prostokat();
	int incr = 1;
	int iteracja = 0;

	void rozpocznijRuch() {

		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate((new Runnable() {

			@Override
			public void run() {
				int i = 1;

				iteracja += incr;
				if (iteracja > 1000) {
					incr = -incr - 1;
				}
				if (iteracja < -1000) {
					incr = -incr + 1;
				}

				for (Prostokat pr : prostakaty) {
					if (i > 3)
						i = 1;
					else
						i++;
					// cztery warunki - cztery rozne kierunki poruszania
					if (i == 1)
						pr.setX(pr.getX() + incr);
					if (i == 2)
						pr.setX(pr.getX() - incr);
					if (i == 3)
						pr.setY(pr.getY() + incr);
					if (i == 4)
						pr.setY(pr.getY() - incr);
					
					// repaint nie trzeba umieszczac w metodzie "invokeLater()"
					repaint();

				}

			}
		}), 0, 5, MILLISECONDS);

	}

	public MyPanel6() {

		Random r = new Random();

		for (int i = 1; i < 2000; i++) {
			p = new Prostokat();
			p.setX(r.nextInt(2000) - 1000);
			p.setY(r.nextInt(2000) - 1000);
			p.setWidth(r.nextInt(80));
			p.setHeight(r.nextInt(80));

			p.setColor(new Color(r.nextInt(255), r.nextInt(255),
					r.nextInt(255), r.nextInt(255)));

			prostakaty.add(p);

		}

	}

	public Dimension getPreferredSize() {
		return new Dimension(450, 450);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Prostokat pr : prostakaty) {
			pr.paint(g);
		}

	}
}
