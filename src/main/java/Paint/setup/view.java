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


    Scrollbar x = new Scrollbar();
    Scrollbar y = new Scrollbar();
    public Rectangle2D scsize = Screen.getPrimary().getBounds();
    public double linewidth = 5;
    public Text fileextension = new Text(" "); //Text for exception handling
    public StackPane picdisplay = new StackPane(); //HBox for picture display
    public File currentFile = null;
    private Line curLine;
    Pane drawingPane = new Pane();

    public void setupPaint(Stage window)
    {
        window.setTitle("GS Paint");
        MenuBar topbar = menuBar(window);
        ColorPicker colorwheel = new ColorPicker();
        HBox menuBox = new HBox(10); //Adds the menu to a HBox
        menuBox.getChildren().addAll(topbar, colorwheel);
        VBox root = new VBox();
        drawingPane.setPrefSize(800, 800);
        drawingPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setPrefSize(300, 300);
        scrollPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-focus-color: transparent;");

        drawingPane.setOnMousePressed(event -> {
            if (!event.isPrimaryButtonDown()) {
                return;
            }

            curLine = new Line(
                    event.getX(), event.getY(),
                    event.getX(), event.getY()
            );
            curLine.setStrokeWidth(linewidth);
            drawingPane.getChildren().add(curLine);
        });

        drawingPane.setOnMouseDragged(event -> {
            if (!event.isPrimaryButtonDown()) {
                return;
            }

            if (curLine == null) {
                return;
            }
            curLine.setStrokeWidth(linewidth);
            curLine.setEndX(event.getX());
            curLine.setEndY(event.getY());

            double mx = Math.max(curLine.getStartX(), curLine.getEndX());
            double my = Math.max(curLine.getStartY(), curLine.getEndY());

            if (mx > drawingPane.getMinWidth()) {
                drawingPane.setMinWidth(mx);
            }

            if (my > drawingPane.getMinHeight()) {
                drawingPane.setMinHeight(my);
            }
        });

        drawingPane.setOnMouseReleased(event -> curLine = null);
        picdisplay.getChildren().add(drawingPane);
        root.getChildren().addAll(menuBox, fileextension, picdisplay);
        window.setMaximized(true);
        Scene Defaultscene = new Scene(scrollPane); //Creates the default scene
//      window.getIcons().add(new Image("/path/to/stackoverflow.jpg")); //For window icon
        window.setScene(Defaultscene); //Activates the default scene
        window.show(); //Constructs the stage
    }

    public void addImage(File file, Stage stage)
    {
        try
        {
            InputStream stream = new FileInputStream(file);
            Image imag = new Image(stream); //instantiating image from file name
            ImageView imageView = new ImageView();
            imageView.setImage(imag);
            imageView.setFitHeight(0.75*stage.getHeight());
            imageView.setFitWidth(0.75*stage.getWidth());
            imageView.setPreserveRatio(true); //Preserve the original aspect ratio
            drawingPane.getChildren().add(imageView);
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

    public boolean isIMG(File filename, Stage stage) //Check if file is image
    {
        try {
            String extension = Files.probeContentType(filename.toPath());
            if (extension.equals("image/jpeg") || extension.equals("image/png")) {return true;}

            else {   //Case if unaccepted format
                error errorMSG = new error("Image Must be of PNG or JPEG Format", stage);
                errorMSG.errorwindow();
                return false;
            }
        }
        catch (IOException e) //Case if format checking fails
        {
            error errorMSG = new error("File Extension not Recognized", stage);
            errorMSG.errorwindow();
            return false;
        }
    }

    public void save(Stage stage, File destination)//Default save with existing save location
    {
        if(currentFile == null)
        {
            saveAs(stage);
        }
        else
        {
            try {
                WritableImage snapshot = drawingPane.snapshot(new SnapshotParameters(), null);
                BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
                assert bImage != null;
                ImageIO.write(bImage, "png", destination);

            } catch (IOException e) {
                System.out.println("Exception occured :" + e.getMessage());
            }
            System.out.println("Images were written succesfully.");
        }
    }

    public void saveAs(Stage stage)//Save with or without default location
    {
        FileChooser savefile = new FileChooser(); //Creates instance of file explorer
        savefile.setTitle("Save As");
        currentFile = savefile.showSaveDialog(stage); //Changes default save location
        try {
            WritableImage snapshot = drawingPane.snapshot(new SnapshotParameters(), null);
            BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
            assert bImage != null;
            ImageIO.write(bImage, "png", currentFile);
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
    }

    public MenuBar menuBar(Stage stage)
    {
        Menu menuFile = new Menu("File"); //Instantiating the new menus
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        Menu menuDraw = new Menu("Draw");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem saveas = new MenuItem("Save As");
        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
        MenuItem drawline = new MenuItem("Line");
        MenuItem lineWp = new MenuItem("Increase Line Width");
        MenuItem lineWm = new MenuItem("Decrease Line Width");
        MenuItem insert = new MenuItem("Insert");
        help.setOnAction(event -> new helpPage(stage).displayHelp());
        about.setOnAction(event -> new aboutPage(stage).displayAbout());
        lineWp.setOnAction(event -> linewidth++);
        lineWm.setOnAction(event -> linewidth--);
        saveas.setOnAction(event-> saveAs(stage));
        save.setOnAction(event-> save(stage, currentFile));
        open.setOnAction(actionEvent -> findimg(stage));
        menuHelp.getItems().addAll(help, about);
        menuFile.getItems().addAll(open, insert, save, saveas);
        menuDraw.getItems().addAll(drawline, lineWp, lineWm);
        //Adds open, insert, save, saveas to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().addAll(menuFile, menuEdit, menuHelp, menuDraw);
        //Adds file, edit, about, help menus to a menu bar
        return topbar;
    }
}
