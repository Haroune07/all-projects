import java.util.Scanner;

public class MaxMinDeuxDim {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int[][] arr = new int[3][3];

        int max = arr[0][0];
        int min = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scan.nextInt();

                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        System.out.println("maximum: ".concat(String.valueOf(max)));
        System.out.println("minimum: " + min);

    }
}
