package Paint.setup.shapeCon;

import Paint.setup.allPrefs;
import Paint.setup.drawNums;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class polyCon {

    private allPrefs prefs;
    private drawNums draw;

    public polyCon(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        uniRect makeR = new uniRect(prefs);
        double[] coords = makeR.buildRect( draw.getPrevX(), draw.getPrevY(),draw.getPrevX()+1, draw.getPrevY()+1);
        Polygon circ = new Polygon(coords);
        circ.setStroke(prefs.getStrokeColor());
        circ.setStrokeWidth(prefs.getDrawWidth());
        circ.setFill(Color.TRANSPARENT);
        draw.setPoly(circ);
        prefs.getCurrPane().getChildren().add(circ);
        prefs.getDrawPane().addStep(circ);
    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if (draw.getPoly() == null) {return;}
        uniRect makeR = new uniRect(prefs);
        double[] coords = makeR.buildRect( draw.getPrevX(), draw.getPrevY(),draw.getFinX(), draw.getFinY());
        draw.getPoly().getPoints().clear();
        for(int i  = 0; i<coords.length; i++)
        {
            draw.getPoly().getPoints().add(coords[i]);
        }
    }

}
