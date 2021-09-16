package Paint.setup;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class img {


    private Menu remove;
    private float totalWidth = 700;
    private final float width = 900; //Class vars for height + width
    private final float height = 700;
    private final Text fileextension = new Text(" "); //Text for exception handling
    private final VBox root = new VBox(); //Vbox addressable by multiple functions
    private final HBox picdisplay = new HBox(); //HBox for picture display


     public void findimg(Stage stage) //Opens a file explorer to find an image
    {
        FileChooser openfile = new FileChooser(); //Creates instance of file explorer
        openfile.setTitle("Open Image");
        File filename = openfile.showOpenDialog(stage); //Records the file to be opened
        new img().openimg(filename, stage); //Calling openimg() to open the file
    }


    public void openimg(File filename, Stage stage) //Opens file found in findimg()
    {
        try{ //Checking if the image is an accepted format
            String extension = Files.probeContentType(filename.toPath());
            if(extension.equals("image/jpeg") || extension.equals("image/png"))
            {
                InputStream stream = new FileInputStream(filename);
                Image image = new Image(stream); //instantiating image from file name
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                if(image.getWidth() > image.getHeight()) //Attempt to fix oversized image
                {imageView.setFitWidth(width*0.45);}
                else
                {imageView.setFitHeight(height*0.45);}
                imageView.setPreserveRatio(true); //Preserve the original aspect ratio
                picdisplay.getChildren().add(imageView); //Adding image to Vbox to display
//                System.out.print(image.getWidth()); //Attempt to fix oversized image
//                System.out.print(image.getHeight());
                double widthUsed = image.getWidth();
                float f = (float) widthUsed;
                totalWidth = (totalWidth + f);
//                switch (numimages)
//                {
//                    case 0:
//                        image1.setText("filename");
//                        image1.setDisable(false);
//                        break;
//                    case 1:
//                        image2.setText("filename");
//                        image2.setDisable(false);
//                        break;
//                    case 2:
//                        image3.setText("filename");
//                        image3.setDisable(false);
//                        break;
//                    case 3:
//                        image4.setText("filename");
//                        image4.setDisable(false);
//                    default:
//                        fileextension.setText("No More Images Left to Delete");
//                        fileextension.setFont(Font.font(15));;
//                        break;
//                }
////                window.setWidth(totalWidth);
////                picdisplay.getScene().getWindow().sizeToScene();
////                window.sizeToScene();
            }
            else
            {   //Case if unaccepted format
                fileextension.setText("File Type Not Supported");
                fileextension.setFont(Font.font(15));

//                fileextension.setText(extension); //Used for file extension checking
//                System.out.print(extension);
            }
        }
        catch (IOException e) //Case if format checking fails
        {
            fileextension.setText("File Extension not Recognized");
        }
    }
}
