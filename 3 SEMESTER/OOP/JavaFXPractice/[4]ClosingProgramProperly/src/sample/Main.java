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
        window.setTitle("JavaFX");
        button = new Button("Close program");

        //calling close method so when window is closed then method is called
        //basically either way if it has been exited with X or exit button progress will be saved

        window.setOnCloseRequest(e -> {
            e.consume(); //making program not close program "forcefully"
            closeProgram();
        });

        button.setOnAction(e -> closeProgram());


        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        window.setScene(new Scene(layout, 300, 275));
        window.show();
    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Title", "Sure you want to exti?");
        if(answer)
            window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
