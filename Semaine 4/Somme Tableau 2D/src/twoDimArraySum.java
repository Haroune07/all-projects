import java.util.Random;
import java.util.Scanner;

public class twoDimArraySum {
    public static void main(String[] args) throws Exception {

        Random random = new Random();

        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();

        int y = scan.nextInt();

        int somme = 0;

        
        int[][] twoDimArray = new int[x][y];

        for(int i = 0; i < twoDimArray[y-1].length; i++){

            for(int j = 0; i < twoDimArray[x-1].length; i++){

                int rX = random.nextInt(100+1);

                twoDimArray[i][j] = rX;

                somme += twoDimArray[i][j];
            }
        }

        System.out.println(somme);

        scan.close();
    }
}

// Exercice 5 : Somme des éléments d'un tableau 2D
// Écris un programme Java qui crée un tableau 2D de taille n x m (demandée à
// l'utilisateur), puis remplit le tableau avec des nombres aléatoires entre 0
// et 100. Ensuite, utilise des boucles imbriquées pour calculer et afficher la
// somme de tous les éléments du tableau.