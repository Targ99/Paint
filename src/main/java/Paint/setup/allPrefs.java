package Paint.setup;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;

public class allPrefs{
    private Stage window;
    private TabPane tabCont;
    private Tab currTab;
    private Canvas currCanv;
//    private TabPane tabPanes;
//    private ScrollWindow scrollWindow;
    private int drawType = 0;

//    private Canvas drawBrd = new Canvas(canvW, canvH);
    private Color drawColor = Color.BLACK;
    private Color strokeColor = Color.BLACK;
    private double drawWidth = 10;
    private File currentFile = null;
//    private GraphicsContext gc = drawBrd.getGraphicsContext2D();

    public allPrefs(Stage windo)
    {
        window = windo;
    }




// Getters and Setters //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

//    public Stage getMainStage() {return mainStage;}
//    public void setMainStage(Stage mainStag) {this.mainStage = mainStag;}

    public Canvas getCurrCanv() {return currCanv;}
    public TabPane getTabCont() {return tabCont;}
    public Stage getWindow() {return window;}
    public File getCurrentFile() {return currentFile;}
    public Color getDrawColor() {return drawColor;}
    public double getDrawWidth() {return drawWidth;}
    public Color getStrokeColor() {return strokeColor;}
    public int getDrawType() {return drawType;}

//    public void setCanvH(int canvH) {this.canvH = canvH;}
//    public void setCanvW(int canvW) {this.canvW = canvW;}
    public void setCurrentFile(File currentFile) {this.currentFile = currentFile;}
    public void setDrawWidth(double drawWidth) {this.drawWidth = drawWidth;}
    public void setDrawColor(javafx.scene.paint.Color drawColor) {this.drawColor = drawColor;}
    public void setDrawType(int drawType) {this.drawType = drawType;}
    public void setStrokeColor(Color strokeColor) {this.strokeColor = strokeColor;}
    public void setTabCont(TabPane tabcont) {tabCont = tabcont;}
    public void setCurrCanv(Canvas currCanv) {this.currCanv = currCanv;}
    // Getters and Setters //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


}
