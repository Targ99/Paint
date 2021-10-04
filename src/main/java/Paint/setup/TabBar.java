package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabBar{

    private allPrefs prefs;

    public TabBar(allPrefs pref)
    {
        prefs = pref;
    }

    public TabPane buildTabs()
    {
        ScrollPane defPane = new taB(prefs).build();
        Tab defTab = new Tab("Unsaved File", defPane);
        TabPane tPane = new TabPane();
        tPane.getTabs().add(defTab);
        return tPane;
    }
    public void addTab(TabPane tabCont)
    {
        Tab tempTab = new Tab("Unsaved File", new taB(prefs).build());
        tabCont.getTabs().add(tempTab);
    }
}
