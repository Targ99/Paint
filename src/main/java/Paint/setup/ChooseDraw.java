package Paint.setup;

import javafx.scene.input.MouseEvent;

public class ChooseDraw
{
    private allPrefs prefs;
    private drawNums nums = new drawNums();


    public ChooseDraw(allPrefs pref) {prefs = pref;}

    public drawNums getNums() {
        return nums;
    }

    /**
     * uses mouse event attributes and drawing parameters to
     * construct the desired shape
     * @param event
     */
    void pressed(MouseEvent event)
    {

        switch (prefs.getDrawType()) {
            case 2, 15:
                new drawFree(prefs, nums).pressed(event);
                break;
            case 4, 3, 17, 18:
                new drawPixel(prefs, nums).pressed(event);
                break;
            default:
                System.out.println("drag corn");
                new drawCorners(prefs, nums).pressed(event);
                break;
        }
    }
    void dragged(MouseEvent event)
    {
        switch (prefs.getDrawType()) {
            case 2, 15:
                new drawFree(prefs, nums).dragged(event);
                break;
            case 4, 3, 17, 18:
                break;
            default:
                new drawCorners(prefs, nums).dragged(event);
                break;
        }
    }
    void released(MouseEvent event)
    {
        switch (prefs.getDrawType()) {
            case 2, 15:
                nums.reset(true);
                break;
            case 4, 3, 17, 18:
                nums.reset(false);
                break;
            default:
                new drawCorners(prefs, nums).released(event);
                break;
        }
        nums.setDragging(false);
    }
}
