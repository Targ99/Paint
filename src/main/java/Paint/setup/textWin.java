package Paint.setup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class textWin
{

    private allPrefs prefs;

    private textWin(allPrefs pref)
    {
        prefs = pref;
    }

    private Stage stage;
    private Stage dialog;
    private double x, y, width;
    private TextField text;



    public void displayWin()
    {
        dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(stage);
        dialog.setTitle("Enter Desired Text");
        Text space = new Text(" ");
        text = new TextField("Text:");
        VBox box = new VBox(5);
        Button exitButton = new Button("OK");
        exitButton.setOnAction(event -> putText());
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setPrefWidth(100);
        box.getChildren().addAll(text, space, exitButton);
        Scene defaultsc = new Scene(box);
        dialog.setScene(defaultsc);
        dialog.show();
    }

    private void putText()
    {
        String input = text.getText();
        dialog.close();
        gc.setLineWidth(drawWidth);
        gc.setStroke(drawColor);
        gc.setFill(drawColor);
        gc.fillText(input, x, y, width);
    }

}
