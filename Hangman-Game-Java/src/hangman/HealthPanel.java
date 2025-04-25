package hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HealthPanel extends JPanel{
	
	public int incorrectGuesses;
	public JLabel healthLabels[];
	
	public HealthPanel() {
		this.incorrectGuesses = 0;
		
		setLayout(new GridLayout(1,7));
		
		//assign the size of the array as 7, as there's 7 lives.
		healthLabels = new JLabel[7];
		for (int i=0;i<7;i++) {
			
			healthLabels[i] = heartLabel(true);
			
			//adding the health labels.
			add(healthLabels[i]);
		}
	}
	
	public JLabel heartLabel(boolean b) {
		
		//Creating a heart icon.
		JLabel heart = new JLabel("❤",JLabel.CENTER);
		if (b) {
			heart.setForeground(Color.GREEN);
		}
		else {
			heart.setForeground(Color.RED);
		}
		heart.setFont(new Font("",Font.PLAIN,40));
		return heart;
	}
	
	//This is used for removing lives.
	public boolean removeLife() {
		if (incorrectGuesses < 7) {
			healthLabels[incorrectGuesses].setForeground(Color.RED);
			incorrectGuesses++;
		}
		
		//Checking if no. of incorrect guessed are equal to 7, in which all the lives have been lost.
		return incorrectGuesses==7;
	}
}
