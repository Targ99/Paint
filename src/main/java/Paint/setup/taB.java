package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class taB{

//    protected GraphicsContext gc = drawBrd.getGraphicsContext2D();
    private allPrefs prefs;
    private double canvH = 500;
    private double canvW = 700;
    private Canvas drawBrd;
    private File saveSpace = null;



    public taB(allPrefs pref){prefs = pref;}

    public ScrollPane build()
    {
        StackPane picdisplay = new StackPane();
        ScrollPane scrollPane = new ScrollPane(picdisplay);
        scrollPane.setMaxSize(canvW, canvH);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        drawBrd = new drawBoard(prefs).build(canvW, canvH);
        picdisplay.getChildren().add(drawBrd);
        return scrollPane;
    }

    public void changeCanv(double width, double height)
    {
        drawBrd.setWidth(width);
        drawBrd.setHeight(height);
        this.canvH = height;
        this.canvW = width;
    }


}
