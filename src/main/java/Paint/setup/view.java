package Paint.setup;

import Paint.Paint;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
//    public img image = new img();
    public Rectangle2D scsize = Screen.getPrimary().getBounds();
    public int width = (int)scsize.getWidth();
    public int height = (int)scsize.getHeight(); //Class vars for height + width
    public Text fileextension = new Text(" "); //Text for exception handling
    public HBox picdisplay = new HBox(); //HBox for picture display
//    public float getHeight()
//    {
//        return height;
//    }
//    public float getWidth()
//    {
//        return width;
//    }

    public void setupPaint(Stage window)
    {
        window.setTitle("GS Paint");
        MenuBar topbar = menuBar(window);
        ColorPicker colorwheel = new ColorPicker();
        HBox menuBox = new HBox(10); //Adds the menu to a HBox
        menuBox.getChildren().addAll(topbar, colorwheel);
        VBox root = new VBox();
        root.getChildren().addAll(menuBox, fileextension, picdisplay);
        window.setMaximized(true);
//      window.getIcons().add(new Image("/path/to/stackoverflow.jpg")); //For window icon
//        fileextension.setFill(Color.RED);
        Scene Defaultscene = new Scene(root); //Creates the default scene
        window.setScene(Defaultscene); //Activates the default scene
        window.show(); //Constructs the stage
    }

    public void addImage(File file, Stage stage)
    {
        try
        {
            InputStream stream = new FileInputStream(file);
            Image image = new Image(stream); //instantiating image from file name
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            if (image.getWidth() > image.getHeight()) //Attempt to fix oversized image
            {
                imageView.setFitWidth(width * 0.45);
            } else {
                imageView.setFitHeight(height * 0.45);
            }
            imageView.setPreserveRatio(true); //Preserve the original aspect ratio
            picdisplay.getChildren().add(imageView);
        }
        catch(IOException e)
        {
            error errorMSG = new error("Image Must be of PNG or JPEG Format", stage);
            errorMSG.errorwindow();
        }
    }

    public void findimg(Stage stage) //Opens a file explorer to find an image
    {
        FileChooser openfile = new FileChooser(); //Creates instance of file explorer
        openfile.setTitle("Open Image");
        File filename = openfile.showOpenDialog(stage); //Records the file to be opened
        if (isIMG(filename, stage))
        {
            addImage(filename, stage); //Calling addImage() to open the file
        }
    }

    public boolean isIMG(File filename, Stage stage) {
        try {
            String extension = Files.probeContentType(filename.toPath());
            if (extension.equals("image/jpeg") || extension.equals("image/png")) {
                return true;
            } else {   //Case if unaccepted format
                error errorMSG = new error("Image Must be of PNG or JPEG Format", stage);
                return false;
            }
        } catch (IOException e) //Case if format checking fails
        {
            error errorMSG = new error("File Extension not Recognized", stage);
            return false;
        }
    }

    public MenuBar menuBar(Stage stage)
    {
        Menu menuFile = new Menu("File"); //Instantiating the new menus
        Menu menuEdit = new Menu("Edit");
        Menu menuAbout = new Menu("About");
        Menu menuHelp = new Menu("Help");
        Menu menuDraw = new Menu("Draw");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem saveas = new MenuItem("Save As");
        MenuItem drawline = new MenuItem("Line");
        //menuHelp.setOnAction(event -> new helpPage().display());
        //menuAbout.setOnAction(event -> new aboutPage().display());
        open.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                findimg(stage);
            }
        });
        MenuItem insert = new MenuItem("Insert");
        menuFile.getItems().addAll(open, insert, save, saveas);
        menuDraw.getItems().addAll(drawline);
        //Adds open, insert, save, saveas to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().addAll(menuFile, menuEdit, menuAbout, menuHelp);
        //Adds file, edit, about, help menus to a menu bar
        return topbar;
    }
}
