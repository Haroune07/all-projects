import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez un chiffre entier");
        scanner.nextInt();

       /*  switch (0) {
            case (nombreEntré % 2):
                System.out.println("Divisible par 2");
                break;

            case (nombreEntré % 3):
                System.out.println("Divisible par 3");
                break;

            case (nombreEntré % 5):
                System.out.println("Divisible par 5");
                break;

            default:
                System.out.println("Non divisible par 2, 3 ou 5");
                break;
        }*/

        scanner.close();
    }
}

