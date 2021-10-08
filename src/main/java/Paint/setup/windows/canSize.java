package Paint.setup.windows;

import Paint.setup.allPrefs;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class canSize {

    private allPrefs prefs;
    private Stage dialog;

    public canSize(allPrefs pref)
    {
        prefs = pref;
    }

    public void build()
    {
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(prefs.getWindow());
        dialog.setTitle("Resize Canvas");
        VBox box = new VBox(10);
        HBox top = new HBox(10);
        HBox bot = new HBox(10);
        Slider wField = buildSlider(prefs.getCanvW());
        Slider hField = buildSlider(prefs.getCanvH());
        Text height = new Text("Height");
        Text width = new Text("Width:");
        top.getChildren().addAll(width, wField);
        bot.getChildren().addAll(height, hField);
        Button exitButton = new Button("OK");
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setOnAction(event -> update(wField.getValue(), hField.getValue()));
        box.getChildren().addAll(top, bot, exitButton);
        box.setAlignment(Pos.CENTER);
        top.setAlignment(Pos.CENTER);
        bot.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.setHeight(300);
        dialog.setWidth(300);
        dialog.show();
    }

    private void update(double w, double h)
    {
        prefs.setCanvW(w);
        prefs.setCanvH(h);
        prefs.getCurrTab().setCanvW(w);
        prefs.getCurrTab().setCanvH(h);
        dialog.close();
    }

    private Slider buildSlider(double value)
    {
        Slider slide = new Slider();
        slide.setMin(100);
        slide.setMax(2000);
        slide.setShowTickLabels(true);
        slide.setShowTickMarks(true);
        slide.setMajorTickUnit(200);
        slide.setMinorTickCount(100);
        slide.setValue(value);
        return slide;
    }

}
