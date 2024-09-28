
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        int[][] arr = new int[3][3];

        Random rand = new Random();

        int min = arr[0][0];
        int max = arr[0][0];

        for(int i = 0; i < arr.length; i++){

            System.out.println();

            for(int j = 0; j < arr[i].length; j++){

                int r = rand.nextInt(100);

                arr[i][j] = r;

                System.out.print(arr[i][j]+ " ");

                
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }

            System.out.println();
        }

        System.out.println(min);
        System.out.println(max);
    }
}
