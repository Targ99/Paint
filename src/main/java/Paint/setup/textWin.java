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
    private drawNums nums;
    private GraphicsContext gc;
    private Stage dialog;
    private TextField text;
    private double x,y;

    public textWin(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
        gc = prefs.getCurrCanv().getGraphicsContext2D();
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
        exitButton.setOnAction(event -> putText());
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setPrefWidth(100);
        box.getChildren().addAll(text, space, exitButton);
        x = nums.getPrevX();
        y = nums.getPrevY();
        Scene defaultsc = new Scene(box);
        dialog.setScene(defaultsc);
        dialog.show();
    }

    private void putText()
    {
        String input = text.getText();
        System.out.println(input + nums.getPrevX() + nums.getPrevY());
        gc.setLineWidth(prefs.getDrawWidth());
        gc.setStroke(prefs.getDrawColor());
        gc.setFill(prefs.getDrawColor());
        gc.fillText(input, x,y);
        dialog.close();
    }

}
