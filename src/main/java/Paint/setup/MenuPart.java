package Paint.setup;

import Paint.setup.windows.aboutPage;
import Paint.setup.windows.canSize;
import Paint.setup.windows.helpPage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class MenuPart{

    private allPrefs prefs;

    public MenuPart(allPrefs pref)
    {
        prefs = pref;
    }

    public MenuBar build()
    {
        Menu menuFile = new Menu("File"); //Instantiating the new menus
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        MenuItem newTab = new MenuItem("New Tab");
        MenuItem save = new MenuItem("Save");
        MenuItem saveas = new MenuItem("Save As");
        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
        MenuItem zoomp = new MenuItem("Zoom+");
        MenuItem zoomm = new MenuItem("Zoom-");
        MenuItem insert = new MenuItem("Insert");
        MenuItem undo = new MenuItem("Undo");
        MenuItem redo = new MenuItem("Redo");
        MenuItem canvs = new MenuItem("Canvas Size");
        insert.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
        save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        help.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN));
        newTab.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        undo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
        redo.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));

        help.setOnAction(event -> new helpPage(prefs).displayHelp());
        about.setOnAction(event -> new aboutPage(prefs).displayAbout());
        undo.setOnAction(event -> prefs.getDrawPane().undo());
        redo.setOnAction(event -> prefs.getDrawPane().redo());
        canvs.setOnAction(event -> new canSize(prefs).build());
        saveas.setOnAction(event -> new pics(prefs).saveAs());
        save.setOnAction(event -> new pics(prefs).save());
        insert.setOnAction(actionEvent -> new pics(prefs).findimg());
        newTab.setOnAction(event-> new TabBar(prefs).addTab(prefs.getTabCont()));
        menuHelp.getItems().addAll(help, about);
        menuFile.getItems().addAll(newTab, insert, save, saveas,zoomp, zoomm);
        menuEdit.getItems().addAll(undo, redo, canvs);
//        menuDraw.getItems().addAll(drawline, drawPrefs);
        //Adds open, insert, save, saveas to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().addAll(menuFile, menuEdit, menuHelp);
        //Adds file, edit, about, help menus to a menu bar
        return topbar;
    }



}
