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

public class aboutPage extends allPrefs{


    public void displayAbout()
    {
        //creating new stage and setting params
        Stage dialog = new Stage();
        dialog.initModality(Modality.NONE);
        dialog.initOwner(mainStage);
        dialog.setTitle("About Paint");
        //creating text items for information
        Text title1 = new Text("JavaFX Paint Implementation");
        Text title2 = new Text("Version: 0.002");
        Text title3 = new Text("Creator: Garrett Scheiber");
        Text title4 = new Text("Version Date: Sep. 17, 2021");
        Text space = new Text(" ");
        Text space2 = new Text(" ");
        Text space3 = new Text(" ");
        Text space4 = new Text(" ");
        //exit button and event handling
        Button exitButton = new Button("OK");
        exitButton.setPrefWidth(100);
        exitButton.setOnAction(event -> dialog.close());
        //alignment formatting
        title1.setTextAlignment(TextAlignment.CENTER);
        title2.setTextAlignment(TextAlignment.CENTER);
        title3.setTextAlignment(TextAlignment.CENTER);
        title4.setTextAlignment(TextAlignment.CENTER);
        exitButton.setAlignment(Pos.CENTER);
        //creating and populating containers, then displaying window
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(title1,space,title3, space2, title2,space3, title4,space4, exitButton);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.setHeight(300);
        dialog.setWidth(300);
        dialog.show();
    }
}
