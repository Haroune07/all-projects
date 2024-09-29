import java.util.Scanner;

public class ExoMDP {
    public static void main(String[] args) throws Exception {
        String mdp = "secret";
        String entrée;

        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Entrez le mot de passe: ");
            entrée = scan.nextLine();
 
            if (entrée.equals(mdp)) {
                System.out.println("Bienvenue!");
            }
            else{
                System.out.println("mot de passe incorrect. Réessayez.");
            }
        } while(!(entrée.equals(mdp)));

        scan.close();
    
    }
}
