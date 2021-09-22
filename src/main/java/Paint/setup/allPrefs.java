package Paint.setup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class allPrefs {

    private double drawWidth = 10;
    private double drawHeight = 10;
    private javafx.scene.paint.Color drawColor = Color.BLACK;
    private String drawType = "Straight Line";
    private File currentFile = null;
    private Slider slider;
    private ChoiceBox<String> drawtype;
    private ColorPicker colorpick;
    private int colorchosen = 0;

    public void displayPrefWin(Stage stage)
    {
        Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(stage);
        dialog.setTitle("Draw Preferences");
        Text title = new Text("Draw Type");
        Text message = new Text("IDK what to put here yet...");
        Text space = new Text(" ");
        Text space2 = new Text(" ");
        slider = new Slider();
        slider.setMin(0);
        slider.setMax(20);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(5);
        slider.setMinorTickCount(1);
        slider.setBlockIncrement(1);
        slider.setValue(drawWidth);
        slider.valueProperty().addListener((observableValue, number, t1) -> drawWidth = t1.doubleValue());
        drawtype = new ChoiceBox<String>();
        drawtype.setValue(drawType);
        drawtype.getItems().addAll("Straight Line", "Freeform Line");
        colorpick = new ColorPicker();
        colorpick.setOnAction(event-> colorchosen = 1);
        space.setTextAlignment(TextAlignment.CENTER);
        space2.setTextAlignment(TextAlignment.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        message.setTextAlignment(TextAlignment.CENTER);
        javafx.scene.control.Button exitButton = new Button("OK");
        Button apply = new Button("Apply");
        apply.setOnAction(event-> applyChanges());
        exitButton.setOnAction(event -> dialog.close());
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setPrefWidth(100);
        VBox box = new VBox();
        box.getChildren().addAll(title,drawtype, slider,colorpick, space,apply, exitButton);
        box.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.setHeight(300);
        dialog.setWidth(300);
        dialog.show();
    }

    public void applyChanges()
    {
        drawWidth = slider.valueProperty().doubleValue();
        drawType = drawtype.getValue();
        if(colorchosen==1) {
            colorchosen = 0;
            drawColor = colorpick.getValue();
            System.out.println(drawColor + "is the color selected");
        }

    }

    public File getCurrentFile()
    {
        return currentFile;
    }
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public double getDrawHeight() {
        return drawHeight;
    }

    public void setDrawWidth(double drawWidth) {
        this.drawWidth = drawWidth;
    }

    public void setDrawHeight(double drawHeight) {
        this.drawHeight = drawHeight;
    }

    public javafx.scene.paint.Color getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(javafx.scene.paint.Color drawColor) {
        this.drawColor = drawColor;
    }

    public double getDrawWidth() {
        return drawWidth;
    }


    public void setDrawType(String drawType) {
        this.drawType = drawType;
    }

    public String getDrawType() {
        return drawType;
    }


}
