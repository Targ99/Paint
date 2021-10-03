package Paint.setup;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScrollWindow{

//    protected GraphicsContext gc = drawBrd.getGraphicsContext2D();

    public ScrollPane buildScroll()
    {
        StackPane picdisplay = new StackPane();
        ScrollPane scrollPane = new ScrollPane(picdisplay);
//        drawBrd = new Canvas(super.canvW, super.canvH);
        scrollPane.setMaxSize(super.canvW, super.canvH);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        ChooseDraw draw = new ChooseDraw();
        drawBrd.setOnMousePressed(event -> draw.presseda(event));
        drawBrd.setOnMouseDragged(event -> draw.draggeda(event));
        drawBrd.setOnMouseReleased(event -> draw.releaseda(event));
        picdisplay.getChildren().add(drawBrd);
        return scrollPane;
    }

    public void changeCanv(double width, double height)
    {
        drawBrd.setWidth(width);
        drawBrd.setHeight(height);
    }
}
