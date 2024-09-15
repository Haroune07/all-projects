import java.util.Scanner;

public class VC {
    public static void main(String[] args) throws Exception {
        char[] voyelles = {'a' , 'e' , 'i' , 'o' , 'u' , 'y'};
        int vCount = 0;
        int cCount = 0;

        Scanner scanner = new Scanner(System.in);

        String lecteur = scanner.nextLine();

        for(int i = 0; i < lecteur.length(); i++){
            char c = Character.toLowerCase(lecteur.charAt(i));

            if(Character.isAlphabetic(c)){
                if (c == voyelles[0] | c == voyelles[1] | c == voyelles[2] | c == voyelles[3] | c == voyelles[4] | c == voyelles[5]) {
                    vCount++;
                }

                else{
                    cCount++;
                }
            }
        }

        System.out.println("Nombre de voyelles: " + vCount);
        System.out.println("Nombre de Consonnes: " + cCount);
        scanner.close();
    }
}

