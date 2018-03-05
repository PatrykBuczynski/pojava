package lab3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(350, 200);
		JPanel panel = new JPanel();
		//panel.setBackground(Color.white);
		this.add(panel);
		input = new JTextField();
		input.setPreferredSize(new Dimension(100, 30));
		dodaj = new JButton("Dodaj");
		mediana = new JButton("Mediana");
		wartoscMediany = new JLabel("= 0");
		wypisaneLiczby = new JLabel("Zbiór liczb: ");
		panel.add(input);
		panel.add(dodaj);
		panel.add(mediana);
		panel.add(wartoscMediany);
		panel.add(wypisaneLiczby);
		liczby = new ArrayList<Double>();
		dodaj.addActionListener(new ActionDodajListener());
		mediana.addActionListener(new MedianaActionListener(this));
		
	}
	public class ActionDodajListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double number;
			try{
			     number = Double.parseDouble(input.getText());
			}
			catch(NumberFormatException exception){
			     System.out.println("Wrong number format.");
			}
			
			number = Double.parseDouble(input.getText());
			liczby.add(number);
			wypisaneLiczby.setText(wypisaneLiczby.getText() + " " + number);
		}
	}
	


	public MedianFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public MedianFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public MedianFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	//Na te metode uwazaj cos z nia jest nie tak
	public double policzMediane() {
		
		double mediana;
		int n = liczby.size();
		Collections.sort(liczby);
		if(n % 2 == 0){
			
			mediana = ( liczby.get(n/2) + liczby.get( (n/2) + 1 ) )/2 ;
		}
		else {
			mediana = liczby.get((int)(liczby.size()/2) + 1);
		}
			
		return mediana;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFrame frame = new MedianFrame();
		frame.setVisible(true);
	}
	JButton mediana;
	JButton dodaj;
	List<Double> liczby; //= new ArrayList<Double>();
	JTextField input;
	JLabel wartoscMediany;
	JLabel wypisaneLiczby;

}
