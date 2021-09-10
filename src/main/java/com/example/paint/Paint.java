package com.example.paint;
//JPG PNG

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Paint extends Application {
    private int width = 700;
    private int height = 700;
    private Text file = new Text(" ");
    private Text fileextension = new Text(" ");
    VBox root = new VBox();
    @Override
    public void start(Stage window)
    {
        //GridPane gridPane = new GridPane();
        //Scene scene = new Scene();
        //window.setFullScreen(true);
        window.setHeight(height);
        window.setWidth(width);
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        MenuItem open = new MenuItem("Open");
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { findimg(window); }});
        MenuItem insert = new MenuItem("Insert");
        menuFile.getItems().addAll(open,insert); //Adds open, insert to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().setAll(menuFile, menuEdit); //Adds menus to a menu bar
        VBox menuBox = new VBox(topbar); //Adds the menu to a VBox
        root.getChildren().addAll(topbar);
        Scene Defaultscene = new Scene(root);
        window.setTitle("Multiplier");
        window.setScene(Defaultscene);
        window.show(); //Constructs the stage
    }
    private void findimg(Stage stage) //Opens a file explorer to open an image
    {
        FileChooser openfile = new FileChooser(); //Creates instance of file explorer
        openfile.setTitle("Open Image");
        File filename = openfile.showOpenDialog(stage); //Records the file to be opened
        openimg(filename); //Calling openimg() to open the file
    }
    private void openimg(File filename) //Opens file found in findimg()
    {
        try{
            String extension = Files.probeContentType(filename.toPath());
            if(extension.equals("image/jpeg") || extension.equals("image/png"))
            {
                InputStream stream = new FileInputStream(filename);
                Image image = new Image(stream);
                //Creating the image view
                ImageView imageView = new ImageView();
                //Setting image to the image view
                imageView.setImage(image);
                //Setting the image view parameters
                imageView.setX(10);
                imageView.setY(10);
                if(image.getWidth() > image.getHeight())
                {
                    imageView.setFitWidth(width);
                }
                else
                {
                    imageView.setFitHeight(height);
                }
                imageView.setPreserveRatio(true);
                root.getChildren().add(imageView);
//                System.out.print(image.getWidth());
//                System.out.print(image.getHeight());
            }
            else
            {
                fileextension.setText("File Type Not Supported");
//                fileextension.setText(extension);
                System.out.print(extension);
            }
        }
        catch (IOException e)
        {
            fileextension.setText("File Extension not Recognized");
        }
    }

    public static void main(String[] args) //Main
    {
        launch(args);
    }
}