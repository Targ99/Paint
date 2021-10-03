package Paint.setup;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class prefBuild{

    private final RadioButton rb1 = new RadioButton("Straight Line");
    private final RadioButton rb2 = new RadioButton("Freehand");
    private final RadioButton rb3 = new RadioButton("Text");
    private final RadioButton rb4 = new RadioButton("Color Grabber");
    private final RadioButton rb5 = new RadioButton("Square");
    private final RadioButton rb6 = new RadioButton("Rectangle");
    private final RadioButton rb7 = new RadioButton("Circle");
    private final RadioButton rb8 = new RadioButton("Ellipse");
    private final RadioButton current = rb1;
    private allPrefs prefs;

    private prefBuild(allPrefs pref)
    {
        prefs = pref;
    }


    public Slider buildSlider()
    {
        Slider slide = new Slider();
        slide.setMin(0);
        slide.setMax(20);
        slide.setShowTickLabels(true);
        slide.setShowTickMarks(true);
        slide.setMajorTickUnit(5);
        slide.setMinorTickCount(1);
        slide.setBlockIncrement(1);
        slide.setValue(prefs.getDrawWidth());
        slide.valueProperty().addListener((observableValue, number, t1) -> prefs.setDrawWidth((double)t1) );
        return slide;
    }

    private void getType(ToggleGroup group)
    {
        ToggleButton button = (ToggleButton) group.getSelectedToggle();
        String toogleGroupValue = button.getText();

        switch (toogleGroupValue)
        {
            case "Straight Line":
                prefs.setDrawType(0);
                break;
            case "Freehand":
                prefs.setDrawType(1);
                break;
            case "Text":
                prefs.setDrawType(2);
                break;
            case "Color Grabber":
                prefs.setDrawType(3);
                break;
            case "Square":
                prefs.setDrawType(4);
                break;
            case "Rectangle":
                prefs.setDrawType(5);
                break;
            case "Circle":
                prefs.setDrawType(6);
                break;
            case "Ellipse":
                prefs.setDrawType(7);
                break;
            default:
                prefs.setDrawType(0);
                break;
        }
    }

    public VBox buildtoggle(ToggleGroup group)
    {
        final VBox tgroup = new VBox(5);

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);
        rb5.setToggleGroup(group);
        rb6.setToggleGroup(group);
        rb7.setToggleGroup(group);
        rb8.setToggleGroup(group);
        current.setSelected(true);
        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                getType(group);
            }
        });
        tgroup.getChildren().addAll(rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8);
        return tgroup;
    }

    public String colorString(Color color)
    {
        String red = "R:" + color.getRed();
        String green = "G:" + color.getGreen();
        String blue = "B:" + color.getBlue();
        return red + "\n" + green + "\n" + blue;
    }
}
