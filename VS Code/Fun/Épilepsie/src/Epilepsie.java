import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

public class Epilepsie {

    JFrame frame = new JFrame();
    JButton buttons[] = new JButton[25];
    Random random = new Random();

    public Epilepsie() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);

        frame.setLayout(new GridLayout(5, 5));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            frame.add(buttons[i]);
            buttons[i].setBackground(Color.red.darker());
        }

        frame.setVisible(true);

        while (true) {

            for (int i = 0; i < buttons.length; i++) {
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);
                Thread.sleep(1);
                buttons[i].setBackground(new Color(r, g, b).brighter());
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Epilepsie();
    }
}
