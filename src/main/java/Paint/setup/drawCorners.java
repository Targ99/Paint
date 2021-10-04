package Paint.setup;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class drawCorners{

    private allPrefs prefs;
    private drawNums nums;
    private GraphicsContext gc;

    public drawCorners(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
        gc = prefs.getCurrCanv().getGraphicsContext2D();
    }

    public void pressed(MouseEvent event)
    {
        if (nums.isDragging())
        {
            return;             //    when user is already drawing a curve.
        }                       // Ignore mouse presses that occur


        int x = (int)event.getX();   // x-coordinate where the user clicked.
        int y = (int)event.getY();   // y-coordinate where the user clicked.

        int width = (int)prefs.getCurrCanv().getWidth();    // Width of the canvas.
        int height = (int)prefs.getCurrCanv().getHeight();  // Height of the canvas.


        if (x > 0 && x < width && y > 0 && y < height) {
            // The user has clicked on the white drawing area.
            // Start drawing a curve from the point (x,y).
            nums.setPrevX(x);
            nums.setPrevY(y);
            nums.setDragging(true);
            gc.setLineWidth(prefs.getDrawWidth());  // Use a 2-pixel-wide line for drawing.
            gc.setStroke(prefs.getStrokeColor());
        }
    }

    public void dragged(MouseEvent event) {
        nums.setWasD(true);
        if (!nums.isDragging())
        {
            return;  // Nothing to do because the user isn't drawing.
        }

        double x = event.getX();   // x-coordinate of mouse.
        double y = event.getY();   // y-coordinate of mouse.
        if (x < 1)                          // Adjust the value of x,
            x = 1;                           //   to make sure it's in
        if (x > prefs.getCurrCanv().getWidth())       //   the drawing area.
            x = (int)prefs.getCurrCanv().getWidth();

        if (y < 1)                          // Adjust the value of y,
            y = 1;                           //   to make sure it's in
        if (y > prefs.getCurrCanv().getHeight())       //   the drawing area.
            y = prefs.getCurrCanv().getHeight();

        nums.setFinX(x);
        nums.setFinY(y);

    }

    public void released(MouseEvent event)
    {
        gc.setFill(prefs.getDrawColor());
        gc.setStroke(prefs.getStrokeColor());
        gc.setLineWidth(prefs.getDrawWidth());
        double num;
        double num2;
        switch (prefs.getDrawType())
        {
            case 4:
                num = Math.min(nums.getFinX()-nums.getPrevX(), nums.getFinY()-nums.getPrevY());
                gc.strokeRect(nums.getPrevX(),nums.getPrevY(),num,num);
                break;
            case 5:
                num = nums.getFinX() - nums.getPrevX();
                num2 = nums.getFinY() - nums.getPrevY();
                gc.strokeRect(nums.getPrevX(),nums.getPrevY(),num, num2);
                break;
            case 6:
                num = Math.min(nums.getFinX()-nums.getPrevX(), nums.getFinY()-nums.getPrevY());
                gc.strokeOval(nums.getPrevX(),nums.getPrevY(),num,num);
                break;
            case 7:
                num = nums.getFinX() - nums.getPrevX();
                num2 = nums.getFinY() - nums.getPrevY();
                gc.strokeOval(nums.getPrevX(),nums.getPrevY(),num,num2);
                break;
            default:
                if(!nums.isWasD())
                {
                    gc.strokeLine(nums.getPrevX(),nums.getPrevY(),nums.getPrevX(),nums.getPrevY());
                    System.out.println(nums.getPrevX() + "      " + nums.getPrevY() + nums.getFinX() + "      " + nums.getFinY());
                }
                else
                {
                    System.out.println(nums.getPrevX() + "      " + nums.getPrevY());
                    gc.strokeLine(nums.getPrevX(),nums.getPrevY(),nums.getFinX(),nums.getFinY());
                }
                break;
        }
        nums.setDragging(false);
        nums.setWasD(false);
    }

}
