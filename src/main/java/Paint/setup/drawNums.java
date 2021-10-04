package Paint.setup;

public class drawNums
{
    private boolean dragging = false;
    private double prevX, prevY, finX, finY;
    private boolean wasD;

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
