import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        if (quiz() == 2) {
            System.out.println("BRAVO!");
        }

    }

    public static int quiz() {
        try {

            int counter = 0;

            File file = new File("src\\input.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String str = scanner.nextLine();

                String[] ranges = str.split(",");

                int a = Integer.parseInt(ranges[0].split("-")[0]);
                int b = Integer.parseInt(ranges[0].split("-")[1]);
                int c = Integer.parseInt(ranges[1].split("-")[0]);
                int d = Integer.parseInt(ranges[1].split("-")[1]);

                if ((a >= c && b <= d) || (a <= c && b >= d)) {
                    counter++;
                }

            }

            scanner.close();
            return counter;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
