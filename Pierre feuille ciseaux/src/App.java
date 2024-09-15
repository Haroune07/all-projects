import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] moves = { "rock", "paper", "scissors" };
        String playerMove;
        int cpuGuess;

        System.out.println("Welcome to rock paper scissors!");

        while (true) {

            int playerScore = 0;
            int cpuScore = 0;

            for (int i = 0; i < 3; i++) {
                cpuGuess = new Random().nextInt(moves.length);

                while (true) {
                    scanner = new Scanner(System.in);
                    System.out.println("Enter your move: \n");
                    playerMove = scanner.nextLine();

                    if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
                        break;
                    }

                    else {
                        System.out.println("invalid move, retry");
                    }
                }

                if (playerMove.equals(moves[cpuGuess])) {
                    System.out.println("\nCpu played: " + moves[cpuGuess]);
                    System.out.println("Draw!");
                }

                switch (playerMove) {
                    case "rock":
                        if (cpuGuess == 1) {
                            Thread.sleep(500);
                            System.out.println("\nCpu played: " + moves[1]);
                            System.out.println("Cpu wins\n");
                            cpuScore++;
                        }

                        if (cpuGuess == 2) {
                            Thread.sleep(500);
                            System.out.println("\nCpu played: " + moves[2]);
                            System.out.println("You win \n");
                            playerScore++;
                        }
                        break;

                    case "paper":
                        if (cpuGuess == 0) {
                            Thread.sleep(500);
                            System.out.println("\nCpu played: " + moves[0]);
                            System.out.println("You win \n");
                            playerScore++;
                        }

                        if (cpuGuess == 2) {
                            Thread.sleep(500);
                            System.out.println("\nCpu played: " + moves[2]);
                            System.out.println("Cpu wins \n");
                            cpuScore++;
                        }
                        break;

                    case "scissors":
                        if (cpuGuess == 0) {
                            Thread.sleep(500);
                            System.out.println("\nCpu played: " + moves[0]);
                            System.out.println("Cpu wins \n");
                            cpuScore++;
                        }

                        if (cpuGuess == 1) {
                            Thread.sleep(500);
                            System.out.println("\nCpu played: " + moves[1]);
                            System.out.println("You win\n");
                            playerScore++;
                        }
                        break;

                }

                if (playerScore == 2 || cpuGuess == 2) {
                    break;
                }

            }

            System.out.println("Cpu score: " + cpuScore);
            System.out.println("Player score: " + playerScore);

            if (cpuScore > playerScore) {
                System.out.println("\nYou lost the game!");
            } else if (playerScore > cpuScore) {
                System.out.println("\nYou won the game!");
            } else if (playerScore == cpuScore) {
                System.out.println("\nDRAW!");
            }

            System.out.println("Wanna play again? (y/n)");

            String again = scanner.nextLine();
            if (again.equals("y")) {

                System.out.println("Welcome back!");
                continue;
            }

            else {
                System.out.println("Bye!");
                break;
            }
        }

    }
}
