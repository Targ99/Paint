package Paint.setup;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
    private File autoSpace = null;
    private drawPane drawpane;
    private StackPane stackP;
    private Group dgroup;
    private ScrollPane scrollPane;

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
        backG = new Rectangle();
        backG.setFill(Color.web("0xe3e3e3"));
        backG.setHeight(canvH);
        backG.setWidth(canvW);
        backG.setX(0);
        backG.setY(0);
        dPane = drawpane.buildPane();
        dPane.getChildren().add(backG);
        dgroup = new Group(dPane);
        scrollPane = new ScrollPane(dgroup);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        System.out.println("drag taB");
        return scrollPane;
    }


    public ScrollPane getScrollPane() {
        return scrollPane;
    }
    public Rectangle getBackG() {
        return backG;
    }
    public drawPane getDrawPane() {
        return drawpane;
    }
    public Pane getdPane() {return dPane;}
    public File getSaveSpace() {return saveSpace;}
    public double getCanvH() {return canvH;}
    public double getCanvW() {return canvW;}

    public void setSaveSpace(File saveSpace) {this.saveSpace = saveSpace;}
    public void setCanvW(double canvW) {this.canvW = canvW;}
    public void setCanvH(double canvH) {this.canvH = canvH;}

}
