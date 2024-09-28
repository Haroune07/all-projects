import java.util.Random;
import java.util.Scanner;

public class twoDimArraySum {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] table2 = new int[n][m];

        int sum = 0;

        for(int i = 0; i < table2.length; i++){

            for(int j = 0; j < table2[i].length; j++){

                int randomInt = (int) (Math.random()*100);

                table2[i][j] = randomInt;

                sum += table2[i][j];

            }

        }

        System.out.println(sum);
    }
}

// Exercice 5 : Somme des éléments d'un tableau 2D
// Écris un programme Java qui crée un tableau 2D de taille n x m (demandée à
// l'utilisateur), puis remplit le tableau avec des nombres aléatoires entre 0
// et 100. Ensuite, utilise des boucles imbriquées pour calculer et afficher la
// somme de tous les éléments du tableau.