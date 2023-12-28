import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        playGuessTheNumber();
    }

    private static void playGuessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 8;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");

        while (true) {
            int targetNumber = random.nextInt(100) + 1;

            System.out.println("\nI've selected a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (maxAttempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                maxAttempts--;

                if (maxAttempts == 0) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total score: " + score);
                break;
            }

            // Reset attempts for the next round
            maxAttempts = 5;
        }

        scanner.close();
    }
}
