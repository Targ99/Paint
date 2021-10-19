package Paint.setup;

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

    /**
     * warning message to save on close
     * @param event
     */

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

    /**
     * returns a scene with a toolbar,
     * preference bar, and tab view
     * @return
     */
    public Scene build()
    {
        HBox top = new HBox(new MenuPart(prefs).build());
        tabCont = new TabBar(prefs).buildTabs();
        Slider zoom = buildSlider(prefs.getDrawPane().getScale()*100);
        top.getChildren().add(zoom);
        prefs.setTabCont(tabCont);
        VBox drawPrefs = new VBox(new prefMenu(prefs).build());
        HBox bot = new HBox(5, tabCont, drawPrefs);
        VBox inScene = new VBox(top, bot);
        Scene scene = new Scene(inScene);
        System.out.println("drag view");
        return scene;

    }

    /**
     * sets the scale of the current tab for zoom
     * @param diff zoom input from a slider
     */

    public void zoom(double diff)
    {
        prefs.getCurrPane().setScaleX(diff / 100);
        prefs.getCurrPane().setScaleY(diff / 100);
        prefs.getCurrTab().getScrollPane().setFitToHeight(true);
        prefs.getCurrTab().getScrollPane().setFitToWidth(true);
    }

    public Slider buildSlider(double value)
    {
        Slider slide = new Slider();
        slide.setMin(50);
        slide.setMax(400);
        slide.setShowTickLabels(true);
        slide.setShowTickMarks(true);
        slide.setMajorTickUnit(50);
        slide.setMinorTickCount(25);
        slide.setValue(value);
        slide.valueProperty().addListener((observableValue, number, t1) -> zoom((double) t1));
        return slide;
    }

}
