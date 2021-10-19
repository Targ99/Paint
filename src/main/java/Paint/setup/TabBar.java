package Paint.setup;

import javafx.scene.control.TabPane;

public class TabBar{

    private allPrefs prefs;

    public TabBar(allPrefs pref)
    {
        prefs = pref;
    }

    /**
     * returns a populated tab pane with a default tab
     * @return
     */
    public TabPane buildTabs()
    {
        taB defTab = newTab();
        TabPane tPane = new TabPane();
        tPane.getTabs().add(defTab);
        System.out.println("drag tab");
        return tPane;
    }

    /**
     * adds a tab to the tab bar
     * new tab is set as the current tab
     * @param tabCont
     */
    public void addTab(TabPane tabCont)
    {
        taB tempTab = newTab();
        tabCont.getTabs().add(tempTab);
    }

    /**
     * returns a new tab
     * @return
     */
    private taB newTab()
    {
        taB temp = new taB(prefs);
        prefs.setCurrTab(temp);
        temp.setText("Unsaved");
        temp.setContent(temp.build());
        temp.setOnSelectionChanged (e -> isTab(temp));
        System.out.println("drag");
        return temp;
    }

    /**
     * function used when tab is switched
     * alters the appropriate attributes in the preference container
     * @param currTab
     */
    public void tabChange(taB currTab)
    {
        prefs.setCurrTab(currTab);
        prefs.setCurrPane(currTab.getdPane());
        prefs.setCurrentFile(currTab.getSaveSpace());
        prefs.setDrawPane(currTab.getDrawPane());
        prefs.setCanvH(currTab.getCanvH());
        prefs.setCanvW(currTab.getCanvW());
        prefs.setDraw(currTab.getDrawPane().getDraw().getNums());
    }

    /**
     * checks if the given tab is the selected tab
     * if so, calls the function to switch necessary parameters
     * @param currtab
     */
    private void isTab(taB currtab)
    {
        if(currtab.isSelected())
        {
            tabChange(currtab);
        }
    }

}
