package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabBar{

    private allPrefs prefs;

    private TabBar(allPrefs pref)
    {
        prefs = pref;
    }

    public TabPane buildTabs(ScrollPane canvas)
    {
        Tab defTab = new Tab("Unsaved File", canvas);
        TabPane tBar = new TabPane();
        tBar.getTabs().add(defTab);
        return tBar;
    }
    public void addTab()
    {
        Tab tempTab = new Tab("Unsaved File", new ScrollWindow().buildScroll());
        prefs.getdrawPanes().getTabs().add(tempTab);
    }
}
