import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class App {

    private static final Map<String, Locale> countryLocaleMap = new HashMap<>();

    static {
        countryLocaleMap.put("FR", Locale.FRANCE); // Use Locale constants for non-deprecated alternatives
        countryLocaleMap.put("EN", Locale.US); // Or Locale.UK, depending on your preference
        countryLocaleMap.put("ES", new Locale.Builder().setLanguage("es").setRegion("ES").build()); // Spanish locale
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the two-letter language code (FR for French, EN for English, ES for Spanish):");
        String language = scanner.nextLine().toUpperCase();

        Locale locale = countryLocaleMap.get(language);

        if (locale == null) {
            System.out.println("Invalid Language Code");
            scanner.close();
            return;
        }

        ResourceBundle bundle;
        try {
            bundle = ResourceBundle.getBundle("message", locale);
        } catch (MissingResourceException e) {
            System.out.println("No language bundle found for the specified language.");
            scanner.close();
            return;
        }

        boolean continueChat = true;
        while (continueChat) {
            try {
                System.out.println(bundle.getString("greeting")); // Localized greeting message
                String userInput = scanner.nextLine().toUpperCase();

                if ("EXIT".equals(userInput)) {
                    continueChat = false; // Exit condition
                    System.out.println(bundle.getString("goodbye")); // Localized goodbye message
                } else {
                    System.out.println(bundle.getString("response")); // Localized response to input
                }
            } catch (MissingResourceException e) {
                System.out.println("No language found for that key.");
            }
        }

        scanner.close();
    }
}
