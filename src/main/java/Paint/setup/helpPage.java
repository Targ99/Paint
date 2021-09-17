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
        Text message = new Text("IDK what to put here yet...");
        Text space = new Text(" ");
        Text space2 = new Text(" ");
        space.setTextAlignment(TextAlignment.CENTER);
        space2.setTextAlignment(TextAlignment.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        message.setTextAlignment(TextAlignment.CENTER);
        Button exitButton = new Button("OK");
        exitButton.setOnAction(event -> dialog.close());
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setPrefWidth(100);
        VBox box = new VBox();
        box.getChildren().addAll(title,space, message, space2, exitButton);
        box.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.setHeight(300);
        dialog.setWidth(300);
        dialog.show();
    }

}