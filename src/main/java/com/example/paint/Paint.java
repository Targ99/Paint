package com.example.paint;
//PixelReader + PixelWriter + WritableImage
import javafx.application.Application; //Imports
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
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


public class Paint extends Application
{

    private Menu remove;
    private float totalWidth = 700;
    private float width = 900; //Class vars for height + width
    private float height = 700;
    private Text fileextension = new Text(" "); //Text for exception handling
    private VBox root = new VBox(); //Vbox addressable by multiple functions
    private HBox picdisplay = new HBox(); //HBox for picture display
    Stage window;
//    @Override
    public void start(Stage window)
    {
        window.setHeight(height); //Setting stage height + width
        window.setWidth(width);
//      window.getIcons().add(new Image("/path/to/stackoverflow.jpg")); //For window icon
        fileextension.setFill(Color.RED);
        Menu menuFile = new Menu("File"); //instantiating the new menus
        Menu menuEdit = new Menu("Edit");
        MenuItem open = new MenuItem("Open");
        Menu remove = new Menu("Remove");


        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { findimg(window); }});


        MenuItem insert = new MenuItem("Insert");
        menuFile.getItems().addAll(open,insert, remove, separator); //Adds open, insert, remove to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().setAll(menuFile, menuEdit); //Adds menus to a menu bar
        VBox menuBox = new VBox(topbar); //Adds the menu to a VBox
        root.getChildren().addAll(topbar, fileextension, picdisplay);
        Scene Defaultscene = new Scene(root); //Creates the default scene
        window.setTitle("GS Paint");
        window.setScene(Defaultscene); //Activates the default scene
        window.show(); //Constructs the stage
    }

    private void findimg(Stage stage) //Opens a file explorer to find an image
    {
        FileChooser openfile = new FileChooser(); //Creates instance of file explorer
        openfile.setTitle("Open Image");
        File filename = openfile.showOpenDialog(stage); //Records the file to be opened
        openimg(filename); //Calling openimg() to open the file
    }


    private void openimg(File filename) //Opens file found in findimg()
    {
        try{ //Checking if the image is an accepted format
            String extension = Files.probeContentType(filename.toPath());
            if(extension.equals("image/jpeg") || extension.equals("image/png"))
            {
                InputStream stream = new FileInputStream(filename);
                Image image = new Image(stream); //instantiating image from file name
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                if(image.getWidth() > image.getHeight()) //Attempt to fix oversized image
                {imageView.setFitWidth(width*0.45);}
                else
                {imageView.setFitHeight(height*0.45);}
                imageView.setPreserveRatio(true); //Preserve the original aspect ratio
                picdisplay.getChildren().add(imageView); //Adding image to Vbox to display
//                System.out.print(image.getWidth()); //Attempt to fix oversized image
//                System.out.print(image.getHeight());
                double widthUsed = image.getWidth();
                float f = (float) widthUsed;
                totalWidth = (totalWidth + f);
//                switch (numimages)
//                {
//                    case 0:
//                        image1.setText("filename");
//                        image1.setDisable(false);
//                        break;
//                    case 1:
//                        image2.setText("filename");
//                        image2.setDisable(false);
//                        break;
//                    case 2:
//                        image3.setText("filename");
//                        image3.setDisable(false);
//                        break;
//                    case 3:
//                        image4.setText("filename");
//                        image4.setDisable(false);
//                    default:
//                        fileextension.setText("No More Images Left to Delete");
//                        fileextension.setFont(Font.font(15));;
//                        break;
//                }
////                window.setWidth(totalWidth);
////                picdisplay.getScene().getWindow().sizeToScene();
////                window.sizeToScene();
            }
            else
            {   //Case if unaccepted format
                fileextension.setText("File Type Not Supported");
                fileextension.setFont(Font.font(15));

//                fileextension.setText(extension); //Used for file extension checking
//                System.out.print(extension);
            }
        }
        catch (IOException e) //Case if format checking fails
        {
            fileextension.setText("File Extension not Recognized");
        }
    }

    public static void main(String[] args) //Main
    {
        launch(args);
    }
}