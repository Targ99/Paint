package Paint.setup;

import javafx.scene.canvas.GraphicsContext;

public class uniRect {
    private allPrefs prefs;
    GraphicsContext gc;

    public uniRect(allPrefs pref)
    {
        prefs = pref;
        gc = prefs.getCurrCanv().getGraphicsContext2D();
    }

    public void buildRect(double x1, double y1, double x2, double y2)
    {
        gc.setFill(prefs.getDrawColor());
        gc.setStroke(prefs.getStrokeColor());
        gc.setLineWidth(prefs.getDrawWidth());
        double pi = 3.14159265359;
        int sides = prefs.getNumsides();
        double rads = (2* pi)/sides;
        double centX = Math.abs(x1-x2)/2;
        double centY = Math.abs(y1-y2)/2;
        double radius = Math.min(centX, centY);
        double[] xcoords = new double[sides];
        double[] ycoords = new double[sides];
        centX = centX + Math.min(x1, x2);
        centY = centY + Math.min(y1, y2);
        for (int i = 0; i < sides; i++)
        {
            double rad = i*rads;
            xcoords[i] = (Math.cos(rad) * radius) + centX;
            ycoords[i] = (Math.sin(rad) * radius) + centY;
            System.out.println(xcoords[i] + " " + ycoords[i]);
        }
        gc.strokePolygon(xcoords, ycoords, sides);
    }

}
