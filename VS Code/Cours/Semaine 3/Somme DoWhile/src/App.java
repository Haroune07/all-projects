import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        int Usernum;

        do{
            System.out.println("Entrez un nombre entier");

            Usernum = scanner.nextInt();
            sum += Usernum;
            
        }while(Usernum != 0);

        
        System.out.println("La somme est: " + sum);
        scanner.close();
    }
}
