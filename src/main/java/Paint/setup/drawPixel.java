package Paint.setup;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class drawPixel
{
    private allPrefs prefs;
    private drawNums nums;
    private GraphicsContext gc;

    public drawPixel(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
        gc = prefs.getCurrCanv().getGraphicsContext2D();
    }

    public void pressed(MouseEvent event)
    {
        System.out.print("wasragged");
        if (nums.isDragging()) {
            return;
        }

        int x = (int)event.getX();
        int y = (int)event.getY();

        int width = (int)prefs.getCurrCanv().getWidth();
        int height = (int)prefs.getCurrCanv().getHeight();


        if (x > 0 && x < width && y > 0 && y < height) {

            nums.setPrevX(x);
            nums.setPrevY(y);
            nums.setDragging(true);
        }
    }

    public void dragged(MouseEvent evt) {

        if (!nums.isDragging())
        {
            return;  // Nothing to do because the user isn't drawing.
        }
        double x = evt.getX();
        double y = evt.getY();
        if (x < 0)
            x = 0;
        if (x > prefs.getCurrCanv().getWidth())
            x = (int)prefs.getCurrCanv().getWidth();
        if (y < 0)
            y = 0;
        if (y > prefs.getCurrCanv().getHeight())
            y = prefs.getCurrCanv().getHeight();
        nums.setPrevX(x);
        nums.setPrevY(y);
        System.out.print("wasdagged");

    }

    public void released(MouseEvent event)
    {
        System.out.print("wasdrgged");
        gc.setFill(prefs.getDrawColor());
        gc.setStroke(prefs.getStrokeColor());
        gc.setLineWidth(prefs.getDrawWidth());
        int x = (int)event.getX();
        int y = (int)event.getY();
        nums.setPrevX(x);
        nums.setPrevY(y);
        switch (prefs.getDrawType())
        {
            case 3:
                WritableImage img = prefs.getCurrCanv().snapshot(new SnapshotParameters(), null);
                BufferedImage bimg = SwingFXUtils.fromFXImage(img, null);
                var RGBA = bimg.getRGB((int)nums.getPrevY() , (int) nums.getPrevX());
                int alpha = (RGBA >> 24) & 255;
                int red = (RGBA >> 16) & 255;
                int green = (RGBA >> 8) & 255;
                int blue = RGBA & 255;
                Color col = Color.rgb(red, green, blue, alpha/255);
                prefs.setDrawColor(col);
                prefs.setStrokeColor(col);
                System.out.println(col + "is the color selected");
                break;
            default:
                new textWin(prefs, nums).displayWin();
                break;
        }

    }
}
