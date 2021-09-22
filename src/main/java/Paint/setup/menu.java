package Paint.setup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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

public class menu extends MenuBar {

    private allPrefs prefs;
    private canvas canva;

    public void setPref(allPrefs pref, canvas canv) {
        prefs = pref;
        canva = canv;
    }

    public menu giveMenu(Stage stage) {
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
        MenuItem drawPrefs = new MenuItem("Drawing Preferences");
        MenuItem insert = new MenuItem("Insert");
        help.setOnAction(event -> new helpPage(stage).displayHelp());
        about.setOnAction(event -> new aboutPage(stage).displayAbout());
        drawPrefs.setOnAction(event -> prefs.displayPrefWin(stage));
        saveas.setOnAction(event -> canva.saveAs(stage));
        save.setOnAction(event -> canva.save(stage, prefs.getCurrentFile()));
        open.setOnAction(actionEvent -> canva.findimg(stage));
        menuHelp.getItems().addAll(help, about);
        menuFile.getItems().addAll(open, insert, save, saveas);
        menuDraw.getItems().addAll(drawline, drawPrefs);
        //Adds open, insert, save, saveas to file dropdown
        menu topbar = new menu(); //instantiates a menu bar
        topbar.getMenus().addAll(menuFile, menuEdit, menuHelp, menuDraw);
        //Adds file, edit, about, help menus to a menu bar
        return topbar;
    }


}
