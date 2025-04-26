# Hangman Game 🎮

A GUI-based Hangman game developed in Java using the Swing framework. The game selects a random word from a list and allows users to guess letters, tracking incorrect attempts visually. It demonstrates principles of event-driven programming, file handling, and user interaction in a graphical interface.

## What is Hangman?

Hangman is a traditional word-guessing game where a player tries to guess a hidden word, one letter at a time.

- Correct guesses reveal the letter in its correct position(s).
- Incorrect guesses are counted as mistakes.
- The player wins by guessing the word before exceeding the allowed number of incorrect guesses.
- This project brings Hangman to life with a graphical user interface, interactive buttons, and visual feedback.

## Features

- Interactive GUI built with Java Swing  
- Random word selection from an external text file (`nouns.txt`)  
- Visual feedback for correct and incorrect guesses  
- Tracks remaining attempts using a health display  
- Prevents repeated guesses  
- Displays win or lose messages and offers to restart or exit  

## How It Works

1. On clicking **"New Game"**, the game selects a random word from `nouns.txt`.
2. The user guesses the word one letter at a time using clickable buttons.
3. The game ends when:
   - The player successfully guesses the word.
   - The maximum number of incorrect guesses is reached.
4. After completion, the player can choose to restart or exit.

## Technologies Used

- Java  
- Swing (for GUI components)  
- File I/O 
- Object-Oriented Programming  

## Note

Ensure the `nouns.txt` file is located in the correct directory:  
`src/hangman/nouns.txt`  
The game will not run correctly if the file is missing or misplaced.
