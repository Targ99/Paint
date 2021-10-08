package Paint.setup;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;


public class taB extends Tab
{
    private allPrefs prefs;
    private double canvH = 700;
    private double canvW = 700;
    private Rectangle backG;
    private Pane dPane;
    private File saveSpace = null;
    private drawPane drawpane;

    /**
     * extends Tab because some attributes required lower level
     * containers
     * @param pref
     */
    public taB(allPrefs pref)
    {
        prefs = pref;
        drawpane = new drawPane(prefs);
    }

    /**
     * builds and returns a populated scrollpane
     * @return
     */
    public ScrollPane build()
    {
        dPane = drawpane.buildPane();
        Group dgroup = new Group(dPane);
        ScrollPane scrollPane = new ScrollPane(dgroup);
        System.out.println("drag taB");

        return scrollPane;
    }

    public drawPane getDrawPane() {
        return drawpane;
    }

    public Pane getdPane() {return dPane;}

    public void setdPane(Pane dPane) {
        this.dPane = dPane;
    }

    public File getSaveSpace() {return saveSpace;}
    public void setSaveSpace(File saveSpace) {this.saveSpace = saveSpace;}

    public void setCanvW(double canvW) {
        this.canvW = canvW;
    }

    public void setCanvH(double canvH) {
        this.canvH = canvH;
    }

    public double getCanvH() {
        return canvH;
    }

    public double getCanvW() {
        return canvW;
    }
}
