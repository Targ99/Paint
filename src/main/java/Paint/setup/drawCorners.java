package Paint.setup;

import Paint.setup.shapeCon.*;
import javafx.scene.input.MouseEvent;

public class drawCorners{

    private allPrefs prefs;
    private drawNums nums;

    public drawCorners(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
    }

    public void pressed(MouseEvent event)
    {
        if (nums.isDragging())
        {
            return;             //    when user is already drawing a curve.
        }                       // Ignore mouse presses that occur


        int x = (int)event.getX();   // x-coordinate where the user clicked.
        int y = (int)event.getY();   // y-coordinate where the user clicked.
        nums.setPrevX(x);
        nums.setPrevY(y);
        int width = (int)prefs.getCanvW();    // Width of the canvas.
        int height = (int)prefs.getCanvH();  // Height of the canvas.


        if (x > 0 && x < width && y > 0 && y < height) {
            switch (prefs.getDrawType())
            {
                case 11,7:
                    new circCon(prefs, nums).press(event);
                    break;
                case 16:
                    new moveCon(prefs, nums).press(event);
                    break;
                case 13:
                    new polyCon(prefs, nums).press(event);
                    break;
                case 14:
                    new starCon(prefs, nums).press(event);
                    break;
                case 8,12:
                    new elliCon(prefs, nums).press(event);
                    break;
                case 5,6,9,10:
                    new rectCon(prefs, nums).press(event);
                    break;
                default:
                    new lineCon(prefs, nums).press(event);
                    break;
            }
            nums.setDragging(true);
        }
    }

    public void dragged(MouseEvent event)
    {
        nums.setWasD(true);
        if (!nums.isDragging())
        {
            return;  // Nothing to do because the user isn't drawing.
        }

        double x = event.getX();   // x-coordinate of mouse.
        double y = event.getY();   // y-coordinate of mouse.
        if (x < 1)                          // Adjust the value of x,
            x = 1;                           //   to make sure it's in
        if (x > prefs.getCanvW())       //   the drawing area.
            x = (int)prefs.getCanvW();

        if (y < 1)                          // Adjust the value of y,
            y = 1;                           //   to make sure it's in
        if (y > prefs.getCanvH())       //   the drawing area.
            y = prefs.getCanvH();
        System.out.println(prefs.isFilled());
        nums.setFinX(x);
        nums.setFinY(y);
        switch (prefs.getDrawType())
        {

            case 11,7:
                new circCon(prefs, nums).drag(event);
                break;
            case 16:
                new moveCon(prefs, nums).drag(event);
                break;
            case 8,12:
                new elliCon(prefs, nums).drag(event);
                break;
            case 13:
                new polyCon(prefs, nums).drag(event);
                break;
            case 14:
                new starCon(prefs, nums).drag(event);
                break;
            case 5,6,9,10:
                new rectCon(prefs, nums).drag(event);
                break;
            default:
                new lineCon(prefs, nums).drag(event);
                break;
        }
        System.out.println("drag");
    }

    public void released(MouseEvent event)
    {
        switch (prefs.getDrawType())
        {
            case 11,7:
                nums.setCircle(null);
                break;
            case 16:
                new moveCon(prefs, nums).press(event);
                break;
            case 13, 14:
                nums.setPoly(null);
                break;
            case 8,12:
                nums.setElli(null);
                break;
            case 5,6,9,10:
                nums.setRect(null);
                break;
            default:
                nums.setSingL(null);
                break;
        }
        nums.setDragging(false);
        nums.setWasD(false);
    }

}

/*
if(nums.isPlaced()) {
                    placeImg place = new placeImg(prefs, nums);
                    place.getImg(nums.getPrevX(), nums.getPrevY(), nums.getFinX(), nums.getFinY());
                    System.out.println(nums.getPrevX() + "      " + nums.getPrevY() + nums.getFinX() + "      " + nums.getFinY());
                }
                else
                {
                    placeImg place = new placeImg(prefs, nums);
                    place.putImg();
                }
 */
