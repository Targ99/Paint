package Paint.setup;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TopBar{

    private allPrefs prefs;

    private TabBar(allPrefs pref)
    {
        prefs = pref;
    }

    private final ColorPicker colorwheel = new ColorPicker();
    private final ColorPicker strokewheel = new ColorPicker();
    private Rectangle currCol, currStr;

    public HBox displayTB()
    {
        MenuBar menuinsert = new MenuPart().giveMenu();
        Text str = new javafx.scene.text.Text("Stroke:");
        Text col = new javafx.scene.text.Text("Fill:");
        currCol = new Rectangle();
        currCol.setHeight(15);
        currCol.setWidth(15);
        currStr = new Rectangle();
        currStr.setHeight(15);
        currStr.setWidth(15);
        colorwheel.getStyleClass().add("button");
        strokewheel.getStyleClass().add("button");
        currCol.setFill(drawColor);
        currStr.setFill(strokeColor);
        colorwheel.setOnAction(event-> getColors());
        strokewheel.setOnAction(event-> getStroke());
        HBox menuBox = new HBox(5); //Adds the menu to a HBox
        menuBox.getChildren().addAll(menuinsert, colorwheel,strokewheel, col, currCol, str, currStr);
        return menuBox;
    }

    public void getColors()
    {
        javafx.scene.paint.Color fx = colorwheel.getValue();
        drawColor = fx;
        currCol.setFill(drawColor);
        currStr.setFill(strokeColor);
    }

    public void getStroke()
    {
        javafx.scene.paint.Color fx = strokewheel.getValue();
        strokeColor = fx;
        currCol.setFill(drawColor);
        currStr.setFill(strokeColor);
    }

    public void refreshCol()
    {
        currCol.setFill(drawColor);
        currStr.setFill(strokeColor);
    }

}
