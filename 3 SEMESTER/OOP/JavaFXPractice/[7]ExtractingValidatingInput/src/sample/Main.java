package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Extract & Validate input");

        //FORM
        TextField nameInput = new TextField();
        button = new Button("CLick Me!");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()) );

        //LAYOUT
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20, 20));
        layout.getChildren().addAll(nameInput, button);

        window.setScene(new Scene(layout, 300, 250));
        window.show();
    }

    private boolean isInt(TextField input, String message) {
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            return false;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
