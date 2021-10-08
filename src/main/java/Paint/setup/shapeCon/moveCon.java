package Paint.setup.shapeCon;

import Paint.setup.SwingFXUtils;
import Paint.setup.allPrefs;
import Paint.setup.drawNums;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.image.BufferedImage;


public class moveCon {

    private allPrefs prefs;
    private drawNums draw;

    public moveCon(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if(draw.isPlaced())
        {
            Rectangle circ = new Rectangle();
            circ.setX(draw.getPrevX());
            circ.setY(draw.getPrevY());
            circ.setWidth(1);
            circ.setHeight(1);
            circ.setStroke(Color.BLACK);
            circ.setStrokeWidth(2);
            circ.setFill(Color.TRANSPARENT);
            draw.setRect(circ);
            prefs.getCurrPane().getChildren().add(circ);
        }
        else
        {
            ImageView iview = new ImageView(draw.getBimg());
            prefs.getCurrPane().getChildren().add(iview);
            prefs.getDrawPane().addStep(iview);
            iview.setX(draw.getPrevX());
            iview.setY(draw.getPrevY());
            draw.getRect().setVisible(false);
            draw.setBimg(null);
            draw.setRect(null);
            draw.setPlaced(true);
        }

    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if (draw.getRect() == null) {return;}
        double wid = draw.getFinX() - draw.getPrevX();
        double hei = draw.getFinY() - draw.getPrevY();
        draw.getRect().setStrokeWidth(2);
        draw.getRect().setWidth(wid);
        draw.getRect().setHeight(hei);
        WritableImage img = prefs.getCurrPane().snapshot(new SnapshotParameters(), null);
        BufferedImage bimg = SwingFXUtils.fromFXImage(img, null);
        assert bimg != null;
        BufferedImage sub = bimg.getSubimage((int) draw.getPrevX(), (int) draw.getPrevY(), (int) wid, (int) hei);
        Image tempImg = SwingFXUtils.toFXImage(sub, null);
        draw.setBimg(tempImg);
        draw.setImgH(hei);
        draw.setImgW(wid);
        draw.setPlaced(false);
    }

}
