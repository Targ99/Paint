package Paint.setup.shapeCon;

import Paint.setup.allPrefs;
import Paint.setup.drawNums;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class circCon {

    private allPrefs prefs;
    private drawNums draw;

    public circCon(allPrefs pref, drawNums dra)
    {
        prefs = pref;
        draw = dra;
    }

    public void press(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        Circle circ = new Circle();
        circ.setCenterX(draw.getPrevX());
        circ.setCenterY(draw.getPrevY());
        circ.setRadius(1);
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
        draw.setCircle(circ);
        prefs.getCurrPane().getChildren().add(circ);
        prefs.getDrawPane().addStep(circ);
    }

    public void drag(MouseEvent event)
    {
        if (!event.isPrimaryButtonDown()) {return;}
        if (draw.getCircle() == null) {return;}
        double rad = Math.min(draw.getFinX()- draw.getPrevX(), draw.getFinY()- draw.getPrevY());
        draw.getCircle().setStrokeWidth(prefs.getDrawWidth());
        if(new consTrain().checkCirc((int)draw.getPrevX(), (int)draw.getPrevY(), (int)rad))
        {
            draw.getCircle().setRadius(Math.abs(rad));
        }
    }
}
