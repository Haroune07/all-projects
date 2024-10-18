import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
    
    JFrame frame;
    JPanel panel;

    public GUI(){
        frame = new JFrame("Simulateur de gravité");
        panel = new JPanel();

        frame.setSize(500,200);
    }
}
