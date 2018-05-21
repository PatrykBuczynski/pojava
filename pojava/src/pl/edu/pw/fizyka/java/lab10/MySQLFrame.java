package pl.edu.pw.fizyka.java.lab10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class MySQLFrame extends JFrame {

	public MySQLFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setSize(600,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		conteiner = new JPanel();
		add(conteiner, BorderLayout.PAGE_START);
		textField = new JTextField("Wpisz tekst");
		textField.setPreferredSize(new Dimension(200, 20));
		textField.setHorizontalAlignment(JTextField.CENTER);
		conteiner.add(textField);
		button = new JButton("Kwerenda");
		conteiner.add(button);
		textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
	
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				int n;
				try {
					try {
						conn = DriverManager.getConnection("jdbc:mysql://db4free.net/bazadanychpojava", "testerpojava", "48091082" + 
								"");
						
						PreparedStatement prep = conn.prepareStatement("SELECT usd FROM waluty where usd < ?");
						n = Integer.parseInt(textField.getText());
						prep.setInt(1, n);
						ResultSet rs = prep.executeQuery();  
						ResultSetMetaData md  = rs.getMetaData();
						
						
						
						for (int ii = 1; ii <= md.getColumnCount(); ii++){
							textArea.setText(textArea.getText() +  md.getColumnName(ii)+ " | ");						
						}
						textArea.setText(textArea.getText() +  newLine);
						
						while (rs.next()) {
							for (int ii = 1; ii <= md.getColumnCount(); ii++){
								textArea.setText(textArea.getText() +  rs.getObject(ii) + " | ");							
							}
							textArea.setText(textArea.getText() +  newLine);
						}

					}catch(NumberFormatException e) {
						//System.out.println("To nie jest liczba!");
						JOptionPane.showMessageDialog(MySQLFrame.this, "Wpisana wartość nie jest liczbą!", "Error! Błędny format!",  JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					if (conn!= null){
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
	
			}
			
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		MySQLFrame frame = new MySQLFrame();
	}
	
	JTextField textField;
	JTextArea textArea;
	JButton button;
	JPanel conteiner;
	final static String newLine = "\n";
	
}
