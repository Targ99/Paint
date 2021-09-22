package Paint.setup;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/*
import javafx.scene.image.PixelReader; //Helpful libraries that will be useful later
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
*/


public class view
{
    public view(Stage window)
    {
        window.setTitle("GS Paint");
        canvas canva = new canvas();
        ScrollPane displayCanvas = canva.displaycanvas(window);
        topBar topMenu = new topBar();
        HBox displayTop = topMenu.displayTB(window);
        allPrefs prefs = new allPrefs();
        topMenu.setlinks(canva, prefs);
        canva.setlinks(topMenu, prefs);
//        window.setMaximized(true);
        VBox viewBox = new VBox();
        viewBox.getChildren().addAll(displayTop, displayCanvas);
        Scene dscene = new Scene(viewBox); //Creates the default scene
//      window.getIcons().add(new Image("")); //For window icon
        window.setScene(dscene); //Activates the default scene
        window.show(); //Constructs the stage
    }
}
