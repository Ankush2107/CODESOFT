# Number Game - README

This is a simple Java console application called "Number Game" where the user is prompted to guess a randomly generated secret number within a specified range. The game allows the user a limited number of attempts to guess the correct number. After each guess, the program provides feedback on whether the guess was too high, too low, or correct.

## How to Play

1. Run the Java application.
2. The program will generate a random number between 1 and 100.
3. You will be prompted to enter your guess.
4. If your guess is correct, the program will congratulate you and display the number of attempts you took to guess the correct number.
5. If your guess is incorrect, the program will inform you whether your guess was too high or too low and how many attempts you have left.
6. Keep guessing until you guess the correct number or run out of attempts.
7. After each game, you will be asked if you want to play again.
8. Enter 'yes' to play again or 'no' to exit the game.

## Code Explanation

1. The code defines a `NumberGame` class that contains three methods: `getUserGuess`, `playAgain`, and the `main` method.
2. The `getUserGuess` method takes a `Scanner` object as input and prompts the user to enter their guess. It validates the input to ensure that the user enters a valid integer.
3. The `playAgain` method takes a `Scanner` object as input and prompts the user to decide whether to play the game again or not. It validates the input to ensure that the user enters either 'yes' or 'no'.
4. The `main` method is the entry point of the program and contains the game logic.
5. Within the `main` method, the game starts with a welcome message, and the user is asked if they want to play again after each round.
6. In each round, a random secret number is generated between 1 and 100, and the user has a limited number of attempts (default is 10) to guess the number correctly.
7. After each guess, the program provides feedback and updates the number of attempts left.
8. If the user guesses the correct number within the allowed attempts, they win the game. Otherwise, the game informs them of the correct number.