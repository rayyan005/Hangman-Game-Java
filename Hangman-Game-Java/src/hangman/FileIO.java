package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//This class has 2 methods, 1.loading the file where the words are stored and 2. choosing a random word from it.
//These 2 methods are related to each other.
//Therefore, this class exhibits high cohesion.

public class FileIO {

	private ArrayList<String> words;
	private Random random;
	
	//Loads words from the file into out 'words' arraylist.
	public void loadWords(String file) {
		words = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line;
			while((line = reader.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Selects a random word from the 'words' arraylist.
	public String randomWord() {
		random = new Random();
		int index = random.nextInt(words.size());
		return words.get(index);
	}
}