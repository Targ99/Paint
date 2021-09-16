//package Paint.setup;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.MenuItem;
//import javafx.stage.Stage;
//
//public class menu {
//
//    public MenuBar menuBar(Stage stage)
//    {
//        Menu menuFile = new Menu("File"); //Instantiating the new menus
//        Menu menuEdit = new Menu("Edit");
//        Menu menuAbout = new Menu("About");
//        Menu menuHelp = new Menu("Help");
//        Menu menuDraw = new Menu("Draw");
//        MenuItem open = new MenuItem("Open");
//        MenuItem save = new MenuItem("Save");
//        MenuItem saveas = new MenuItem("Save As");
//        MenuItem drawline = new MenuItem("Line");
//        //menuHelp.setOnAction(event -> new helpPage().display());
//        //menuAbout.setOnAction(event -> new aboutPage().display());
//        open.setOnAction(new EventHandler<ActionEvent>()
//            {
//                @Override
//                public void handle(ActionEvent actionEvent)
//                {
//                    findimg(stage);
//                }
//            });
//        MenuItem insert = new MenuItem("Insert");
//        menuFile.getItems().addAll(open, insert, save, saveas);
//        menuDraw.getItems().addAll(drawline);
//        //Adds open, insert, save, saveas to file dropdown
//        MenuBar topbar = new MenuBar(); //instantiates a menu bar
//        topbar.getMenus().addAll(menuFile, menuEdit, menuAbout, menuHelp);
//        //Adds file, edit, about, help menus to a menu bar
//        return topbar;
//    }
//}
