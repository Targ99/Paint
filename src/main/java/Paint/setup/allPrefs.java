package Paint.setup;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class allPrefs
{
    private Stage window;
    private TabPane tabCont;
    private taB currTab;
//    private Canvas currCanv;
    private Pane currPane;
    private drawPane drawpane;
    private double canvW, canvH;
    private int drawType = 1;
    private int numsides = 4;
    private boolean filled = false;
    private Color drawColor = Color.BLACK;
    private Color strokeColor = Color.BLACK;
    private double drawWidth = 10;
    private File currentFile = null;

    public allPrefs(Stage windo)
    {
        window = windo;
    }

// Getters and Setters //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


//    public Canvas getCurrCanv() {return currCanv;}

    public double getCanvH() {
        return canvH;
    }

    public double getCanvW() {
        return canvW;
    }

    public drawPane getDrawPane() {
        return drawpane;
    }

    public void setDrawPane(drawPane drawpane) {
        this.drawpane = drawpane;
    }

    public Pane getCurrPane() {return currPane;}
    public TabPane getTabCont() {return tabCont;}
    public Stage getWindow() {return window;}
    public File getCurrentFile() {return currentFile;}
    public Color getDrawColor() {return drawColor;}
    public double getDrawWidth() {return drawWidth;}
    public Color getStrokeColor() {return strokeColor;}
    public int getDrawType() {return drawType;}
    public taB getCurrTab() {return currTab;}
    public int getNumsides() {return numsides;}
    public boolean isFilled() {return filled;}


    public void setCanvH(double canvH) {
        this.canvH = canvH;
    }

    public void setCanvW(double canvW) {
        this.canvW = canvW;
    }

    public void setCurrTab(taB currTab) {this.currTab = currTab;}
    public void setCurrPane(Pane currPane) {this.currPane = currPane;}
    public void setCurrentFile(File currentFile) {this.currentFile = currentFile;}
    public void setDrawWidth(double drawWidth) {this.drawWidth = drawWidth;}
    public void setDrawColor(javafx.scene.paint.Color drawColor) {this.drawColor = drawColor;}
    public void setDrawType(int drawType) {this.drawType = drawType;}
    public void setStrokeColor(Color strokeColor) {this.strokeColor = strokeColor;}
    public void setTabCont(TabPane tabcont) {tabCont = tabcont;}
//    public void setCurrCanv(Canvas currCanv) {this.currCanv = currCanv;}
    public void setNumsides(int numsides) {this.numsides = numsides;}
    public void setFilled(boolean filled) {this.filled = filled;}


    // Getters and Setters //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
