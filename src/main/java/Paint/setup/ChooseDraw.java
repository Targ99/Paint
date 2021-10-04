package Paint.setup;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class ChooseDraw
{
    private allPrefs prefs;
    private drawNums nums = new drawNums();

    public ChooseDraw(allPrefs pref) {prefs = pref;}


    void pressed(MouseEvent event)
    {
        switch (prefs.getDrawType()) {
            case 1, 14:
                new drawFree(prefs, nums).pressed(event);
                break;
            case 2, 3:
                new drawPixel(prefs, nums).pressed(event);
                break;
            default:
                new drawCorners(prefs, nums).pressed(event);
                break;
        }
    }
    void dragged(MouseEvent event)
    {
        switch (prefs.getDrawType()) {
            case 1, 14:
                new drawFree(prefs, nums).dragged(event);
                break;
            case 2, 3:
                new drawPixel(prefs, nums).dragged(event);
                break;
            default:
                new drawCorners(prefs, nums).dragged(event);
                break;
        }
    }
    void released(MouseEvent event)
    {
        switch (prefs.getDrawType()) {
            case 1, 14:
                nums.setDragging(false);
                break;
            case 2, 3:
                new drawPixel(prefs, nums).released(event);
                break;
            default:
                new drawCorners(prefs, nums).released(event);
                break;
        }
        nums.setPrevX(0);
        nums.setPrevY(0);
        nums.setFinX(0);
        nums.setFinY(0);
    }
}
