package Paint.setup;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class view<privtae>
{
    private allPrefs prefs;
    private Stage window;

    public view(Stage windo)
    {
        prefs = new allPrefs(windo);
        window = windo;
        window.setTitle("GS Paint");
        Scene dscene = prefs.build();
        window.setScene(dscene); //Activates the default scene
        window.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
        window.show(); //Constructs the stage
    }

    private void closeWindowEvent(WindowEvent event)
    {
        System.out.println("Window close request ...");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getButtonTypes().remove(ButtonType.OK);
        alert.getButtonTypes().add(ButtonType.CANCEL);
        alert.getButtonTypes().add(ButtonType.YES);
        alert.setTitle("Quit application");
        alert.setContentText(String.format("Close without saving?"));
        alert.initOwner(window.getOwner());
        Optional<ButtonType> res = alert.showAndWait();
        if(res.isPresent()) {
            if(res.get().equals(ButtonType.CANCEL))
                event.consume();
        }
    }

}
