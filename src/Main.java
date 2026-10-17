import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("=== New Game of Craps ===");

            // Initial roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                int point = sum;
                System.out.println("The point is now " + point + ".");

                boolean gameOver = false;
                while (!gameOver) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        gameOver = true;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point (" + point + ")...");
                    }
                }
            }

            playAgain = askToPlayAgain(in);
            System.out.println();
        }

        System.out.println("Thanks for playing!");
        in.close();
    }

    // Keeps asking until the user types a valid answer, so bad input can't crash or break the program
    private static boolean askToPlayAgain(Scanner in) {
        while (true) {
            System.out.print("Play again? (y/n): ");
            String answer = in.nextLine().trim().toLowerCase();

            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            } else if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Invalid input. Please enter y or n.");
        }
    }
}