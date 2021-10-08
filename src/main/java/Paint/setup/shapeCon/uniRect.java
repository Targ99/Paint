package Paint.setup.shapeCon;

import Paint.setup.allPrefs;

public class uniRect {

    private allPrefs prefs;

    public uniRect(allPrefs pref)
    {
        prefs = pref;
    }

    /**
     * calculates a normal polygon's points for a given
     * number of sides
     * @param x1 starting x val
     * @param y1 starting y val
     * @param x2 final x val
     * @param y2 final y val
     * @return an array of coordinates for the points of the regular polygon
     */
    public double[] buildRect(double x1, double y1, double x2, double y2)
    {
        double pi = 3.14159265359;
        int sides = prefs.getNumsides();
        int z = sides * 2;
        double rads = (2* pi)/sides;
        double centX = Math.abs(x1-x2)/2;
        double centY = Math.abs(y1-y2)/2;
        double radius = Math.min(centX, centY);
        double[] coords = new double[z];
        centX = centX + Math.min(x1, x2);
        centY = centY + Math.min(y1, y2);
        for (int i = 0; i < sides; i++)
        {
            double rad = i*rads;
            coords[2*i] = (Math.cos(rad) * radius) + centX;
            coords[(2*i)+1] = (Math.sin(rad) * radius) + centY;
            System.out.println(coords[i]);
        }
        return coords;
    }

    /**
     * calculates the points for a unique shape
     * @param x1 starting x val
     * @param y1 starting y val
     * @param x2 final x val
     * @param y2 final y val
     * @return array of x and y values
     */
    public double[] buildStar(double x1, double y1, double x2, double y2)
    {
        double[] coords = new double[10];
        coords[0] = Math.min(x1,x2);
        coords[1] = Math.max(y1,y2);
        coords[2] = Math.abs((x2-x1)/2) + Math.min(x1,x2);
        coords[3] = Math.max(y1,y2);
        coords[4] = Math.max(x1,x2);
        coords[5] = Math.max(y1,y2);
        coords[6] = Math.min(x1,x2);
        coords[7] = Math.abs((y2-y1)/2) + Math.max(y1,y2);
        coords[8] = Math.max(x1,x2);
        coords[9] = Math.abs((y2-y1)/2) + Math.max(y1,y2);
        for(int a = 0; a<10;a++)
        {
            System.out.println(coords[a]);
        }
        return coords;
    }

}
