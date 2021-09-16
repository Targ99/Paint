package Paint;
//PixelReader + PixelWriter + WritableImage
import Paint.setup.view;
import javafx.application.Application; //Imports
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
//import javafx.scene.image.PixelReader; //Helpful libraries that will be useful later
//import javafx.scene.image.PixelWriter;
//import javafx.scene.image.WritableImage;

public class Paint extends Application
{
//    @Override
    public void start(Stage window)
    {
        new view().setupPaint(window);
    }

    public static void main(String[] args) //Main
    {
        launch(args);
    }
}