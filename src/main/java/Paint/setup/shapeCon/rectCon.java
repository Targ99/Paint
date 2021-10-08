package Paint.setup.shapeCon;

import Paint.setup.allPrefs;
import Paint.setup.drawNums;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class rectCon {

    private allPrefs prefs;
    private drawNums draw;

    public rectCon(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        Rectangle circ = new Rectangle();
        circ.setX(draw.getPrevX());
        circ.setY(draw.getPrevY());
        circ.setWidth(1);
        circ.setHeight(1);
        if(prefs.isFilled())
        {
            circ.setFill(prefs.getDrawColor());
        }
        else
        {
            circ.setStroke(prefs.getStrokeColor());
            circ.setStrokeWidth(prefs.getDrawWidth());
            circ.setFill(Color.TRANSPARENT);
        }
        draw.setRect(circ);
        prefs.getCurrPane().getChildren().add(circ);
        prefs.getDrawPane().addStep(circ);
    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if (draw.getRect() == null) {return;}
        if(prefs.getDrawType() == 5 || prefs.getDrawType() == 9)
        {
            double wid = draw.getFinX() - draw.getPrevX();
            double hei = draw.getFinY() - draw.getPrevY();
            double min = Math.min(wid, hei);
            draw.getRect().setStrokeWidth(prefs.getDrawWidth());
            draw.getRect().setWidth(min);
            draw.getRect().setHeight(min);
        }
        else
        {
            double wid = draw.getFinX() - draw.getPrevX();
            double hei = draw.getFinY() - draw.getPrevY();
            draw.getRect().setStrokeWidth(prefs.getDrawWidth());
            draw.getRect().setWidth(wid);
            draw.getRect().setHeight(hei);
        }
    }

}
