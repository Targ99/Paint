package Paint.setup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class prefWin{

    private int colorchosen = 0;
    private Slider slider;
    private ColorPicker colorpick, strokepick;
    private Label colorLabel, strokeLabel;
    private int strokechosen = 0;
    private prefBuild prefB;

    private allPrefs prefs;

    public prefWin(allPrefs pref)
    {
        prefs = pref;
    }


    public void displayPrefWin()
    {
        prefB = new prefBuild();
        Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(mainStage);
        dialog.setTitle("Draw Preferences");
        Text title = new Text("Draw Type");
        Text space = new Text(" ");
        Text space2 = new Text(" ");
        slider = prefB.buildSlider();
        ToggleGroup drawChoice = new ToggleGroup();
        VBox drawBox = prefB.buildtoggle(drawChoice);
        colorpick = new ColorPicker();
        strokepick = new ColorPicker();
        colorLabel = new Label(prefB.colorString(drawColor));
        strokeLabel = new Label(prefB.colorString(strokeColor));
        strokepick.setOnAction(event -> strokeAct());
        colorpick.setOnAction(event-> colorAct());
        space.setTextAlignment(TextAlignment.CENTER);
        space2.setTextAlignment(TextAlignment.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        javafx.scene.control.Button exitButton = new Button("OK");
        Button apply = new Button("Apply");
        apply.setOnAction(event-> applyChanges());
        exitButton.setOnAction(event -> dialog.close());
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setPrefWidth(100);
        VBox box = new VBox();
        box.getChildren().addAll(title, drawBox, slider, colorpick, colorLabel, space,strokepick, strokeLabel, apply, exitButton);
        box.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.setHeight(500);
        dialog.setWidth(500);
        dialog.show();
    }

    private void strokeAct()
    {
        strokeLabel.setText(prefB.colorString(strokepick.getValue()));
        strokechosen = 1;
    }

    private void colorAct()
    {
        colorLabel.setText(prefB.colorString(colorpick.getValue()));
        colorchosen = 1;
    }

    public void applyChanges()
    {
        drawWidth = slider.valueProperty().doubleValue();
        if(colorchosen==1) {
            colorchosen = 0;
            drawColor = (colorpick.getValue());
            System.out.println(drawColor + "is the color selected");
        }
        if(strokechosen==1) {
            strokechosen = 0;
            strokeColor = colorpick.getValue();
            System.out.println(strokeColor + "is the color selected");
        }
        topBar.refreshCol();
        drawBrd.setHeight(canvH);
        drawBrd.setWidth(canvW);

    }
}
