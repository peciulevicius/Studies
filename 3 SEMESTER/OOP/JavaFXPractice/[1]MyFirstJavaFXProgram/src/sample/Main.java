package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    Button button;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TITLE OF THE WINDOW");
        button = new Button();
        button.setText("Click me");

        button.setOnAction(e -> System.out.println("Hey now brown cow")); //mmakes buttons easy
        //e - parameter
        //everything else that needs to be printed goes to the right

        /*
        button.setOnAction(e -> {
                System.out.println("Hey now brown cow");
                System.out.println("Heelooouu");
        });
        */


        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.setScene(new Scene(root, 300, 250));
        //primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
