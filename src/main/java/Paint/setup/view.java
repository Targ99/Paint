package Paint.setup;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class view {
    private Menu remove;
    private float totalWidth = 700;
    private final float width = 900; //Class vars for height + width
    private final float height = 700;
    private final Text fileextension = new Text(" "); //Text for exception handling
    private final VBox root = new VBox(); //Vbox addressable by multiple functions
    private final HBox picdisplay = new HBox(); //HBox for picture display


    public void setupPaint(Stage window) {
        window.setHeight(height); //Setting stage height + width
        window.setWidth(width);
//      window.getIcons().add(new Image("/path/to/stackoverflow.jpg")); //For window icon
        fileextension.setFill(Color.RED);
        Menu menuFile = new Menu("File"); //instantiating the new menus
        Menu menuEdit = new Menu("Edit");
        MenuItem open = new MenuItem("Open");
        Menu remove = new Menu("Remove");
        MenuItem insert = new MenuItem("Insert");
        menuFile.getItems().addAll(open,insert, remove); //Adds open, insert, remove to file dropdown
        MenuBar topbar = new MenuBar(); //instantiates a menu bar
        topbar.getMenus().setAll(menuFile, menuEdit); //Adds menus to a menu bar
        VBox menuBox = new VBox(topbar); //Adds the menu to a VBox
        root.getChildren().addAll(topbar, fileextension, picdisplay);
        Scene Defaultscene = new Scene(root); //Creates the default scene
        window.setTitle("GS Paint");
        window.setScene(Defaultscene); //Activates the default scene
        window.show(); //Constructs the stage
//        @Override
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { new img().findimg(window); }});
    }
}
