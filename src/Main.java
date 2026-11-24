import  javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Takes in user input for the name of the file and can correctly return width and height ========================================
        int width = 0;
        int height = 0;
        String picPath;

        picPath = IO.readln("Enter the path of the image you want to edit:\n");
            while (picPath.length() == 0) {
                picPath = IO.readln("ERROR! - PLEASE ENTER A PATH\nEnter the path of the image you want to edit:\n");
            }

        try {
            BufferedImage img = ImageIO.read(new File(picPath));
                if (img == null) {
                    IO.println("ERROR! - CANNOT READ SELECTED IMAGE");
                }
            width = img.getWidth();
            height = img.getHeight();
            IO.println("The width is " + width +" and the height is " + height);
        } catch (IOException e) {
            IO.println("ERROR! - COULD NOT READ SELECTED IMAGE");
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        int[][] rgbArray = new int[width][height];
        for (int i = 0; i < rgbArray.length; i++) {
            for (int k = 0; k < rgbArray[].legnth; k++) {
                
            }
        }


    }
}