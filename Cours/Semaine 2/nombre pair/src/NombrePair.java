import java.util.Scanner;

public class NombrePair {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int nombres = scan.nextInt();

        System.out.println("Entrez la seuil maximal inclusif afin de trouver tous les nombres pairs");

        for (int i = 0; i <= nombres; i++) {

            int reste = i % 2;

            if (reste == 0) {
                System.out.println(i);
            }
        }

        scan.close();
    }
}
