import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int score = 100; 

        System.out.println("Welcome to the Number Guessing Game!");

        int rounds = 1;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nRound " + rounds);
            System.out.println("==============");

            boolean hasWon = false;
            attempts = 0;

            while (!hasWon && attempts < 5) {
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasWon = true;
                }
            }

            if (hasWon)
             {
                int roundScore = calculateScore(attempts);
                score += roundScore;
                System.out.println("Congratulations! You guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                System.out.println("Round Score: " + roundScore);
                System.out.println("Total Score: " + score);
            }
             else 
             {
                System.out.println("Sorry, you couldn't guess the number. The correct number was: " + randomNumber);
             }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");

            if (playAgain) {
                randomNumber = random.nextInt(100) + 1;
                rounds++;
            }
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    private static int calculateScore(int attempts) {
        if (attempts <= 3) {
            return 50; 
        } else if (attempts <= 5) {
            return 25; 
        } else {
            return 0;
        }
    }
}
