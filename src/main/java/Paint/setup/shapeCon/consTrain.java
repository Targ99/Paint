package Paint.setup.shapeCon;

public class consTrain {

    public boolean checkCirc(int x1, int y1, int rad)
    {
        if(rad > x1) return false;
        if(rad > y1) return false;
        return true;
    }

//    public boolean checkRect()
//    {
//
//    }
//
//    public boolean checkMove()
//    {
//
//    }
//
//    public void cropPaste()
//    {
//
//    }

    public boolean checkElli(int x1, int y1, int radx, int rady)
    {
        if(radx > x1) return false;
        if(rady > y1) return false;
        return true;
    }

}
