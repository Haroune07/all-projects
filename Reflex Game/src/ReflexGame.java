import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Random;

public class ReflexGame implements ActionListener {
    JFrame frame = new JFrame();
    JPanel bPanel = new JPanel();
    JPanel textPanel = new JPanel();
    JPanel scorePanel = new JPanel();

    Font font = new Font("Courier New", Font.BOLD, 25);
    
    JPanel endPanel = new JPanel();

    JLabel textLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JLabel scoreNum = new JLabel();

    JLabel gameOver = new JLabel("Game Over!");
    JLabel missed = new JLabel();
    JLabel accurate = new JLabel();
    JLabel EndScoreLabel = new JLabel();

    JButton[] buttons = new JButton[25];

    boolean AnyButtonClicked = false;

    int rounds = 5;
    int score = 0;
    int r;
    int StartingIn = 4;
    int missedShots = 0;
    int accurateShots;
    int EndsIn = 20;

    public ReflexGame() throws InterruptedException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);

        textLabel.setText("Touch the red square as fast as possible.");
        textLabel.setFont(new Font("Serif", Font.BOLD, 25));

        textPanel.setBounds(0, 0, 500, 100);
        textPanel.setLayout(new FlowLayout());
        textPanel.add(textLabel);

        bPanel.setLayout(new GridLayout(5, 5));
        bPanel.setBounds(0, 100, 500, 500);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(this);
            bPanel.add(buttons[i]);
        }

        scoreLabel.setText("Your score is: " + String.valueOf(score));
        scoreLabel.setFont(new Font("Monospace", Font.BOLD, 20));

        scorePanel.setLayout(new FlowLayout());
        scorePanel.setBounds(0, 600, 500, 100);
        scorePanel.add(scoreLabel, scoreNum);

        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(bPanel);
        frame.add(scorePanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        Timer countTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StartingIn--;

                if (StartingIn > 0) {
                    Showcountto3();
                }

                if (StartingIn <= 0) {
                    textLabel.setText("Quick!");
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        countTimer.setInitialDelay(2000);
        countTimer.start();

        Timer firstRedButton = new Timer(4000, e -> redButton());
        firstRedButton.setRepeats(false);
        firstRedButton.start();

        Timer CountDownTimer = new Timer(1000, e -> ShowCountDowntoEnd());
        CountDownTimer.setInitialDelay(5000);

        for(int i = 0; i < 20; i++){
            CountDownTimer.start();
        }

        Timer endGameTimer = new Timer(25000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.DARK_GRAY);

                frame.getContentPane().removeAll();

                endPanel.setLayout(new GridLayout(4,1));
                endPanel.setBackground(Color.DARK_GRAY);

                gameOver.setText("Game Over!");
                gameOver.setFont(font);
                gameOver.setForeground(Color.WHITE);

                missed.setText("Missed shots: " + missedShots);
                missed.setFont(font);
                missed.setForeground(Color.WHITE);

                accurate.setText("Accurate shots: " + accurateShots);
                accurate.setFont(font);
                accurate.setForeground(Color.WHITE);

                EndScoreLabel.setText("Score: " + score);
                EndScoreLabel.setFont(font);
                EndScoreLabel.setForeground(Color.WHITE);

                endPanel.add(gameOver);
                endPanel.add(missed);
                endPanel.add(accurate);
                endPanel.add(EndScoreLabel);

                frame.add(endPanel);

                frame.revalidate();
                frame.repaint();
            }
        });
        endGameTimer.setRepeats(false);
        endGameTimer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getBackground() == Color.red) {

                accurateShots++;
                score += 1;
                scoreLabel.setText("Your score is: " + score);

                cleanlastButton();
                redButton();
            }

            else if (e.getSource() == buttons[i] && buttons[i].getBackground() != Color.red) {
                score -= 1;
                scoreLabel.setText("Your score is: " + score);
                missedShots++;
            }

            if (score <= 0) {
                score = 0;
                scoreLabel.setText("Your score is: " + score);
            }
        }
    }

    public void redButton() {

        Random random = new Random();
        r = random.nextInt(buttons.length);
        buttons[r].setBackground(Color.red);

    }

    public void cleanlastButton() {
        buttons[r].setBackground(Color.WHITE);
    }

    public void Showcountto3() {
        textLabel.setText("Game starts in " + String.valueOf(StartingIn));
    }
    
    public void ShowCountDowntoEnd(){
        textLabel.setText(String.valueOf(EndsIn-=1));
    }

    public static void main(String[] args) throws InterruptedException {
        new ReflexGame();
    }

}
