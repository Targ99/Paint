package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

//import java.;

public class drawFree{

    private allPrefs prefs;

    private drawFree(allPrefs pref)
    {
        prefs = pref;
    }


    public void pressed(MouseEvent e)
    {
        if (dragging)  // Ignore mouse presses that occur
            return;            //    when user is already drawing a curve.


        int x = (int)e.getX();   // x-coordinate where the user clicked.
        int y = (int)e.getY();   // y-coordinate where the user clicked.

        int width = (int)drawBrd.getWidth();    // Width of the canvas.
        int height = (int)drawBrd.getHeight();  // Height of the canvas.


        if (x > 0 && x < width && y > 0 && y < height) {
            // The user has clicked on the white drawing area.
            // Start drawing a curve from the point (x,y).
            prevX = x;
            prevY = y;
            dragging = true;
            gc.setLineWidth(drawWidth);
            gc.setStroke(drawColor);
        }
    }

    public void dragged(MouseEvent evt) {

        if (!dragging)
        {
            return;  // Nothing to do because the user isn't drawing.
        }
        double x = evt.getX();   // x-coordinate of mouse.
        double y = evt.getY();   // y-coordinate of mouse.
        if (x < 0)                          // Adjust the value of x,
            x = 0;                           //   to make sure it's in
        if (x > drawBrd.getWidth())       //   the drawing area.
            x = (int)drawBrd.getWidth();
        if (y < 0)                          // Adjust the value of y,
            y = 0;                           //   to make sure it's in
        if (y > drawBrd.getHeight())       //   the drawing area.
            y = drawBrd.getHeight();
        gc.strokeLine(prevX, prevY, x, y);  // Draw the line.
        prevX = x;  // Get ready for the next line segment in the curve.
        prevY = y;
    }

}
