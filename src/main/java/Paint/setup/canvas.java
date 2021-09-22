package Paint.setup;

import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class canvas extends ScrollPane{
    public Line curLine;
    public topBar menu = null;
    public allPrefs pref = null;
    public Pane drawingPane = new Pane();
    public StackPane picdisplay = new StackPane();
    public ScrollPane scrollPane = new ScrollPane(picdisplay);

    public canvas()
    {}


    public void setlinks(topBar box, allPrefs prefs)
    {
        menu = box;
        pref = prefs;
    }


//    @Override
    public ScrollPane displaycanvas(Stage stage)
    {

//        Pane drawingPane = new Pane();
//        Scrollbar x = new Scrollbar();
//        Scrollbar y = new Scrollbar();
        //    private double drawWidth;
        //    private double drawHeight;

//        scrollPane.setPrefSize(300, 300);
        scrollPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
//        scrollPane.setStyle("-fx-focus-color: transparent;");
//        drawingPane.setPrefSize(800, 800);
        drawingPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        drawingPane.setOnMousePressed(event -> {
            if (!event.isPrimaryButtonDown()) {
                return;
            }
            curLine = new Line(
                    event.getX(), event.getY(),
                    event.getX(), event.getY()
            );
            curLine.setStrokeWidth(pref.getDrawWidth());
            curLine.setStroke(pref.getDrawColor());
            drawingPane.getChildren().add(curLine);
        });

        drawingPane.setOnMouseDragged(event -> {
            if (!event.isPrimaryButtonDown()) {
                return;
            }

            if (curLine == null) {
                return;
            }
            curLine.setStrokeWidth(pref.getDrawWidth());
            curLine.setStroke(pref.getDrawColor());
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
        return scrollPane;
    }

//    public void setDrawHeight(double drawHeight) {
//        this.drawHeight = drawHeight;
//    }

//    public void setDrawWidth(double drawWidth) {
//        this.drawWidth = drawWidth;
//    }

    public void save(Stage stage, File destination)//Default save with existing save location
    {
        if(pref.getCurrentFile() == null)
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
        pref.setCurrentFile(savefile.showSaveDialog(stage)); //Changes default save location
        try {
            WritableImage snapshot = drawingPane.snapshot(new SnapshotParameters(), null);
            BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
            assert bImage != null;
            ImageIO.write(bImage, "png", pref.getCurrentFile());
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
    }

    public void addImage(File file, Stage stage)
    {
        try
        {
            InputStream stream = new FileInputStream(file);
            javafx.scene.image.Image imag = new Image(stream); //instantiating image from file name
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
}
