import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> primeNumList = new ArrayList<>();

        for(int n = 1; n < 20; n++){

            boolean isPrime = true;

            for(int i = 2; i < Math.sqrt(n); i++){

                if (n % i != 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(n);
                primeNumList.add(n);
            }
        }
        
        System.out.println(primeNumList.size());

    }
}
 