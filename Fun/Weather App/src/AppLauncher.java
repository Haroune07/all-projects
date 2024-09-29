import javax.swing.SwingUtilities;

public class AppLauncher {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new WeatherAppGUI().setVisible(true);
            
                System.out.println(WeatherApp.getCurrentTime());
            }
        });
    }
}
