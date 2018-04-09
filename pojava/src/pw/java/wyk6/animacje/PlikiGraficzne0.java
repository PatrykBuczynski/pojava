package pw.java.wyk6.animacje;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


class AnimowanaEtykieta extends JLabel implements Runnable{

	ImageIcon[] obrazki = new ImageIcon[5];
	
	public AnimowanaEtykieta() {
		super();
		
    	// Uwaga = wczytywanie wiekszej ilosci obrazkow w konstruktorze moze przyblokowac GUI...
		for (int i = 0; i<5; i++){
			String s = "obrazki/obrazek" + i + ".jpg";
			URL sciezka = getClass().getResource(s);  
			obrazki[i] = new ImageIcon(sciezka, "");
		}

		setIcon(obrazki[0]);
	}

	
	public void run() {
		int i = 0;
		while (true){
			if (i<4) i++; else i = 0;

			final int nrObrazka = i;
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					setIcon(obrazki[nrObrazka]);
				}
			});
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}



public class PlikiGraficzne0 {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame f = new JFrame();
				
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(300, 300);
				AnimowanaEtykieta etykieta = new AnimowanaEtykieta();
				f.add(etykieta);
				f.setVisible(true);
				ExecutorService exec = Executors.newFixedThreadPool(2);
				exec.execute(etykieta);
			}
		});

	}

}
