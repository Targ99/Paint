package Paint.setup;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class prefMenu {
    private allPrefs prefs;
    private ColorPicker colorpick, strokepick;
    private Label colorLabel, strokeLabel, size, sides;
    private Slider side, slide;

    public prefMenu(allPrefs pref)
    {
        prefs = pref;
    }

    /**
     * returns a populated vbox of drawing preferences
     * @return
     */
    public VBox build()
    {
        Text title = new Text("Drawing Preferences");
        title.setFont(Font.font(null, FontWeight.BOLD, 15));
        VBox drawprefs = new VBox(5);
        colorpick = new ColorPicker();
        strokepick = new ColorPicker();
        colorLabel = new Label(colorString(prefs.getDrawColor()));
        strokeLabel = new Label(colorString(prefs.getStrokeColor()));
        size = new Label("Size = " + prefs.getDrawWidth());
        sides = new Label("Sides : " + prefs.getNumsides());
        strokepick.setOnAction(event -> strokeAct());
        colorpick.setOnAction(event-> colorAct());
        GridPane markers = new drawChoice(prefs).build();
        Slider slide = buildSlider(prefs.getDrawWidth(), 0);
        Slider side = buildSlider(prefs.getNumsides(), 1);
        drawprefs.getChildren().addAll(title, colorpick, colorLabel, strokepick, strokeLabel, markers, slide, size, side, sides);
        return drawprefs;
    }

    private void colorAct()
    {
        colorLabel.setText(colorString(colorpick.getValue()));
        prefs.setDrawColor(colorpick.getValue());
    }

    private void strokeAct()
    {
        strokeLabel.setText(colorString(strokepick.getValue()));
        prefs.setStrokeColor(strokepick.getValue());
    }


    /**
     * converts a color into a string
     * @param color
     * @return string with r, g, and b values
     */
    public String colorString(Color color)
    {
        double r = color.getRed()*255;
        double g = color.getGreen()*255;
        double b = color.getBlue()*255;
        r = r-(r%1);
        g = g-(g%1);
        b = b-(b%1);
        String red = "R:" + r;
        String green = "G:" +g;
        String blue = "B:" + b;
        return red + "\n" + green + "\n" + blue;
    }

    /**
     * builds a slider
     * @param value the existing value of the attribute
     * @param choice value to decide which parameter it alters
     * @return a built slider
     */

    public Slider buildSlider(double value, int choice)
    {
        Slider slide = new Slider();
        slide.setMin(3);
        slide.setMax(40);
        slide.setShowTickLabels(true);
        slide.setShowTickMarks(true);
        slide.setMajorTickUnit(5);
        slide.setMinorTickCount(1);
        slide.setBlockIncrement(1);
        slide.setValue(value);
        slide.valueProperty().addListener((observableValue, number, t1) -> wideAct((double) t1, choice));
        return slide;
    }

    /**
     * changes preferences for draw width and polygon sides
     * @param newW value changed on the slider
     * @param choice which preference will be modified
     */

    private void wideAct(double newW, int choice)
    {
        if(choice == 0) {
            prefs.setDrawWidth(newW);
            size.setText("Size = " + (int)newW);
        }
        else
        {
            int inewW = (int)newW;
            prefs.setNumsides(inewW);
            sides.setText("Sides : " + inewW);
        }
    }
}
