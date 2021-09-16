//package Paint.setup;
//
//import Paint.Paint;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.nio.file.Files;
//
//public class img {
//
//    public void findimg(Stage stage) //Opens a file explorer to find an image
//    {
//        FileChooser openfile = new FileChooser(); //Creates instance of file explorer
//        openfile.setTitle("Open Image");
//        File filename = openfile.showOpenDialog(stage); //Records the file to be opened
//        if (isIMG(filename, stage))
//        {
//            addImage(filename, stage); //Calling addImage() to open the file
//        }
//    }
//
//    public boolean isIMG(File filename, Stage stage) {
//        try {
//            String extension = Files.probeContentType(filename.toPath());
//            if (extension.equals("image/jpeg") || extension.equals("image/png")) {
//                return true;
//            } else {   //Case if unaccepted format
//                error errorMSG = new error("Image Must be of PNG or JPEG Format", stage);
//                return false;
//            }
//        } catch (IOException e) //Case if format checking fails
//        {
//            error errorMSG = new error("File Extension not Recognized", stage);
//            return false;
//        }
//    }
//}
//
//
