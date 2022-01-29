package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Combo box");
        button = new Button("Submit");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Movie 1",
                    "Movie 2",
                    "Movie 3"
        );

        comboBox.setPromptText("What is your favorite movie?");

        //making a choice editable (not mandatory)
        comboBox.setEditable(true);

        button.setOnAction(e -> printMovie());

        //SELECTING MOVIE WHILE ITS NOT ACCEPTED
        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        window.setScene(new Scene(layout, 300, 250));
        window.show();
    }

    //Print out a movie
    private void printMovie(){
        System.out.println(comboBox.getValue());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
