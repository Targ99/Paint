package Paint.setup;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;

public class placeImg {
    private allPrefs prefs;
    private drawNums nums;
    private GraphicsContext gc;

    public placeImg(allPrefs pref, drawNums n1)
    {
        nums = n1;
        prefs = pref;
        gc = prefs.getCurrCanv().getGraphicsContext2D();
    }

    public void getImg(double x1, double y1, double x2, double y2)
    {
        WritableImage img = prefs.getCurrCanv().snapshot(new SnapshotParameters(), null);
        BufferedImage bimg = SwingFXUtils.fromFXImage(img, null);
        assert bimg != null;
        BufferedImage sub = bimg.getSubimage((int) x1, (int) y1, (int) (x2-x1), (int) (y2-y1));
        Image tempImg = SwingFXUtils.toFXImage(sub, null);
        nums.setBimg(tempImg);
        nums.setImgH(y2-y1);
        nums.setImgW(x2-x1);
        nums.setPlaced(false);
    }

    public void putImg()
    {
        System.out.println(nums.getPrevX() + "      " + nums.getPrevY() + nums.getImgW() + "      " + nums.getImgH());
        gc.drawImage(nums.getBimg(), nums.getPrevX(), nums.getPrevY(), nums.getImgW(), nums.getImgH());
        nums.setPlaced(true);
    }
}
