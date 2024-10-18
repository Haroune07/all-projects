import java.util.Scanner;

public class SymTriangle {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt() * 2;


        for(int i = 1; i <= len; i+=2){

            int space = len - i;

            String line = "";

            for(int j = 0; j < space / 2; j++){
                line += ' ';
            }

            for(int k = 1; k <= i; k++){
                line += '*';
            }

            System.out.println(line);

        }
    }
}
