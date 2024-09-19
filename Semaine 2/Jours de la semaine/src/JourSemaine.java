import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JourSemaine {
    public static void main(String[] args) throws Exception {
      
        Map<Integer,String> map = new HashMap<>();
        String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        Scanner scanner = new Scanner(System.in);

        int dayOfWeek;

        for(dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++){
            map.put(dayOfWeek, days[dayOfWeek]);
        }

        System.out.println("Quel jour de la semaine est-on?");

        dayOfWeek = scanner.nextInt();

        String askedDay = map.get(dayOfWeek - 1);

        System.out.println("Ah! Nous sommes déjà le " + askedDay);
        
    }
}
