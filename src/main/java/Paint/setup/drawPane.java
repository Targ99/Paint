package Paint.setup;

import Paint.setup.windows.error;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class drawPane {

    private allPrefs prefs;
    private ChooseDraw draw;
    private Node imgArray[] = new Node[40];
    private int currIter = 0;
    private double scale = 1;

    public ChooseDraw getDraw() {
        return draw;
    }

    public drawPane(allPrefs pref)
    {
        prefs = pref;
        draw = new ChooseDraw(prefs);
    }

    /**
     * builds a pane which all shapes are drawn on
     * @return pane
     */
    public Pane buildPane()
    {
        Pane drawPane = new Pane();
        drawPane.setPrefSize(prefs.getCurrTab().getCanvW(), prefs.getCurrTab().getCanvH());
        prefs.setCurrPane(drawPane);
        drawPane.setOnMousePressed(event -> draw.pressed(event));
        drawPane.setOnMouseDragged(event -> draw.dragged(event));
        drawPane.setOnMouseReleased(event -> draw.released(event));
        return drawPane;
    }

    /**
     * adds another object to the array for undoing
     * populates the list for 40 total undos
     * balances list when iteration has happened
     * @param obj
     */
    public void addStep(Node obj)
    {
        if(currIter == 0) {
            for (int i = 39; i > 0; i--) {
                imgArray[i] = imgArray[i - 1];
            }
            imgArray[0] = obj;
        }
        else
        {
            balance();
            addStep(obj);
        }
        System.out.println("step called");
    }

    /**
     * makes items transparent when undone
     */
    public void undo()
    {
        if(currIter<39 && !(imgArray[currIter] == null)) {
            imgArray[currIter].setVisible(false);
            currIter++;
        }
        else
        {
            new error("There are no more undo operations remaining").errorwindow(prefs);
        }
        System.out.println("undo called");
    }

    public void balance()
    {
        while (currIter>0)
        {
            for (int i = 0; i < 39; i++) {
                imgArray[i] = imgArray[i + 1];
            }
            currIter--;
        }
    }

    /**
     * redoes anything undone before new changes
     */
    public void redo()
    {
        while(imgArray[currIter]== null && currIter>0)
        {
            currIter--;
        }
        if(currIter>0)
        {
            currIter--;
            imgArray[currIter].setVisible(true);

        }
        else
        {
            new error("There are no more redo operations remaining").errorwindow(prefs);
        }
        System.out.println("redo called");
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
