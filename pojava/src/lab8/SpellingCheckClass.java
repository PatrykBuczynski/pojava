package lab8;

import javax.swing.JOptionPane;

public class SpellingCheckClass {

	String correctText;
	String testedText;
	
	public SpellingCheckClass(String correctText, String testedText) {
		// TODO Auto-generated constructor stub
		this.correctText = correctText;
		this.testedText = testedText;
	}
	public void CheckSpelling() throws MyException {
		
		if(correctText.equals(testedText)) {
			
			JOptionPane.showMessageDialog(null, "Text is correct! Congratulations!");
		}
		else {
			
			throw new MyException(correctText, testedText);
		}
	}

}
