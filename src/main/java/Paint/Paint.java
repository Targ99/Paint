package Paint;
//PixelReader + PixelWriter + WritableImage

import Paint.setup.view;
import javafx.application.Application;
import javafx.stage.Stage;

//Good for now//

public class Paint extends Application
{

    @Override
    public void start(Stage window)
    {
        new view(window);
    }

    public static void main(String[] args) //Main
    {
        launch(args);
    }
}