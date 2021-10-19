package Paint.setup;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;

public class drawNums
{
    private boolean dragging = false;
    private double prevX, prevY, finX, finY;
    private Image bimg;
    private Circle circle;
    private Ellipse elli;
    private Rectangle rect;
    private Line singL;
    private Polygon poly;
    private Path pat;
    private boolean isMoving = false;
    private ImageView view;

    public void reset(boolean delImg)
    {
        dragging = false;
        prevX = 0;
        prevY = 0;
        finX = 0;
        finY = 0;
        if(delImg) {bimg = null;}
        circle = null;
        elli = null;
        rect = null;
        singL = null;
        poly = null;
        pat = null;
    }

    public ImageView getView() {
        return view;
    }

    public void setView(ImageView view) {
        this.view = view;
    }

    public Path getPat() {
        return pat;
    }

    public void setPat(Path pat) {
        this.pat = pat;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Polygon getPoly() {
        return poly;
    }

    public void setPoly(Polygon poly) {
        this.poly = poly;
    }


    public Circle getCircle() {
        return circle;
    }

    public Line getSingL() {
        return singL;
    }

    public void setSingL(Line singL) {
        this.singL = singL;
    }

    public Ellipse getElli() {
        return elli;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void setElli(Ellipse elli) {
        this.elli = elli;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public void setBimg(Image bimg) {
        this.bimg = bimg;
    }

    public Image getBimg() {
        return bimg;
    }

    public boolean isDragging() {
        return dragging;
    }

    public double getFinX() {
        return finX;
    }

    public double getFinY() {
        return finY;
    }

    public double getPrevX() {
        return prevX;
    }

    public double getPrevY() {
        return prevY;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public void setFinX(double finX) {
        this.finX = finX;
    }

    public void setFinY(double finY) {
        this.finY = finY;
    }

    public void setPrevX(double prevX) {
        this.prevX = prevX;
    }

    public void setPrevY(double prevY) {
        this.prevY = prevY;
    }



}
