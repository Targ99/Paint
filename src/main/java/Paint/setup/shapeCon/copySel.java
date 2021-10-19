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


public class copySel {

    private allPrefs prefs;
    private drawNums draw;

    public copySel(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if(!draw.isMoving())
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
    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if(draw.isMoving())
        {
            ImageView view = draw.getView();
            double currX = view.getX();
            double currY = view.getY();
            double moveX = currX + (draw.getFinX() - draw.getPrevX());
            if(moveX < 0) moveX = 0;
            if(moveX > prefs.getCanvW()) moveX = prefs.getCanvW();
            double moveY = currY + (draw.getFinY() - draw.getPrevY());
            if(moveY < 0) moveY = 0;
            if(moveY > prefs.getCanvH()) moveY = prefs.getCanvH();
            view.setX(moveX);
            view.setY(moveY);
            draw.setPrevX(draw.getFinX());
            draw.setPrevY(draw.getFinY());
        }
        else
        {
            if (draw.getRect() == null) {
                return;
            }
            double wid = draw.getFinX() - draw.getPrevX();
            double hei = draw.getFinY() - draw.getPrevY();
            draw.getRect().setStrokeWidth(2);
            draw.getRect().setWidth(wid);
            draw.getRect().setHeight(hei);
        }
    }

    public void release(MouseEvent event)
    {
        if(!draw.isMoving())
        {
            double wid = draw.getFinX() - draw.getPrevX();
            double hei = draw.getFinY() - draw.getPrevY();
            draw.getRect().setVisible(false);
            WritableImage img = prefs.getCurrPane().snapshot(new SnapshotParameters(), null);
            BufferedImage bimg = SwingFXUtils.fromFXImage(img, null);
            assert bimg != null;
            BufferedImage sub = bimg.getSubimage((int) draw.getPrevX(), (int) draw.getPrevY(), (int) wid, (int) hei);
            BufferedImage sub2 = new BufferedImage((int) wid, (int) hei, bimg.getType());
            sub.copyData(sub2.getRaster());
            Image tempImg = SwingFXUtils.toFXImage(sub2, null);
            System.out.println("prex = " + (int) draw.getPrevX() + "  prey = " + (int) draw.getPrevY());
            draw.setBimg(tempImg);
            if (prefs.getDrawType() == 19)
            {
                draw.getRect().setVisible(true);
                draw.getRect().setFill(Color.web("0xe3e3e3"));
                draw.getRect().setStroke(Color.TRANSPARENT);
                ImageView movImg = new ImageView(tempImg);
                draw.setView(movImg);
                prefs.getCurrPane().getChildren().add(movImg);
                movImg.setX(draw.getPrevX());
                movImg.setY(draw.getPrevY());
                prefs.getRb17().setDisable(false);
                draw.setMoving(true);
            }
        }
    }
}
