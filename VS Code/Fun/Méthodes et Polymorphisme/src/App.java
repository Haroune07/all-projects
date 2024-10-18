import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

    }


    public static int factorialOf(int n){

        int result = 1;

        for(int i = 1; i <= n; i++){
            result *= i;
        }

        return result;
    }

    public static int sum(int... nums){

        int sum = 0;

        for(int n : nums){
            sum += n;
        }

        return sum;
    }

    public static String reverse(String str){
        String reverse = "";

        for(int i = str.length()-1; i >= 0; i--){
            reverse += str.charAt(i);
        }

        return reverse;
    }

    public static int reverse(int num){

        String numStr = String.valueOf(num);
        String revNum = "";

        for(int i = numStr.length()-1; i >=0; i--){
            revNum += numStr.charAt(i);
        }

        return Integer.parseInt(revNum);
    }

    public static boolean isPair(int num){
        if (num % 2 != 0) {
            return false;
        }

        return true;
    }

    public static String read(){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static String read(File file) throws FileNotFoundException{
        Scanner scanner = new Scanner(file);

        String fileString = "";

        while (scanner.hasNextLine()) {
            fileString += scanner.nextLine() + "\n";
        }

        scanner.close();
        return fileString;
    }



}
