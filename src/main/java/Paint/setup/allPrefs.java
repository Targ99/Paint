package Paint.setup;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;

public class allPrefs{
    private Stage window;
    private TopBar topBar;
    private TabBar tabBar;
    private TabPane drawPanes;
//    private ScrollWindow scrollWindow;
    private int drawType = 0;
//    private double canvH = 500;
//    private double canvW = 700;
//    private Canvas drawBrd = new Canvas(canvW, canvH);
    private javafx.scene.paint.Color drawColor = Color.BLACK;
    private javafx.scene.paint.Color strokeColor = Color.BLACK;
    private double drawWidth = 10;//moving
    private File currentFile = null;// moving
//    private GraphicsContext gc = drawBrd.getGraphicsContext2D();

    public allPrefs(Stage windo)
    {
        window = windo;
    }


    public Scene build()
    {
        ScrollPane canv = new ScrollWindow().buildScroll();
        HBox top = new TopBar().displayTB();
        drawPanes = new TabBar().buildTabs(canv);
        VBox inScene = new VBox(top, drawPanes);
        Scene scene = new Scene(inScene);
        return scene;
    }



//    // Getters and Setters //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

//    public Stage getMainStage() {return mainStage;}
//    public void setMainStage(Stage mainStag) {this.mainStage = mainStag;}


    public Stage getWindow() {return window;}
    public File getCurrentFile() {return currentFile;}
    public Color getDrawColor() {return drawColor;}
    public double getDrawWidth() {return drawWidth;}
    public Color getStrokeColor() {return strokeColor;}
    public int getDrawType() {return drawType;}

    public void setCanvH(int canvH) {this.canvH = canvH;}
    public void setCanvW(int canvW) {this.canvW = canvW;}
    public void setCurrentFile(File currentFile) {this.currentFile = currentFile;}
    public void setDrawWidth(double drawWidth) {this.drawWidth = drawWidth;}
    public void setDrawColor(javafx.scene.paint.Color drawColor) {this.drawColor = drawColor;}
    public void setDrawType(int drawType) {this.drawType = drawType;}
    public void setStrokeColor(Color strokeColor) {this.strokeColor = strokeColor;}

//    // Getters and Setters //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


}
