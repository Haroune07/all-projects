import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class IMGBYTECODE {
    public static void main(String[] args) throws Exception {
        
        try {

            File imagefile = new File("Image Bytecode\\src\\2ChocolateChipCookies.jpg");
            BufferedImage bufferedImage = ImageIO.read(imagefile);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg", baos);
            byte[] imageByte = baos.toByteArray();

            
            System.out.println("Image byte array length: " + imageByte.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
