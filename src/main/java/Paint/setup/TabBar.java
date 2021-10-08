package Paint.setup;

import javafx.scene.control.TabPane;

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
        System.out.println("drag tab");
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
        System.out.println("drag");
        return temp;
    }

    public void tabChange(taB currTab)
    {
        prefs.setCurrTab(currTab);
        prefs.setCurrPane(currTab.getdPane());
        prefs.setCurrentFile(currTab.getSaveSpace());
        prefs.setDrawPane(currTab.getDrawPane());
        prefs.setCanvH(currTab.getCanvH());
        prefs.setCanvW(currTab.getCanvW());
    }

    private void isTab(taB currtab)
    {
        if(currtab.isSelected())
        {
            tabChange(currtab);
        }
    }

}
