package p4;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Guessing Game!");

        while (true) {
            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean wonRound = false;

            System.out.println("\nNew round started. Guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ".");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed the number.");
                    wonRound = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (wonRound) {
                int score = attemptsLeft + 1; // Higher score for fewer attempts
                totalScore += score;
                System.out.println("You won this round! Score for this round: " + score);
            } else {
                System.out.println("You've used all attempts. The correct number was " + randomNumber + ".");
            }

            roundsPlayed++;
            System.out.println("Total rounds played: " + roundsPlayed);
            System.out.println("Total score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
