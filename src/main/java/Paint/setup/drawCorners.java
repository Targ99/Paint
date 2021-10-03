package Paint.setup;

import javafx.scene.input.MouseEvent;

public class drawCorners{

    private allPrefs prefs;

    private drawCorners(allPrefs pref)
    {
        prefs = pref;
    }



    public void pressed(MouseEvent event)
    {
        if (dragging)  // Ignore mouse presses that occur
            return;            //    when user is already drawing a curve.


        int x = (int)event.getX();   // x-coordinate where the user clicked.
        int y = (int)event.getY();   // y-coordinate where the user clicked.

        int width = (int)drawBrd.getWidth();    // Width of the canvas.
        int height = (int)drawBrd.getHeight();  // Height of the canvas.


        if (x > 3 && x < width - 3 && y > 3 && y < height - 3) {
            // The user has clicked on the white drawing area.
            // Start drawing a curve from the point (x,y).
            prevX = x;
            prevY = y;
            dragging=true;
            gc.setLineWidth(drawWidth);  // Use a 2-pixel-wide line for drawing.
            gc.setStroke(drawColor);
        }
    }

    public void dragged(MouseEvent event) {

        if (!dragging)
        {
            return;  // Nothing to do because the user isn't drawing.
        }

        double x = event.getX();   // x-coordinate of mouse.
        double y = event.getY();   // y-coordinate of mouse.
        if (x < 0)                          // Adjust the value of x,
            x = 0;                           //   to make sure it's in
        if (x > drawBrd.getWidth())       //   the drawing area.
            x = (int)drawBrd.getWidth();

        if (y < 0)                          // Adjust the value of y,
            y = 0;                           //   to make sure it's in
        if (y > drawBrd.getHeight())       //   the drawing area.
            y = drawBrd.getHeight();

        finX = x;
        finY = y;

    }

    public void released(MouseEvent event)
    {
        gc.setFill(drawColor);
        gc.setStroke(strokeColor);
        gc.setLineWidth(drawWidth);
        double num;
        double num2;
        switch (drawType)
        {
            case 4:
                num = Math.min(finX-prevX, finY-prevY);
                gc.strokeRect(prevX,prevY,num,num);
                break;
            case 5:
                num = finX - prevX;
                num2 = finY - prevY;
                gc.strokeRect(prevX,prevY,num, num2);
                break;
            case 6:
                num = Math.min(finX-prevX, finY-prevY);
                gc.strokeOval(prevX,prevY,num,num);
                break;
            case 7:
                num = finX - prevX;
                num2 = finY - prevY;
                gc.strokeOval(prevX,prevY,num,num2);
                break;
            default:
                gc.strokeLine(prevX,prevY,finX,finY);
                break;
        }
        dragging = false;
    }

}
