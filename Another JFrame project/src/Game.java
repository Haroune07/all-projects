import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game implements ActionListener, KeyListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JButton[][] buttons = new JButton[5][5];

    // Starting position
    int x = 0;
    int y = 0;

    int redx;
    int redy;

    int redcount;

    public Game() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(5, 5));

        // Create the grid of buttons
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.black);
                buttons[i][j].setFocusable(false);
                buttons[i][j].setEnabled(false);
                frame.add(buttons[i][j]);
            }
        }

        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);

        // Initial paint for the starting position
        paint();



    }

    // Method to paint the current position white
    void paint() {
        buttons[x][y].setBackground(Color.white);
    }

    // Method to reset the previous position to black
    void depaint() {
        buttons[x][y].setBackground(Color.black);
    }

    public void red() {
        Random random = new Random();
        redx = random.nextInt(5);
        redy = random.nextInt(5);

        buttons[redx][redy].setBackground(Color.red);
    }

    public static void main(String[] args) throws Exception {
        new Game();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks if needed (but not used here)
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Reset the current position (depaint)
        depaint();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (x > 0)
                    x--; // Move up
                break;
            case KeyEvent.VK_DOWN:
                if (x < buttons.length - 1)
                    x++; // Move down
                break;
            case KeyEvent.VK_LEFT:
                if (y > 0)
                    y--; // Move left
                break;
            case KeyEvent.VK_RIGHT:
                if (y < buttons[0].length - 1)
                    y++; // Move right
                break;
        }

        // Paint the new position
        paint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
