import java.io.File;
import java.util.Scanner;

public class ForEachLoop {
    public static void main(String[] args) throws Exception {
        
        try {
            
        File texte = new File("Semaine 3\\ForEachLoop et somme des éléments\\src\\input.txt");

        Scanner scanner = new Scanner(texte);
        
        int result = 0;

        while (scanner.hasNext()) {

            String ligne = scanner.nextLine();

            for(char c : ligne.toCharArray()){
                if (Character.isDigit(c)) {
                    result += Integer.parseInt(String.valueOf(c));
                }
            }

        }

        System.out.println(result);

        scanner.close();

        } catch (Exception e) {
            System.out.println("Fichier introuvable");
        }
        
    }
}
