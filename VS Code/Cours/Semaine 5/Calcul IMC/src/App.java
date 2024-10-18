import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner clavier = new Scanner(System.in);
        
        System.out.println("Entrez votre poids en kilogrammes: ");
        double masse = clavier.nextDouble();

        System.out.println("Entrez votre taille en mètres: ");
        double taille = clavier.nextDouble();

        double imc = calculerIMC(taille, masse);

        System.out.println(imc);

        if (imc >= 30) {
            System.out.println("obésité");
        }else if (imc >= 25) {
            System.out.println("surpoids");
        }else if (imc >= 18.5) {
            System.out.println("poids normal");
        }else if (imc < 18.5) {
            System.out.println("poids insuffisant");
        }

        clavier.close();
    }

    public static double calculerIMC(double taille, double poids){
        if (taille < 0 | poids < 0) {
            return -1;
        }

        return poids / Math.pow(taille, 2);
    }
}
