import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().toLowerCase().strip();
        String pal = "";

        for(int i = str.length()-1; i >= 0; i--){
            pal += str.toCharArray()[i];
        }

        if (str.equals(pal)) {
            System.out.println("Palindrome!");
        }
        else{
            System.out.println("Not a palindrome. Boo!");
        }

        scan.close();
    }
}
