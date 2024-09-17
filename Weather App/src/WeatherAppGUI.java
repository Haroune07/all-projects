import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WeatherAppGUI extends JFrame {
    public WeatherAppGUI(){

        super("Weather App");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(450,650);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents(){
        JTextField searchTextField = new JTextField();

        searchTextField.setBounds(15,15,350,45);

        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        JButton searchButton = new JButton(loadImage("Weather App\\src\\assets\\weatherapp_images\\search.png"));
        
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375,13,47,45);
        add(searchButton);
        
        JLabel weatherConditionImage = new JLabel(loadImage("Weather App\\src\\assets\\weatherapp_images\\snow.png"));
        weatherConditionImage.setBounds(0,125,450,217);
        add(weatherConditionImage);

        JLabel tempLabel = new JLabel("10 C");
        tempLabel.setBounds(0,350,450,54);
        tempLabel.setFont(new Font("Dialog", Font.BOLD, 48));

        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(tempLabel);

        JLabel weatherConditionDesc = new JLabel("Snowy");
        weatherConditionDesc.setBounds(0,405,450,36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("Weather App\\src\\assets\\weatherapp_images\\humidity.png"));
        humidityImage.setBounds(15,500,74,66);
        add(humidityImage);

        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90,500,74,55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windspeedImage = new JLabel(loadImage("Weather App\\src\\assets\\weatherapp_images\\windspeed.png"));
        windspeedImage.setBounds(220,500,74,66);
        add(windspeedImage);

        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310,500,85,55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);
    }

    private ImageIcon loadImage(String path){
        try{

            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);

        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }
}
