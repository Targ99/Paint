package Paint.setup;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class drawNums
{
    private boolean dragging = false;
    private double prevX, prevY, finX, finY;
    private boolean wasD;
    private Image bimg;
    private double imgW, imgH;
    private boolean placed = true;

    public void setBimg(Image bimg) {
        this.bimg = bimg;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public double getImgH() {
        return imgH;
    }

    public double getImgW() {
        return imgW;
    }

    public void setImgH(double imgH) {
        this.imgH = imgH;
    }

    public void setImgW(double imgW) {
        this.imgW = imgW;
    }

    public Image getBimg() {
        return bimg;
    }

    public boolean isWasD() {
        return wasD;
    }

    public void setWasD(boolean wasD) {
        this.wasD = wasD;
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
