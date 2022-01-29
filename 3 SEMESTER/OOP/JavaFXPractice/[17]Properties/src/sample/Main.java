package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setTitle("Properties");

        Person bucky = new Person();

        //called when given/changes name (value)
        bucky.firstNameProperty().addListener( (v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty: " + bucky.firstNameProperty());
            System.out.println("getFirstName: " + bucky.getFirstName());
        } );


        button = new Button("Submit");
        button.setOnAction(e -> bucky.setFirstName("Porky"));


        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
