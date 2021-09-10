package com.example.paint;
//JPG PNG
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Paint extends Application {
    @Override
    public void start(Stage menu) throws IOException {
        GridPane optionsPane = new GridPane();
        Scene scene = new Scene(optionsPane);
        menu.setTitle("Hello!");
        menu.setScene(scene);
        menu.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}