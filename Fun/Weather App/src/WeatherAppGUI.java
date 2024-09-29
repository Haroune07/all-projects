import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.simple.JSONObject;

public class WeatherAppGUI extends JFrame {

    private JSONObject weatherData;

    public WeatherAppGUI() {

        super("Weather App");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(450, 650);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents() {
        JTextField searchTextField = new JTextField();

        searchTextField.setBounds(15, 15, 350, 45);

        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        JLabel weatherConditionImage = new JLabel(loadImage("Weather App\\src\\assets\\weatherapp_images\\snow.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        JLabel tempLabel = new JLabel("-10 C");
        tempLabel.setBounds(0, 350, 450, 54);
        tempLabel.setFont(new Font("Dialog", Font.BOLD, 48));

        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(tempLabel);

        JLabel weatherConditionDesc = new JLabel("Snowy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("Weather App\\src\\assets\\weatherapp_images\\humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        JLabel humidityText = new JLabel("<html><b>Humidity</b> 30%</html>");
        humidityText.setBounds(90, 500, 74, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windspeedImage = new JLabel(loadImage("Weather App\\src\\assets\\weatherapp_images\\windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

        JButton searchButton = new JButton(loadImage("Weather App\\src\\assets\\weatherapp_images\\search-icon-png-5.png" , 40, 40));

        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = searchTextField.getText();
        
                if (userInput.replaceAll("\\s", "").isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a location.");
                    return;
                }
        
                weatherData = WeatherApp.getWeatherData(userInput);
        
                if (weatherData == null) {
                    JOptionPane.showMessageDialog(null, "Error: Could not retrieve weather data.");
                    return;
                }
        
                String weatherCondition = (String) weatherData.get("weather_condition");
        
                switch (weatherCondition) {
                    case "Clear":
                        weatherConditionImage.setIcon(loadImage("Weather App\\src\\assets\\weatherapp_images\\clear.png"));
                        break;
                    case "Cloudy":
                        weatherConditionImage.setIcon(loadImage("Weather App\\src\\assets\\weatherapp_images\\cloudy.png"));
                        break;
                    case "Rain":
                        weatherConditionImage.setIcon(loadImage("Weather App\\src\\assets\\weatherapp_images\\rain.png"));
                        break;
                    case "Snow":
                        weatherConditionImage.setIcon(loadImage("Weather App\\src\\assets\\weatherapp_images\\snow.png"));
                        break;
                    default:
                        break;
                }
        
                double temperature = (double) weatherData.get("temperature");
                tempLabel.setText(String.format("%.1f C", temperature));
        
                weatherConditionDesc.setText(weatherCondition);
        
                long humidity = (long) weatherData.get("humidity");
                humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");
        
                double windspeed = (double) weatherData.get("windspeed");
                windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
            }
        });

        searchButton.setBackground(Color.white);
        
        add(searchButton);
    }

    private ImageIcon loadImage(String path, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale the image
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return null;
    }

    private ImageIcon loadImage(String path) {
        try {

            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }
}
