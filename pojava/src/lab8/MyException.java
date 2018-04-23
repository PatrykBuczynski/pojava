package lab8;



import javax.swing.JOptionPane;

public class MyException extends Exception {
	
	String correctText;
	String testedText;
	String wrongWords = "";

	public MyException(String correctText, String testedText) {
		// TODO Auto-generated constructor stub
		
		this.correctText = correctText;
		this.testedText = testedText;
		
		String [] correctTextTokenizer = correctText.split("\\s");
		String []  testedTextTokenizer = testedText.split("\\s");
		
		for(int i = 0; i<correctTextTokenizer.length; i++) {
			
			if(!correctTextTokenizer[i].equals(testedTextTokenizer[i])) {
				wrongWords = wrongWords + " " + testedTextTokenizer[i];
			}
		
		}
	}
	
	public String getWrongWords() {
			
		return wrongWords;
	}

	
	



}
