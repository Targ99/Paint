package Paint.setup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Good for now//

public class error{

    private String errors;

    public error(String errors, Stage stage)
    {
        this.errors = errors;
    }

    public void errorwindow(allPrefs prefs)
    {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(prefs.getWindow());
        dialog.setTitle("Error");
        VBox box = new VBox();
        Text title = new Text("File Format Not Supported");
        Text errorLabel = new Text(errors);
        Text space1 = new Text(" ");
        Text space2 = new Text(" ");
        title.setTextAlignment(TextAlignment.CENTER);
        errorLabel.setTextAlignment(TextAlignment.CENTER);
        Button exitButton = new Button("OK");
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setOnAction(event -> dialog.close());
        box.getChildren().addAll(title,space1, errorLabel,space2, exitButton);
        box.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.setHeight(150);
        dialog.setWidth(300);
        dialog.show();
    }
}

