package Paint.setup;

import Paint.setup.shapeCon.textWin;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class drawPixel {
    private allPrefs prefs;
    private drawNums nums;

    public drawPixel(allPrefs pref, drawNums n1) {
        nums = n1;
        prefs = pref;
    }

    public void pressed(MouseEvent event) {
        if (nums.isDragging()) {
            return;
        }

        int x = (int) event.getX();   // x-coordinate where the user clicked.
        int y = (int) event.getY();   // y-coordinate where the user clicked.

        int width = (int) prefs.getCanvW();    // Width of the canvas.
        int height = (int) prefs.getCanvH();  // Height of the canvas.


        if (x > 0 && x < width && y > 0 && y < height)
        {
            nums.setPrevX(x);
            nums.setPrevY(y);
            switch (prefs.getDrawType())
            {
                case 3:
                    WritableImage img = prefs.getCurrPane().snapshot(new SnapshotParameters(), null);
                    BufferedImage bimg = SwingFXUtils.fromFXImage(img, null);
                    var RGBA = bimg.getRGB((int)nums.getPrevY() , (int) nums.getPrevX());
                    System.out.println(nums.getPrevX() + "      " + nums.getPrevY() + nums.getFinX() + "      " + nums.getFinY());
                    int alpha = (RGBA >> 24) & 255;
                    int red = (RGBA >> 16) & 255;
                    int green = (RGBA >> 8) & 255;
                    int blue = RGBA & 255;
                    Color col = Color.rgb(red, green, blue, alpha/255);
                    prefs.setDrawColor(col);
                    prefs.setStrokeColor(col);
                    System.out.println(col + "is the color selected");
                    break;
                case 18:
                    ImageView iview = new ImageView(nums.getBimg());
                    prefs.getCurrPane().getChildren().add(iview);
                    prefs.getDrawPane().addStep(iview);
                    iview.setX(nums.getPrevX());
                    iview.setY(nums.getPrevY());
                    nums.getRect().setVisible(false);
                    break;
                default:
                    new textWin(prefs, nums).displayWin();
                    break;
            }
        }
    }
}


