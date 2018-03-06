package lab3_v2;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MedianFrame extends JFrame {

	public MedianFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(350, 200);
		lista = new ArrayList<Double>();
		poleTekstowe = new JTextField();
		bDodaj = new JButton("Dodaj");
		bMediana = new JButton("Mediana");
		mediana = new JLabel("= 0");
		wartosci = new JLabel("Zbiór liczb= ");
		poleTekstowe.setPreferredSize(new Dimension(100, 30));
		panel = new JPanel();
		this.add(panel);
		panel.add(poleTekstowe);
		panel.add(bDodaj);
		panel.add(bMediana);
		panel.add(mediana);
		panel.add(wartosci);
		
		bDodaj.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				double number;				
				try{
				     number = Double.parseDouble(poleTekstowe.getText());
				}
				catch(NumberFormatException exception){
				     System.out.println("Wrong number format.");
				}
				number = Double.parseDouble(poleTekstowe.getText());
				lista.add(number);	
				wartosci.setText(wartosci.getText() + " " + number);
			}});
		bMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediana.setText("= " + policzMediane());
				String text = "Zbior liczb: ";
				for(int i = 0; i < lista.size(); i++) {
					text = text + " " + lista.get(i);
				}
				wartosci.setText(text);
			}
		});

	}
	public double policzMediane()
	{
		double mediana;
		Collections.sort(lista);
		int n = lista.size();
		if(n % 2 == 0 ) {
			mediana = ((lista.get((n/2)-1) + lista.get(n/2))/2);
			return mediana;
		}
		else {
			
			mediana = (lista.get((int)(n/2)));
			return mediana;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFrame frame = new MedianFrame();
		frame.setVisible(true);

	}
	List<Double> lista;
	JTextField poleTekstowe;
	JLabel wartosci;
	JLabel mediana;
	JButton bDodaj;
	JButton bMediana;
	JPanel panel;

}
