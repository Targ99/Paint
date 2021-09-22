package Paint.setup;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

public class topBar extends HBox{

    private final menu menues = new menu();
    private final ColorPicker colorwheel = new ColorPicker();
    private canvas canvas = null;
    private allPrefs pref = null;

    public void setlinks(canvas canv, allPrefs prefs)
    {
        canvas = canv;
        pref = prefs;
        menues.setPref(prefs, canv);
    }

    public HBox displayTB(Stage stage)
    {
        menu menuinsert = menues.giveMenu(stage);
        colorwheel.setOnAction(event-> getColors(colorwheel));
        HBox menuBox = new HBox(); //Adds the menu to a HBox
        menuBox.getChildren().addAll(menuinsert, colorwheel);
        return menuBox;
    }

    public void getColors(ColorPicker colorwheel)
    {
        javafx.scene.paint.Color fx = colorwheel.getValue();
        pref.setDrawColor(fx);

//      java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),
//              (float) fx.getGreen(),
//              (float) fx.getBlue(),
//              (float) ((javafx.scene.paint.Color) fx).getOpacity());
    }

}
