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

public class PlikiGraficzne extends JFrame {

	ImageIcon[] obrazki = new ImageIcon[5];
	JLabel etykieta = new JLabel();
	boolean running = false;
	int i = 0;

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (!running) {
				wczytajObrazki();
				uruchomAnimacje();

			}
		}
	};

	void wczytajObrazki() {

		for (int i = 0; i < 5; i++) {
			String s = "obrazki/obrazek" + i + ".jpg";
			URL sciezka = getClass().getResource(s);

			obrazki[i] = new ImageIcon(sciezka, "");

		}
	}

	void uruchomAnimacje() {
		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(1);

		// Kilkukrotne wywolanie tej metody utworzy kilka "executorow"
		// operujacych na tym samym obiekcie
		// w zaleznosci od momentu drugiego klikniecia efekt moze byc rozny
		// (podwojna inkrementacja, wieksza szybkosc zmian...)

		scheduler.scheduleWithFixedDelay((new Runnable() {

			@Override
			public void run() {
				// Dodanie flagi opisujacej stan watku pozwala na zapobieganie
				// kilkukrotnego uruchomienia
				// - w tym wypadku uzycie if(!running) w obsludze przycisku
				// running = true;

				if (i < 4)
					i++;
				else
					i = 0;
				
				//jestsmy poza EDT, a chcemy zmienic GUI (wyglad etykiety)
				//wiec musimy wywolac invokeLater zeby zmiane przerzucic do EDT
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						etykieta.setIcon(obrazki[i]);
					}
					
				});
				

			}
		}), 0, 500, MILLISECONDS);

	}

	public PlikiGraficzne() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setLayout(new FlowLayout());
		JButton b = new JButton("Animacja start");
		b.addActionListener(listener);
		add(b);
		etykieta.setPreferredSize(new Dimension(200, 200));
		add(etykieta);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlikiGraficzne f = new PlikiGraficzne();
				f.setVisible(true);
			}
		});

	}

}
