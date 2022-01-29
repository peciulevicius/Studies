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
        window.setTitle("Hello World");

        button = new Button("Click Me!");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of window", "Are you sure you want to do this?");
            System.out.println(result);
        });

        //layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setScene(new Scene(layout, 300, 250));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
