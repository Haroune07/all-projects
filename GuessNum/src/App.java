import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        String[] refusal = {"Wrong!", "No!", "Too bad!", "Try Again!"};
        String[] goodAnswer = {"Nice!", "Spot on!", "Lucky!", "Good!"};
        

        while (true) {
            int randomNum = random.nextInt(5);
            int playerNum = scan.nextInt();

            int randomAns = random.nextInt(refusal.length);

            if (randomNum == playerNum) {
                System.out.println("\n"+ goodAnswer[randomAns]);

                System.out.println("\nWanna play again? (y/n)\n");
                
                scan = new Scanner(System.in);
                String again = scan.nextLine();

                if (again.equals("y")) {
                    System.out.println();
                    continue;
                }
                else{
                    break;
                }
            }

            else{
                System.out.println(refusal[randomAns] + "\n");
                continue;
            }
        }

        scan.close();
    }
}