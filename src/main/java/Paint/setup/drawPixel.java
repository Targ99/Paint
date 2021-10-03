package Paint.setup;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class drawPixel
{
    private allPrefs prefs;

    public drawPixel(allPrefs pref)
    {prefs = pref;}

    public void pressed(MouseEvent e)
    {
        if (prefs.getDragging())
            return;


        int x = (int)e.getX();
        int y = (int)e.getY();

        int width = (int)drawBrd.getWidth();
        int height = (int)drawBrd.getHeight();


        if (x > 0 && x < width && y > 0 && y < height) {

            prevX = x;
            prevY = y;
            dragging = true;
        }
    }

    public void dragged(MouseEvent evt) {

        if (!dragging)
        {
            return;  // Nothing to do because the user isn't drawing.
        }
        double x = evt.getX();
        double y = evt.getY();
        if (x < 0)
            x = 0;
        if (x > drawBrd.getWidth())
            x = (int)drawBrd.getWidth();
        if (y < 0)
            y = 0;
        if (y > drawBrd.getHeight())
            y = drawBrd.getHeight();
        prevX = x;
        prevY = y;

    }

    public void released(MouseEvent event)
    {
        gc.setLineWidth(drawWidth);
        gc.setStroke(strokeColor);
        gc.setFill(drawColor);
        switch (drawType)
        {
            case 3:
                WritableImage img = drawBrd.snapshot(new SnapshotParameters(), null);
                BufferedImage bimg = SwingFXUtils.fromFXImage(img, null);
                var RGBA = bimg.getRGB((int)prevX, (int) prevY);
                int alpha = (RGBA >> 24) & 255;
                int red = (RGBA >> 16) & 255;
                int green = (RGBA >> 8) & 255;
                int blue = RGBA & 255;
                Color col = Color.rgb(red, green, blue, alpha/255);
                super.drawColor = col;
                super.strokeColor = col;
                System.out.println(col + "is the color selected");
                break;
            default:
                new textWin();
                break;
        }

    }
}
