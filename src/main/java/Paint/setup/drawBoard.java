package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.File;

public class drawBoard {

    private allPrefs prefs;
    private ChooseDraw draw;

    public drawBoard(allPrefs pref)
    {
        prefs = pref;
        draw = new ChooseDraw(prefs);
    }

    public Canvas build(double canvW, double canvH)
    {
        Canvas drawBrd = new Canvas(canvW, canvH);
        GraphicsContext gc = drawBrd.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0,0,canvW, canvH);
        prefs.setCurrCanv(drawBrd);
        drawBrd.setOnMousePressed(event -> draw.pressed(event));
        drawBrd.setOnMouseDragged(event -> draw.dragged(event));
        drawBrd.setOnMouseReleased(event -> draw.released(event));
        return drawBrd;
    }
}

/*
nums.isDragging()
nums.getPrevY()
nums.getPrevX()
nums.getFinY()
nums.getFinX()
nums.setDragging(
nums.setFinX(
nums.setFinY(
nums.setPrevX(
nums.setPrevY(
C:\Users\garre\Desktop\CS250\Paint\src\main\resources\Icons\icons8-circle-50.png
 */
