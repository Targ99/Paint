package Paint.setup;

import static java.util.stream.Collectors.joining;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class helpPage{

    private Stage stage;

    public helpPage (Stage stage)//default constructor
    {
        this.stage = stage;
    }

    public void displayHelp()
    {
        Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(stage);
        dialog.setTitle("Help");
        Text title = new Text("Help Page");
        Button exitButton = new Button("OK");
        exitButton.setOnAction(event -> dialog.close());
        VBox box = new VBox();
        box.getChildren().addAll(title, exitButton);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.show();
    }

}