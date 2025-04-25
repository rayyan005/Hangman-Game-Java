package hangman;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel{
	private JLabel word;
	private String guessedWord;
	private String actualWord;
	
	public WordPanel(String actualWord) {
		this.actualWord = actualWord;
		this.guessedWord = underscores(actualWord.length());
			
		word = new JLabel(guessedWord);
		word.setFont(new Font("Arial",Font.BOLD,25));
		add(word);
	}
	
	//This will create a string of underscores based on the length of the chosen word.
	private String underscores(int length) {
		String underscore = "";
		for (int i = 0; i<length; i++) {
			underscore += "_ ";
		}
		return underscore;
	}
	
	//Here we check if the guessed letter exists in the word or not
	public boolean guess(String letter) {
		String updatedWord = "";
		boolean success = false;
		for (int i=0; i<guessedWord.length(); i++) {
			//Checking if the letter at the position matches the guessed letter.
			if (String.valueOf(actualWord.charAt(i/2)).equalsIgnoreCase(letter) && i%2==0) {
				updatedWord += letter;
				//success becomes true as the guess is correct.
				success = true;
			} else {
				//Keeping the character existing right now in guessedWord
				updatedWord += guessedWord.charAt(i);
			}
		}
		
		guessedWord = updatedWord;
		word.setText(guessedWord);
		return success;
	}
	
	//Checking if the whole word has been guessed.
	public boolean isWordGuessed() {
		//We are getting rid of the spaces so we can compare 
		String guessedWord2 = guessedWord.replaceAll(" ","");
		//Checking if the guessed word is equal to the actual word.
		return guessedWord2.equalsIgnoreCase(actualWord);
	}
	
	public String getActualWord() {
		return actualWord;
	}
}
