package hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame{
	
	private WordPanel wordPanel;
	HealthPanel healthPanel;
	ButtonPanel buttonPanel;
	
	public MainWindow() {
		
		setLayout(new GridLayout(6,1));
		JPanel panel = new JPanel();
		JLabel label = new JLabel("HANGMAN - The Game");
		label.setFont(new Font("",Font.BOLD,25));
		label.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel.add(label);
		add(panel);
		
		//Panel2 will contain new game and quit buttons
		JPanel panel2 = new JPanel();
		
		//Creating the new game button
		JButton newGame = new JButton("New Game");
		
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!(healthPanel==null)) {
					remove(healthPanel);
					remove(wordPanel);
					remove(buttonPanel);
				}
				
				healthPanel = new HealthPanel();
				add(healthPanel);
				
				FileIO fileIO = new FileIO();
				
				//Loading the words
				fileIO.loadWords("C:/Users/RAYYAN/git/Hangman-Game-Java/src/hangman/nouns.txt");
				
				//Selecting a random word from the list of loaded words
				String randomWord = fileIO.randomWord();
				System.out.println("The Chosen Word: "+randomWord);
				
				wordPanel = new WordPanel(randomWord);
				add(wordPanel);
				
				buttonPanel = new ButtonPanel(wordPanel,healthPanel);
				add(buttonPanel);
				
				revalidate();
			}
		});
		
		//Creating the quit button
		JButton quit = new JButton("Quit");
		
        quit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//Exits the game when quit button is clicked
				System.exit(0);
			}
		});
        
        panel2.add(newGame);
        panel2.add(quit);
        add(panel2);

		setSize(1080,600);
		setTitle("Hangman - The Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
