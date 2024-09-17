import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int entrée;
        int randNum = (int) (Math.random() *100);
        System.out.println("Devinez le chiffre entre 1 et 100");

        while (true) {
            
            entrée = scan.nextInt();

            if (entrée != randNum) {
                if (entrée > randNum) {
                    System.out.println("plus petit");
                }

                else if( entrée < randNum) {
                    System.out.println("plus grand");
                }
            }

            else{
                System.out.println("Correct!");
                break;
            }
        }
    }
}
