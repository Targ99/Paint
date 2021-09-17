package Paint.setup;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LineWidth {

    private Stage stage;
    private double lineW;

    public LineWidth (Stage stage)//default constructor
    {
        this.stage = stage;
    }

    public double getLineW() {
        displayLineW();
        return lineW;
    }

    public void displayLineW()
    {

        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("Choose Line Width");
        Text title = new Text("Line Width");
        TextField choice = new TextField("Line Width");
        choice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    choice.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Button exitButton = new Button("OK");
        exitButton.setOnAction(event ->
        {
            String str = choice.getText();
            lineW = Double.parseDouble(str);
            dialog.close();
            return;
        });
        VBox box = new VBox();
        box.getChildren().addAll(title, choice, exitButton);
        Scene dialogScene = new Scene(box);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
