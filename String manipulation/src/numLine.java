import java.io.File;
import java.util.Scanner;

public class numLine {
    public static void main(String[] args) throws Exception {
        
        int resultat = numsInLine();

        System.out.println(resultat);
    }

    public static int numsInLine(){

        int resultat = 0;

        try{

            File File = new File("String manipulation\\src\\input.txt");

            Scanner scan = new Scanner(File);


            while (scan.hasNextLine()) {
                
                String line = scan.nextLine();
                
                String num = "";

                for(char c: line.toCharArray()){
                    if (Character.isDigit(c)) {
                        num += c;
                    }
                }

                String finalNum = String.valueOf(num.charAt(0)) + String.valueOf(num.charAt(num.length()-1));

                resultat += Integer.parseInt(finalNum);

            }

        }catch(Exception e){
            System.out.println("fichier introuvable");
        }


        return resultat;
    }
}
