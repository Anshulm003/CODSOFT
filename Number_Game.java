// TASK 1 (NUMBER GAME)

import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        int totalScore = 0;
        boolean playAgain;
        System.out.println("Welcome ! To the Number Game");

        do {
            // Generate 4-Digit Random Number Between 1111 to 9999
            int range = rm.nextInt(9999 - 1111 + 1) + 1111;
            int atmp = 0;      // Starting Attempt
            boolean hasWon = false;
            final int maxAtmp = 10; // Maximum number of attempt per round
            System.out.println("Please ! Guess 4-Digit Number between 1111 to 9999 ");

            // User Guesses
            while (atmp < maxAtmp){
                System.out.println("Enter your Guess (Attempt " + (atmp + 1) + " of " + maxAtmp + "): ");
                int guess = sc.nextInt();
                atmp++;

                // Checking user's guess
                if (guess == range){
                    System.out.println("Congratulations ! You Guessed the Correct Number : " + range);
                    hasWon = true;
                    break;
                } else if (guess < range) {
                    System.out.println("Ops ! Your Guess is too low .");
                }else {
                    System.out.println("OMG ! Your Guess is too high .");
                }
            }

            // Check for user has played all his attempts
            if (!hasWon){
                System.out.println("You've used all your attempts, The correct number was : " + range);
            }

            // Update Score According the user won the Round
            totalScore += hasWon ? 1 : 0;
            System.out.println("Your current score is: " + totalScore);

            // User to play another round
            System.out.println("Do You want to play another round ? (yes/no) : ");
            playAgain = sc.next().equalsIgnoreCase("yes");

        } while (playAgain);

        // Final Score after the user decides to stop playing Number Game .
        System.out.println("Thank You for Playing ! Your Final Score is : "+ totalScore);
        sc.close();
    }
}