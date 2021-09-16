package Paint;
//PixelReader + PixelWriter + WritableImage

import Paint.setup.view;
import javafx.application.Application;
import javafx.stage.Stage;


public class Paint extends Application
{
    //public view mainview = new view();
    @Override
    public void start(Stage window)
    {
        new view().setupPaint(window);
    }
//    public view getView()
//    {
//        return mainview;
//    }

    public static void main(String[] args) //Main
    {
        launch(args);
    }
}