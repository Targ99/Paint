package Paint.setup;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class prefMenu {
    private allPrefs prefs;
    private ColorPicker colorpick, strokepick;
    private Label colorLabel, strokeLabel, size;

    public prefMenu(allPrefs pref)
    {
        prefs = pref;
    }

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
        strokepick.setOnAction(event -> strokeAct());
        colorpick.setOnAction(event-> colorAct());
        GridPane markers = new drawChoice(prefs).build();
        Slider slide = buildSlider();
        drawprefs.getChildren().addAll(title, colorpick, colorLabel, strokepick, strokeLabel, markers, slide);
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

    public String colorString(Color color)
    {
        String red = "R:" + color.getRed();
        String green = "G:" + color.getGreen();
        String blue = "B:" + color.getBlue();
        return red + "\n" + green + "\n" + blue;
    }

    public Slider buildSlider()
    {
        Slider slide = new Slider();
        slide.setMin(0);
        slide.setMax(40);
        slide.setShowTickLabels(true);
        slide.setShowTickMarks(true);
        slide.setMajorTickUnit(5);
        slide.setMinorTickCount(1);
        slide.setBlockIncrement(1);
        slide.setValue(prefs.getDrawWidth());
        slide.valueProperty().addListener((observableValue, number, t1) -> wideAct((double) t1));
        return slide;
    }

    private void wideAct(double newW)
    {
        prefs.setDrawWidth(newW);
        size.setText("Size = " + newW);
    }

}
