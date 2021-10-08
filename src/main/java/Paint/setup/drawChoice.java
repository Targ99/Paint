package Paint.setup;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
    private Button rb13;
    private Button rb14;
    private Button rb15;
    private Button rb16;
    private Button past;

    public drawChoice(allPrefs pref) {prefs = pref;}

    public GridPane build() {
        disp = new GridPane();
         rb1 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-line-50.png", 0, false);
         rb2 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-squiggly-line-50.png", 1, false);
         rb3 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-text-50.png ",2, false);
         rb4 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-dropper-50.png", 3, false);
         rb5 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-square-50-2.png", 4, false);
         rb6 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-rectangle-48(1).png", 5, false);
         rb7 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-filled-circle-50.png", 6, false);
         rb8 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-ellipse-50-2.png", 7, false);
         rb9 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-square-50.png", 8, true);
        rb10 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-rectangle-48.png", 9, true);
        rb11 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-circle-50.png", 10, true);
        rb12 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-ellipse-50.png", 11, true);
        rb13 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-polygon-50.png", 12, false);
        rb14 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-polygon-50.png", 13, false);
        rb15 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-polygon-50.png", 14, false);
        rb16 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-polygon-50.png", 15, false);
        disp.add(rb1, 0, 1, 1, 1);  // line
        disp.add(rb2, 1, 1, 1, 1);  // free
        disp.add(rb3, 0, 0, 1, 1);  // text
        disp.add(rb4, 1, 0, 1, 1);  // dropper
        disp.add(rb5, 0, 2, 1, 1);  // square f
        disp.add(rb6, 0, 3, 1, 1);  // rect f
        disp.add(rb7, 0, 4, 1, 1);  // circ f
        disp.add(rb8, 0, 5, 1, 1);  // elli f
        disp.add(rb9, 1, 2, 1, 1);  // square
        disp.add(rb10, 1, 3, 1, 1);  // rect
        disp.add(rb11, 1, 4, 1, 1);  // circ
        disp.add(rb12, 1, 5, 1, 1);  // elli
        disp.add(rb13, 0, 6, 1, 1); // reg
        disp.add(rb14, 1, 6, 1, 1); // mine
        disp.add(rb15, 0, 7, 1, 1); // erase
        disp.add(rb16, 1, 7, 1, 1); // move

        past = rb1;
        return disp;
    }

    private Button make(String imageStream, int iter, boolean fill)
    {
        Image img = new Image(imageStream);
        if(img == null) {
            Button temp = new Button("Button");
            temp.setOnAction(event -> actionB(temp, iter, fill));
            return temp;
        }
        else
        {
            Button temp = new Button();
            temp.setGraphic(new ImageView(img));
            temp.setOnAction(event -> actionB(temp, iter, fill));
            return temp;
        }
    }

    private void actionB(Button temp, int iter, boolean fill)
    {
        past.setDisable(false);
        temp.setDisable(true);
        past = temp;
        prefs.setDrawType(iter+1);
        prefs.setFilled(fill);
    }
}
