package Paint.setup.shapeCon;

import Paint.setup.allPrefs;
import Paint.setup.drawNums;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class lineCon {

    private allPrefs prefs;
    private drawNums draw;

    public lineCon(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        Line circ = new Line();
        circ.setStartX(draw.getPrevX());
        circ.setStartY(draw.getPrevY());
        circ.setEndX(draw.getPrevX());
        circ.setEndY(draw.getPrevY());
        circ.setStroke(prefs.getStrokeColor());
        circ.setStrokeWidth(prefs.getDrawWidth());
        draw.setSingL(circ);
        prefs.getCurrPane().getChildren().add(circ);
        prefs.getDrawPane().addStep(circ);
    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if (draw.getSingL() == null) {return;}
        draw.getSingL().setStrokeWidth(prefs.getDrawWidth());
        draw.getSingL().setEndX(draw.getFinX());
        draw.getSingL().setEndY(draw.getFinY());
    }

}
