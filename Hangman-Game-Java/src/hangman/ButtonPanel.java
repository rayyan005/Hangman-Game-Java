package hangman;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	
	private JButton[] letterButtons = new JButton[26];
	
	public ButtonPanel(WordPanel wordPanel, HealthPanel healthPanel) {
		
		setLayout(new GridLayout(2,13));
		char letter = 'A';
		
		for (int i = 0; i<26; i++) {
			
			//Creating the letter button
			letterButtons[i] = new JButton(String.valueOf(letter));
			letter++;
			
			//Action Listener for the button when clicked
			letterButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton clickedButton = (JButton) e.getSource();
					String guessedLetter = clickedButton.getText();
					
					boolean healthAvailable = false;
					
					//Checking if letter is in the word
					if(!wordPanel.guess(guessedLetter)) {
						//removing life if guess is incorrect
						healthAvailable = healthPanel.removeLife();
					}
					
					//Checking if health is available or not
					if(healthAvailable) {
						JOptionPane.showMessageDialog(wordPanel, "You have run out of lives!!. The word was: "+wordPanel.getActualWord());
						
						healthPanel.setVisible(false);
						wordPanel.setVisible(false);
						setVisible(false);
					}
					
					//Checking if word is guessed correctly
					else if(wordPanel.isWordGuessed()) {
						JOptionPane.showMessageDialog(wordPanel, "Congrats!! You guessed the word correctly.");
						
						healthPanel.setVisible(false);
						wordPanel.setVisible(false);
						setVisible(false);
					}
					
					//The clicked button is disabled as it has already been used 
					clickedButton.setEnabled(false);
				}
				
			});
			
			//Adding the buttons into the panel
			add(letterButtons[i]);
			
		}
	}
	
	

}
