
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 25; i++){
            int r = random.nextInt(126-33);
            sb.append((char) (r+'!'));
        }

        System.out.println(sb.toString());

        System.out.println((char) 40);
        
    }
}
