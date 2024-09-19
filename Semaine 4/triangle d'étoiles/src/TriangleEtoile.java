import java.util.Scanner;

public class TriangleEtoile {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int y;

        System.out.print("Entrez la hauteur: ");
        y = scan.nextInt() / 2;

        for(int i = 1; i <= y; i++){
            
            for(int x = 1; x <= i; x++){

                Thread.sleep(5);
                System.out.print('*');

            }

            Thread.sleep(5);
            System.out.println();
        }

        for(int i = y; i >= 0; i--){

            for(int x = i; x >= 0; x--){

                Thread.sleep(5);
                System.out.print('*');

            }

            Thread.sleep(5);
            System.out.println();
        }

        scan.close();
    }
}
