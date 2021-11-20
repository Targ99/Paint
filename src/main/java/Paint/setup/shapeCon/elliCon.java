package Paint.setup.shapeCon;

import Paint.setup.allPrefs;
import Paint.setup.drawNums;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class elliCon {

    private allPrefs prefs;
    private drawNums draw;

    public elliCon(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        Ellipse circ = new Ellipse();
        circ.setCenterX(draw.getPrevX());
        circ.setCenterY(draw.getPrevY());
        circ.setRadiusX(1);
        circ.setRadiusY(1);
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
        draw.setElli(circ);
        prefs.getCurrPane().getChildren().add(circ);
        prefs.getDrawPane().addStep(circ);
    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if (draw.getElli() == null) {return;}
        double radx = Math.abs(draw.getFinX() - draw.getPrevX());
        double rady = Math.abs(draw.getFinY() - draw.getPrevY());
        draw.getElli().setStrokeWidth(prefs.getDrawWidth());
        if(new consTrain().checkElli((int)draw.getPrevX(), (int)draw.getPrevY(), (int)radx, (int)rady))
        {
            draw.getElli().setRadiusX(radx);
            draw.getElli().setRadiusY(rady);
        }
    }

}
