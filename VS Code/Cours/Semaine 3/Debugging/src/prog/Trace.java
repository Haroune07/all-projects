package prog;

public class Trace {

	public static void main(String[] args) {
		
		int[] numbers = {6,12,52,0,48};  // tableau de nombres
        int sum = 0;
        int i = 0;

        // boucle while pour parcourir le tableau
        while (i < numbers.length) {
            int modulus = numbers[i] % 3;
            if (modulus == 0) {  // si le nombre est pair
                sum += numbers[i];  // ajouter les nombres pairs à la somme
            } else {  // sinon, afficher que le nombre est impair
                System.out.println(numbers[i] + " est impair");
            }
            i++;  // incrémenter l'indice
        }

        // affichage de la somme des nombres pairs
        System.out.println("La somme des nombres pairs est : " + sum);  

	}

}