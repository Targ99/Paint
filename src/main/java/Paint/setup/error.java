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

public class error{

    private String errors;
    private Stage stage;

    public error (String errors, Stage stage)
    {
        this.errors = errors;
        this.stage = stage;
    }



    public void errorwindow() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("Error");
        VBox box = new VBox();
        Text title = new Text("Wrong File Format");
        box.getChildren().add(title);
        Label errorLabel = new Label(errors);
        box.getChildren().add(errorLabel);
        Button exitButton = new Button("OK");
        exitButton.setOnAction(event -> dialog.close());
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.getButtons().add(exitButton);
        box.getChildren().add(buttonBar);

        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.show();
    }

}

