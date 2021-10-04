package Paint.setup;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class view
{
    private final allPrefs prefs;
    private Stage window;
    private TabPane tabCont;

    public view(Stage windo)
    {
        window = windo;
        prefs = new allPrefs(windo);
        window.setTitle("GS Paint");
        Scene dscene = build();
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

    public Scene build()
    {
        HBox top = new HBox(new MenuPart(prefs).build());
        tabCont = new TabBar(prefs).buildTabs();

        prefs.setTabCont(tabCont);
        VBox drawPrefs = new VBox(new prefMenu(prefs).build());
        HBox bot = new HBox(5, tabCont, drawPrefs);
        VBox inScene = new VBox(top, bot);
        Scene scene = new Scene(inScene);
        return scene;
    }

}
