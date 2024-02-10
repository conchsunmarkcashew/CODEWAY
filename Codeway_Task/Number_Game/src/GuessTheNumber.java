import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5; 
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've exceeded the attempts limit. The number was " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}
