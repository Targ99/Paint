package Paint.setup;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
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
    private Button rb17;
    private Button rb18, rb19;
    private Button past;

    public drawChoice(allPrefs pref) {prefs = pref;}

    public GridPane build() { // Building all the shape buttons
        disp = new GridPane();
         rb1 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-line-50.png", 0, false, "Draw a Line");
         rb2 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-squiggly-line-50.png", 1, false, "Draw a Freeform Line");
         rb3 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-text-50.png ",2, false, "Insert Text");
         rb4 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-dropper-50.png", 3, false, "Change Current Color to Clicked Color");
         rb5 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-square-50-2.png", 4, false, "Draw a Filled Square");
         rb6 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-rectangle-48(1).png", 5, false, "Draw a Filled Rectangle");
         rb7 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-filled-circle-50.png", 6, false, "Draw a Filled Circle");
         rb8 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-ellipse-50-2.png", 7, true, "Draw a Filled Ellipse");
         rb9 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-square-50.png", 8, true, "Draw a Square");
        rb10 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-rectangle-48.png", 9, true, "Draw a Rectangle");
        rb11 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-circle-50.png", 10, true, "Draw a Circle");
        rb12 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-ellipse-50.png", 11, true, "Draw an Ellipse");
        rb13 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-polygon-50.png", 12, false, "Draw a Regular Polygon");
        rb14 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-star-50.png", 13, false, "Draw a Star");
        rb15 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-erase-30.png", 14, false, "Erase");
        rb16 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-select-none-60.png", 15, false, "Select Area"); //makes bimg
        rb17 = make16("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-checkmark-48.png", 16, false, "Finalize Movement"); // finalize/checkmark?
        rb18 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-paste-60.png", 17, false, "Paste Selected");// paste img at selected prev x and y click icon then where wanted
        rb19 = make("file:C:\\Users\\garre\\Desktop\\CS250\\Paint\\src\\main\\resources\\icons8-move-60.png", 18, false, "Move Selected"); //erase orig, move somewhere

        disp.add(rb1, 0, 0, 1, 1);  // line
        disp.add(rb2, 1, 0, 1, 1);  // free
        disp.add(rb3, 0, 8, 1, 1);  // text
        disp.add(rb4, 1, 8, 1, 1);  // dropper
        disp.add(rb5, 0, 7, 1, 1);  // square f
        disp.add(rb6, 0, 3, 1, 1);  // rect f
        disp.add(rb7, 0, 4, 1, 1);  // circ f
        disp.add(rb8, 0, 5, 1, 1);  // elli f
        disp.add(rb9, 1, 7, 1, 1);  // square
        disp.add(rb10, 1, 3, 1, 1);  // rect
        disp.add(rb11, 1, 4, 1, 1);  // circ
        disp.add(rb12, 1, 5, 1, 1);  // elli
        disp.add(rb13, 0, 6, 1, 1); // reg
        disp.add(rb14, 1, 6, 1, 1); // star
        disp.add(rb15, 0, 1, 1, 1); // erase
        disp.add(rb16, 1, 2, 1, 1); // select
        disp.add(rb17, 0, 9, 1, 1); // pix
        disp.add(rb18, 0, 2, 1, 1); // paste
        disp.add(rb19, 1, 1, 1, 1); // move

        past = rb1;
        return disp;
    }

    /**
     * styles each button with the desired icon and calls the functionality setup
     * @param imageStream image url to be added
     * @param iter draw type
     * @param fill filled/unfilled shape
     * @return returns the instantiated button with all params and functions set up
     */

    private Button make(String imageStream, int iter, boolean fill, String toolT) //functions and icon addition
    {
        Image img = new Image(imageStream);
        ImageView viw = new ImageView(img);
        viw.setPreserveRatio(true);
        viw.setFitWidth(40);
        Button temp;
        if(img == null) {
            temp = new Button("Button");
        }
        else
        {
            temp = new Button();
            temp.setGraphic(viw);
        }
        temp.setOnAction(event -> actionB(temp, iter, fill));
        temp.setTooltip(new Tooltip(toolT));
        return temp;
    }

    private Button make16(String imageStream, int iter, boolean fill, String toolT) //functions and icon addition
    {
        Image img = new Image(imageStream);
        ImageView viw = new ImageView(img);
        viw.setPreserveRatio(true);
        viw.setFitWidth(40);
        Button temp;
        if(img == null) {
            temp = new Button("Button");
        }
        else
        {
            temp = new Button();
            temp.setGraphic(viw);
        }
        temp.setDisable(true);
        temp.setOnAction(event -> actionA(temp));
        temp.setTooltip(new Tooltip(toolT));
        prefs.setRb17(temp);
        return temp;
    }

    private void actionA(Button temp)
    {
        prefs.getDrawPane().getDraw().getNums().setMoving(false);
        temp.setDisable(true);
    }

    /**
     * sets each attribute changed in the preferences when pressed
     * @param temp temp button for uniformity
     * @param iter drawtype variable
     * @param fill filled/unfilled shape
     */

    private void actionB(Button temp, int iter, boolean fill) // chosen button highlight
    {
        past.setDisable(false);
        temp.setDisable(true);
        past = temp;
        prefs.setDrawType(iter+1);
        prefs.setFilled(fill);
    }
}
