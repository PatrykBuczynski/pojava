package lab8;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class MainFrame extends JFrame {
	
	JMenuBar menuBar;
	JMenu mainMenu;
	JMenu textMenu;
	JMenuItem exportItem;
	JMenuItem importItem;
	JMenuItem checkItem;
	JMenuItem reset;
	JMenuItem boldStyle;
	JMenuItem normalStyle;
	String completeText = "";

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setSize(500, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JTextPane mainEditorPane = new JTextPane();
		completeText = mainEditorPane.getText();
		menuBar = new JMenuBar();
		mainMenu = new JMenu("Options");
		textMenu = new JMenu("Text");
		exportItem = new JMenuItem("Export");
		importItem = new JMenuItem("Import");
		checkItem = new JMenuItem("Check spelling");
		reset = new JMenuItem("Reset");
		boldStyle = new JMenuItem("Bold");
		normalStyle = new JMenuItem("Normal");
		setJMenuBar(menuBar);
		menuBar.add(mainMenu);
		menuBar.add(textMenu);
		mainMenu.add(exportItem);
		mainMenu.add(importItem);
		mainMenu.add(checkItem);
		mainMenu.add(reset);
		textMenu.add(boldStyle);
		textMenu.add(normalStyle);
		add(mainEditorPane);
		importItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fc = new JFileChooser();
				String linia = "";
				FileReader fr = null;
				int returnVal = fc.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						fr = new FileReader(file);
						BufferedReader bfr = new BufferedReader(fr);
						while((linia = bfr.readLine())!= null) {
							completeText = completeText + linia;
							linia = linia.replaceAll("ó", "?");
							linia = linia.replaceAll("u", "?");
							linia = linia.replaceAll("ż", "?");
							linia = linia.replaceAll("rz", "?");
							linia = linia.replaceAll("ch", "?");
							linia = linia.replaceAll("h", "?");
							mainEditorPane.setText(mainEditorPane.getText() + linia);
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						System.out.println("File not found!");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Cannot read file");
					}
					try {
						fr.close();
					} catch(IOException e1) {
						System.out.println("Cannot close file");
					}

				}
				
				
				
			}
			
		});
		exportItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fc = new JFileChooser();
				FileWriter fw = null;
				int returnVal = fc.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						fw = new FileWriter(file);
						BufferedWriter bfw = new BufferedWriter(fw);
						String text = mainEditorPane.getText();
						bfw.write(text);
						bfw.close();
						} catch(IOException e1) {
							e1.printStackTrace();
						}
						}
				
			}
		});
		boldStyle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = mainEditorPane.getSelectedText();
				int cursorPosition = mainEditorPane.getCaretPosition();
				StyleContext context = new StyleContext();
				Style style;
				mainEditorPane.replaceSelection("");
				style = context.addStyle("Bold", null);
				StyleConstants.setBold(style, true);
				try {
					mainEditorPane.getStyledDocument().insertString(cursorPosition - text.length(), text, style);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		checkItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!mainEditorPane.getText().equals(completeText)) {
					
					JOptionPane.showMessageDialog(null, "Text is incorrect!");
				}
				if(mainEditorPane.getText().equals(completeText)) {
					JOptionPane.showMessageDialog(null, "Text is correct! Congratulations!");
				}
				
			}
			
		});
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			mainEditorPane.setText("");
			completeText = mainEditorPane.getText();
			}
			
		});
		
		
		
		setVisible(true);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainFrame frame = new MainFrame();
				
			}});

	}

}
