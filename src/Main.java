import  javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        //Takes in user input for the name of the file and can correctly return width and height ========================================
        int width = 0;
        int height = 0;
        int lineRgb = 0;
        int marginRgb = 0;
        String picPath;
        BufferedImage img = null;

        picPath = IO.readln("Enter the path of the image you want to edit:\n");
            while (picPath.length() == 0) {
                picPath = IO.readln("ERROR! - PLEASE ENTER A PATH\nEnter the path of the image you want to edit:\n");
            }

        try {
            img = ImageIO.read(new File(picPath));
            width = img.getWidth();
            height = img.getHeight();
        } catch (IOException e) {
            IO.println("ERROR! - COULD NOT READ SELECTED IMAGE");
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            IO.println("ERROR! - ILLEGAL ARGUMENT");
            iae.printStackTrace();
        } catch (NullPointerException npe) {
            IO.println("ERROR! - IMAGE IS NULL");
            npe.printStackTrace();
        }

        int[][] rgbArray = new int[width][height];
        for (int x = 0; x < rgbArray.length; x++) {
            for (int y = 0; y < rgbArray[x].length; y++) {
                rgbArray[x][y] = img.getRGB(x, y);
            }
        }

        for (int x = 0; x < rgbArray.length; x++) {
            for (int y = 0; y < rgbArray[x].length; y++) {
                int r = (rgbArray[x][y] >> 16) & 0xFF;
                int g = (rgbArray[x][y] >> 8) & 0xFF;
                int b = rgbArray[x][y] & 0xFF;
                if (b > r + 15 && b > g + 5 ) {
                        rgbArray[x][y] = 0xFFFFFFFF;
                }

            }
        }

        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < rgbArray.length; x++) {
            for (int y = 0; y < rgbArray[x].length; y++) {
                output.setRGB(x, y, rgbArray[x][y]);
            }
        }
        try {
            ImageIO.write(output, "png", new File("outputImage"));

        } catch (IOException e) {
            IO.println("ERROR ! - FAILURE TO WRITE NEW IMAGE FILE");
            e.printStackTrace();
        }

    }
}