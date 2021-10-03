package Paint.setup;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class ChooseDraw
{
    private allPrefs prefs;

    private ChooseDraw(allPrefs pref)
    {
        prefs = pref;
    }
    protected boolean dragging = false;
    protected double prevX, prevY, finX, finY;

    protected drawFree free;
    protected drawCorners corners;
    protected drawPixel pixel;

    void presseda(MouseEvent event)
    {
        switch (drawType) {
            case 1:
                new drawFree().pressed(event);
                break;
            case 2, 3:
                new drawPixel().pressed(event);
                break;
            default:
                new drawCorners().pressed(event);
                break;
        }
    }
    void draggeda(MouseEvent event)
    {
        switch (drawType) {
            case 1:
                new drawFree().dragged(event);
                break;
            case 2, 3:
                new drawPixel().dragged(event);
                break;
            default:
                new drawCorners().dragged(event);
                break;
        }
    }
    void releaseda(MouseEvent event)
    {
        switch (drawType) {
            case 1:
                dragging=false;
                break;
            case 2, 3:
                new drawPixel().released(event);
                break;
            default:
                new drawCorners().released(event);
                break;
        }
    }
}
