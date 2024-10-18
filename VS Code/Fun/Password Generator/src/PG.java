import java.util.Random;
import java.util.Scanner;

public class PG {
    public static void main(String[] args) throws Exception {
        char[] characters = new char[87];
        int passwordLength;

        Scanner scan = new Scanner(System.in);

        System.out.println("Entrez la longueur du mot de passe");

        passwordLength = scan.nextInt();

        for (int i = 0; i < 26; i++) {
            characters[i] = (char) (i + 'a');

        }

        for (int i = 26; i < 52; i++) {
            characters[i] = (char) ((i - 26) + 'A');
        }

        for (int i = 52; i < 62; i++) {
            characters[i] = (char) ((i - 52) + '0');
        }

        for(int i = 62; i < 77; i++){
            characters[i] = (char) ((i-62) + '!');
        }

        for(int i = 77; i < 87; i++){
            characters[i] = (char) ((i-62) + '0');
        }

        for(int i = 0; i < passwordLength; i++){
            Thread.sleep(50);
            System.out.print(characters[new Random().nextInt(characters.length)]);
        }

        scan.close();

    }
}
