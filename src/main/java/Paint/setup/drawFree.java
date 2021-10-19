package Paint.setup;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class drawFree{

    private allPrefs prefs;
    private drawNums nums;

    public drawFree(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
    }


    public void pressed(MouseEvent event)
    {
        if (nums.isDragging())  // Ignore mouse presses that occur
            return;            //    when user is already drawing a curve.
        int x = (int)event.getX();   // x-coordinate where the user clicked.
        int y = (int)event.getY();   // y-coordinate where the user clicked.
        int width = (int)prefs.getCanvW();    // Width of the canvas.
        int height = (int)prefs.getCanvH();  // Height of the canvas.

        if (x > 0 && x < width && y > 0 && y < height) {
            // The user has clicked on the white drawing area.
            // Start drawing a curve from the point (x,y).
            nums.setPrevX(x);
            nums.setPrevY(y);
            nums.setDragging(true);
            Path tPath = new Path();
            tPath.getElements().add(new MoveTo(x,y));
            nums.setPat(tPath);
            nums.getPat().setStrokeWidth(prefs.getDrawWidth());
            switch (prefs.getDrawType())
            {
                case 2:
                    nums.getPat().setStroke(prefs.getStrokeColor());
                    break;
                default:
                    nums.getPat().setStroke(Color.web("0xe3e3e3"));
            }
            prefs.getCurrPane().getChildren().add(tPath);
            prefs.getDrawPane().addStep(tPath);
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
        if (x > prefs.getCanvW())       //   the drawing area.
            x = (int)prefs.getCanvW();
        if (y < 0)                          // Adjust the value of y,
            y = 0;                           //   to make sure it's in
        if (y > prefs.getCanvH())       //   the drawing area.
            y = prefs.getCanvH();
        nums.getPat().getElements().add(new LineTo(x,y));
    }

}
