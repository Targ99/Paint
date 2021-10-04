package Paint.setup;

import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.File;

public class TabBar{

    private allPrefs prefs;

    public TabBar(allPrefs pref)
    {
        prefs = pref;
    }

    public TabPane buildTabs()
    {
        taB defTab = newTab();
        TabPane tPane = new TabPane();
        tPane.getTabs().add(defTab);
        return tPane;
    }
    public void addTab(TabPane tabCont)
    {
        taB tempTab = newTab();
        tabCont.getTabs().add(tempTab);
    }

    private taB newTab()
    {
        taB temp = new taB(prefs);
        temp.setText("Unsaved");
        temp.setContent(temp.build());
        temp.setOnSelectionChanged (e -> isTab(temp));
        return temp;
    }

    public void tabChange(taB currTab)
    {
        prefs.setCurrTab(currTab);
        prefs.setCurrCanv(currTab.getDrawBrd());
        prefs.setCurrentFile(currTab.getSaveSpace());
    }

    private void isTab(taB currtab)
    {
        if(currtab.isSelected())
        {
            tabChange(currtab);
        }
    }

}
