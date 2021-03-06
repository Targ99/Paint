package Paint.setup;

import Paint.setup.windows.error;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class pics{

    private allPrefs prefs;
//    private drawBoard board;

    public pics(allPrefs pref)
    {
        prefs = pref;
    }

    /**
     * saves in the tab's current save location
     * calls saveas if no location exists
     */
    public void save()//Default save with existing save location
    {
        if(prefs.getCurrentFile() == null)
        {
            saveAs();
        }
        else
        {
            try {
                WritableImage snapshot = prefs.getCurrPane().snapshot(new SnapshotParameters(), null);
                BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
                assert bImage != null;
                ImageIO.write(bImage, "png", prefs.getCurrentFile());

            } catch (IOException e) {
                System.out.println("Exception occured :" + e.getMessage());
            }
            System.out.println("Images were written succesfully.");
        }
    }

    /**
     * called when no current save location exists, or when a new save location is desired
     */

    public void saveAs()//Save with or without default location
    {
        FileChooser savefile = new FileChooser(); //Creates instance of file explorer
        savefile.setTitle("Save As");
        prefs.setCurrentFile(savefile.showSaveDialog(prefs.getWindow())); //Changes default save location
        prefs.getCurrTab().setSaveSpace(prefs.getCurrentFile());
        prefs.getCurrTab().setText(prefs.getCurrentFile().toString());
        try {
            WritableImage snapshot = prefs.getCurrPane().snapshot(new SnapshotParameters(), null);
            BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
            assert bImage != null;
            ImageIO.write(bImage, "png", prefs.getCurrentFile());
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
    }

    /**
     * adds the given image to the current pane
     * @param file
     * @param stage
     */

    public void addImage(File file, Stage stage)
    {
        try
        {
            InputStream stream = new FileInputStream(file);
            javafx.scene.image.Image imag = new Image(stream); //instantiating image from file name
            ImageView imageV = new ImageView(imag);
            imageV.setPreserveRatio(true);
            imageV.setFitWidth(prefs.getCanvW());
            prefs.getCurrPane().getChildren().add(imageV);
            prefs.getDrawPane().addStep(imageV);
        }
        catch(IOException e)
        {
            error errorMSG = new error("Image Must be of PNG, GIF, or JPEG Format");
            errorMSG.errorwindow(prefs);
        }
    }

    /**
     * function to find and initiate image insertion
     */
    public void findimg() //Opens a file explorer to find an image
    {
        FileChooser openfile = new FileChooser(); //Creates instance of file explorer
        openfile.setTitle("Open Image");
        File filename = openfile.showOpenDialog(prefs.getWindow()); //Records the file to be opened

        if (isIMG(filename, prefs.getWindow()))
        {
            addImage(filename, prefs.getWindow()); //Calling addImage() to open the file
        }
    }

    /**
     * function checks whether the given file contains an image
     * @param filename
     * @param stage
     * @return true if allowable image format, false otherwise
     */
    public boolean isIMG(File filename, Stage stage) //Check if file is image
    {
        try {
            String extension = Files.probeContentType(filename.toPath());
            if (extension.equals("image/jpeg") || extension.equals("image/png") || extension.equals("image/gif")) {return true;}

            else {   //Case if unaccepted format
                error errorMSG = new error("Image Must be of PNG, GIF, or JPEG Format");
                errorMSG.errorwindow(prefs);
                return false;
            }
        }
        catch (IOException e) //Case if format checking fails
        {
            error errorMSG = new error("File Extension not Recognized");
            errorMSG.errorwindow(prefs);
            return false;
        }
    }

}
