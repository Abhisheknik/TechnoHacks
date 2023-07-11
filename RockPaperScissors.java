import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your move (rock, paper, or scissors): ");
            String playerMove = scanner.nextLine().toLowerCase();

            // Validate player's move
            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Generate computer's move
            int computerMoveIndex = random.nextInt(3);
            String[] moves = {"rock", "paper", "scissors"};
            String computerMove = moves[computerMoveIndex];

            System.out.println("Computer's move: " + computerMove);

            // Determine the winner
            String result = determineWinner(playerMove, computerMove);
            System.out.println(result);

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing Rock, Paper, Scissors!");
        scanner.close();
    }

    private static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        }

        if (
            (playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))
        ) {
            return "You win!";
        }

        return "Computer wins!";
    }
}
