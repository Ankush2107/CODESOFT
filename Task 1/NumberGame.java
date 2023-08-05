import java.util.Scanner;
public class NumberGame {

    // Function to get user's guess and validate input
    private static int getUserGuess(Scanner sc) {
        System.out.print("Enter your guess: ");

        // !sc.hasNextInt condition will be true when user will input any alphabet or symbol. 
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please Enter a valid number: ");
            sc.next(); // Consume invalid input
        }
        return sc.nextInt();
    }


    // Function to ask if the user wants to play again and validate input
    private static boolean playAgain(Scanner sc) {
        System.out.print("Do you want to play again? (yes/no): ");
        String input = sc.next();

        // If user will enter any string other than yes or no this condition become true.
        while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            input = sc.next();
        }

        return input.equalsIgnoreCase("yes");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Game!!!");

        while (playAgain) {

            // generate a random number between 1 and 100
            int secretNumber = (int)(Math.random() * 100) + 1; 
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct answer!!");

            // It will store the number of attempts.
            int attempts = 0;
            boolean isCorrect = false;


            while (maxAttempts > attempts && !isCorrect) {
                int userGuess = getUserGuess(sc);
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts! \n You Won:) !!! ");
                    isCorrect = true;
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is Too low, You have Only " + (maxAttempts - attempts) + " attempts left " + "Try again !!");
                } else {
                    System.out.println("Your guess is Too High, You have Only " + (maxAttempts - attempts) + " attempts left " + "Try again !!");
                }
            }

            // When your all attempts is incorrect
            if (!isCorrect) {
                System.out.println("Oops! You've run out of attempts. The correct number was: " + secretNumber);
            }

            // It will start the game again if the user input yes
            playAgain = playAgain(sc);
        }

        // When the user input no
        System.out.println("Thanks for playing! Goodbye!");
        sc.close();
    }
}
