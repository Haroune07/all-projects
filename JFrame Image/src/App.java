import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class App extends JPanel{

    private BufferedImage image;

    public App(){
        File file = new File("src\\Images\\Pixbuster-Desktop-Wallpaper-4K-004.jpg");

        try{
            image = ImageIO.read(file);
        }catch(IOException e){
            System.out.println("file not found");
        }
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1270,720);

        frame.add(new App());

        frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(image,0,0,this.getWidth(), this.getHeight(),this);
    }

}
