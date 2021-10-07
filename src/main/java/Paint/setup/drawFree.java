package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

//import java.;

public class drawFree{

    private allPrefs prefs;
    private drawNums nums;
    private GraphicsContext gc;

    public drawFree(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
        gc = prefs.getCurrCanv().getGraphicsContext2D();
    }


    public void pressed(MouseEvent e)
    {
        if (nums.isDragging())  // Ignore mouse presses that occur
            return;            //    when user is already drawing a curve.


        int x = (int)e.getX();   // x-coordinate where the user clicked.
        int y = (int)e.getY();   // y-coordinate where the user clicked.

        int width = (int)prefs.getCurrCanv().getWidth();    // Width of the canvas.
        int height = (int)prefs.getCurrCanv().getHeight();  // Height of the canvas.


        if (x > 0 && x < width && y > 0 && y < height) {
            // The user has clicked on the white drawing area.
            // Start drawing a curve from the point (x,y).
            nums.setPrevX(x);
            nums.setPrevY(y);
            nums.setDragging(true);
            switch (prefs.getDrawType())
            {
                case 1:
                    gc.setLineWidth(prefs.getDrawWidth());
                    gc.setStroke(prefs.getDrawColor());
                    break;
                default:
                    gc.setLineWidth(prefs.getDrawWidth());
                    gc.setStroke(Color.LIGHTGRAY);
            }

        }
    }

    public void dragged(MouseEvent evt) {

        if (!nums.isDragging())
        {
            return;  // Nothing to do because the user isn't drawing.
        }
        double x = evt.getX();   // x-coordinate of mouse.
        double y = evt.getY();   // y-coordinate of mouse.
        if (x < 0)                          // Adjust the value of x,
            x = 0;                           //   to make sure it's in
        if (x > prefs.getCurrCanv().getWidth())       //   the drawing area.
            x = (int)prefs.getCurrCanv().getWidth();
        if (y < 0)                          // Adjust the value of y,
            y = 0;                           //   to make sure it's in
        if (y > prefs.getCurrCanv().getHeight())       //   the drawing area.
            y = prefs.getCurrCanv().getHeight();
        gc.strokeLine(nums.getPrevX(), nums.getPrevY(), x, y);  // Draw the line.
        nums.setPrevX(x);  // Get ready for the next line segment in the curve.
        nums.setPrevY(y);
    }

}
