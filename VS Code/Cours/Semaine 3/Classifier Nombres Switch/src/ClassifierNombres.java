
public class ClassifierNombres {
    public static void main(String[] args) throws Exception {

        int[] nombres = { 10, 25, 35, 50, 75, 82 };

        for (int i = 0; i < nombres.length; i++) {

            System.out.println("Nombre: " + nombres[i]);

            switch (nombres[i] % 5) {
                case 0:

                    System.out.println("Divisible par 5");

                    if (nombres[i] % 10 == 0) {
                        System.out.println("Divisible par 10");
                    }
                    break;

                default:
                    System.out.println("Autre cas");
                    break;
            }

            System.out.println();
        }

    }
}

/*
 * Exercice 5 : Classifier des nombres avec switch-case
 * Crée un tableau d'entiers contenant les valeurs : 10, 25, 35, 50, 75.
 * Utilisez une boucle for pour parcourir les éléments du tableau.
 * Pour chaque nombre, utilisez un switch-case pour afficher :
 * "Divisible par 5" si le nombre est divisible par 5,
 * "Divisible par 10" si le nombre est divisible par 10,
 * "Autre cas" si aucune des conditions précédentes n'est satisfaite.
 */