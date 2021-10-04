package Paint.setup;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
//        Menu menuDraw = new Menu("Draw");
        MenuItem newTab = new MenuItem("New Tab");
        MenuItem save = new MenuItem("Save");
        MenuItem saveas = new MenuItem("Save As");
        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
//        MenuItem drawline = new MenuItem("Line");
//        MenuItem drawPrefs = new MenuItem("Drawing Preferences");
        MenuItem zoomp = new MenuItem("Zoom+");
        MenuItem zoomm = new MenuItem("Zoom-");
        MenuItem insert = new MenuItem("Insert");
        insert.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
        save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        help.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN));
        newTab.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
//        zoomp.setOnAction(event -> zoomin());
//        zoomm.setOnAction(event -> zoomout());
        help.setOnAction(event -> new helpPage(prefs).displayHelp());
        about.setOnAction(event -> new aboutPage(prefs).displayAbout());
//        drawPrefs.setOnAction(event -> new prefWin(prefs).displayPrefWin());
        saveas.setOnAction(event -> new pics(prefs).saveAs());
        save.setOnAction(event -> new pics(prefs).save());
        insert.setOnAction(actionEvent -> new pics(prefs).findimg());
        newTab.setOnAction(event-> new TabBar(prefs).addTab(prefs.getTabCont()));
        menuHelp.getItems().addAll(help, about);
        menuFile.getItems().addAll(newTab, insert, save, saveas,zoomp, zoomm);
//        menuDraw.getItems().addAll(drawline, drawPrefs);
        //Adds open, insert, save, saveas to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().addAll(menuFile, menuEdit, menuHelp);
        //Adds file, edit, about, help menus to a menu bar
        return topbar;
    }

//    public void zoomin()
//    {
//        prefs.setScaleY(2);
//        prefs.setScaleX(2);
//    }
//
//    public void zoomout()
//    {
//        prefs.setScaleX(.5);
//        prefs.setScaleY(.5);
//    }
}
