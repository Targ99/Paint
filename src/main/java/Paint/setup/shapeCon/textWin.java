package Paint.setup.shapeCon;

import Paint.setup.allPrefs;
import Paint.setup.drawNums;
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
    private drawNums nums;
    private GraphicsContext gc;
    private Stage dialog;
    private TextField text;
    private double x,y;

    public textWin(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
    }

    public void displayWin()
    {
        dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(prefs.getWindow());
        dialog.setTitle("Enter Desired Text");
        Text space = new Text(" ");
        text = new TextField("Text:");
        VBox box = new VBox(5);
        Button exitButton = new Button("OK");
        x = nums.getPrevX();
        y = nums.getPrevY();
        exitButton.setOnAction(event -> putText(x, y));
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setPrefWidth(100);
        box.getChildren().addAll(text, space, exitButton);
        Scene defaultsc = new Scene(box);
        dialog.setScene(defaultsc);
        dialog.show();
    }

    private void putText(double x, double y)
    {
        String input = text.getText();
        Text t = new Text(input);
        t.setX(x);
        t.setY(y);
        t.setFill(prefs.getStrokeColor());
        t.setStrokeWidth(prefs.getDrawWidth());
        prefs.getCurrPane().getChildren().add(t);
        prefs.getDrawPane().addStep(t);
        System.out.println(input + nums.getPrevX() + nums.getPrevY());
        dialog.close();
    }

}
