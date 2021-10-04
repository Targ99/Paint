package Paint.setup;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.InputStream;

public class drawChoice {
    private allPrefs prefs;
    private GridPane disp;
    private Button rb1;
    private Button rb2;
    private Button rb3;
    private Button rb4;
    private Button rb5;
    private Button rb6;
    private Button rb7;
    private Button rb8;
    private Button rb9;
    private Button rb10;
    private Button rb11;
    private Button rb12;
    private Button past;

    public drawChoice(allPrefs pref) {prefs = pref;}

    public GridPane build()
    {
        disp = new GridPane();
         rb1 = make((getClass().getResourceAsStream("/Icons/icons8-line-50.png")), 0);
         rb2 = make((getClass().getResourceAsStream("/Icons/icons8-squiggly-50.png")), 1);
         rb3 = make((getClass().getResourceAsStream("/Icons/icons8-text-50.png")), 2);
         rb4 = make((getClass().getResourceAsStream("/Icons/icons8-dropper-50.png")), 3);
         rb5 = make((getClass().getResourceAsStream("/Icons/icons8-square-50-2.png")), 4);
         rb6 = make((getClass().getResourceAsStream("/Icons/icons8-rectangle-48(1).png")), 5);
         rb7 = make((getClass().getResourceAsStream("/Icons/icons8-filled-circle-50.png")), 6);
         rb8 = make((getClass().getResourceAsStream("/Icons/icons8-ellipse-50-2.png")), 7);
         rb9 = make((getClass().getResourceAsStream("/Icons/icons8-square-50.png")), 8);
        rb10 = make((getClass().getResourceAsStream("/Icons/icons8-rectangle-48.png")), 9);
        rb11 = make((getClass().getResourceAsStream("/Icons/icons8-circle-50.png")), 10);
        rb12 = make((getClass().getResourceAsStream("/Icons/icons8-ellipse-50.png")), 11);
        disp.add(rb1, 0, 1, 1, 1);
        disp.add(rb2, 1, 1, 1, 1);
        disp.add(rb3, 0, 0, 1, 1);
        disp.add(rb4, 1, 0, 1, 1);
        disp.add(rb5, 0, 2, 1, 1);
        disp.add(rb6, 0, 3, 1, 1);
        disp.add(rb7, 0, 4, 1, 1);
        disp.add(rb8, 0, 5, 1, 1);
        disp.add(rb9, 1, 2, 1, 1);
        disp.add(rb10, 1, 3, 1, 1);
        disp.add(rb11, 1, 4, 1, 1);
        disp.add(rb12, 1, 5, 1, 1);

        past = rb1;
        return disp;
    }

    private Button make(InputStream imageStream, int iter)
    {
        if (imageStream == null) {
            Button temp = new Button("Button");
            temp.setOnAction(event -> actionB(temp, iter));
            return temp;
        }
        else
        {
            Button temp = new Button();
            Image temp2 = new Image(imageStream);
            temp.setGraphic(new ImageView(temp2));
            temp.setOnAction(event -> actionB(temp, iter));
            return temp;
        }
    }

    private void actionB(Button temp, int iter)
    {
        past.setDisable(false);
        temp.setDisable(true);
        past = temp;
        prefs.setDrawType(iter);
    }



}
