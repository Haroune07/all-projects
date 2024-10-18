import java.util.Arrays;
import java.util.Scanner;

public class Concat {
    public static void main(String[] args) throws Exception {
        int[] abc = new int[5];

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < abc.length; i++){
            abc[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(abc));
        scanner.close();
    }
}
