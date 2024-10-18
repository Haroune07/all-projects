import java.util.Scanner;

public class VMDP {
    public static void main(String[] args) throws Exception {

        String[] commonWords = { "123", "abc", "ABC", "Abc", "bonjour", "qwerty", "Montréal", "mtl", "Soccer",
                "Football", "salut", "basketball" };
        String SpecialC = "!@#$%?&*()_<>{}[]/€";

        Scanner scanner = new Scanner(System.in);
        String str;

        boolean upperCase;
        boolean lowerCase;
        boolean digits;

        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int SpecialCount = 0;

        Thread.sleep(1000);
        System.out.println("\n" + "Bienvenue au testeur de mot de passe!");

        Thread.sleep(1000);
        System.out.println("\n" + "Entrez un mot de passe d'au moins huit chiffres:\n");

        str = scanner.nextLine().trim();

        // Vérifier la longueur du mot de passe
        if (str.length() < 8) {
            System.out.println("Le mot de passe est trop court.");
        }

        // vérifier la présence de lettres majuscules
        for (int i = 0; i < str.length(); i++) {

            upperCase = Character.isUpperCase(str.charAt(i));
            if (upperCase) {
                upperCount++;
            }

            lowerCase = Character.isLowerCase(str.charAt(i));
            if (lowerCase) {
                lowerCount++;
            }

            digits = Character.isDigit(str.charAt(i));

            if (digits) {
                digitCount++;
            }

        }

        if (upperCount < 1) {
            System.out.println("Le mot de passe doit contenir une lettre majuscule.");
        }

        if (lowerCount < 1) {
            System.out.println("Le mot de passe doit contenir une lettre minuscule.");
        }

        if (digitCount < 1) {
            System.out.println("Le mot de passe doit contenir un chiffre.");
        }

        // vérifer la rareté du mot de passe avec une liste de mots communs
        for (String common : commonWords) {
            if (str.contains(common)) {
                System.out.println("Le mot de passe est trop commun.");
                break;
            }
        }

        for (char c : SpecialC.toCharArray()) {
            if (str.contains(Character.toString(c))) {
                SpecialCount++;
                break;
            }
        }

        if (SpecialCount < 1) {
            System.out.println("Le mot de passe doit contenir un charactère spécial");
        }

        scanner.close();
    }
}
