//package Paint.setup;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.PixelFormat;
//import javafx.scene.image.PixelReader;
//import javafx.scene.image.WritablePixelFormat;
//import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
//import java.io.File;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.*;
//import javafx.scene.image.*;
//
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.*;
//import javax.imageio.ImageIO;
//import java.io.*;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.ArcType;
//import javafx.scene.shape.Rectangle;
//
//import java.io.*;
//import java.nio.ByteBuffer;
//import javax.imageio.ImageIO;
//
//public class img {
//
//    public static void saveAs(Stage stage)
//    {
//
//    }
//
//    public static void save(Stage stage)
//    {
//        BufferedImage bImage = null;
//        try {
//            File initialImage = new File("C://Users/garre/Desktop/currents.png");
//            bImage = ImageIO.read(initialImage);
//
//            ImageIO.write(bImage, "gif", new File("C://Users/garre/Desktop/currents.gif"));
//            ImageIO.write(bImage, "jpg", new File("C://Users/garre/Desktop/currents.png"));
//            ImageIO.write(bImage, "bmp", new File("C://Users/garre/Desktop/currents.bmp"));
//
//        } catch (IOException e) {
//            System.out.println("Exception occured :" + e.getMessage());
//        }
//        System.out.println("Images were written succesfully.");
//
//    }
//}


