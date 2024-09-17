import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int primeNum = scan.nextInt();
        boolean isPrime = true;

        System.out.println("Entrez un nombre premier");
        
        for(int i = 2; i <= Math.sqrt(primeNum); i++){
            if(primeNum % i == 0){
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime);
    }
}
