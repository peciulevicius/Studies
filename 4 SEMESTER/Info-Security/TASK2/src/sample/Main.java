package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent encryptWindow = FXMLLoader.load(getClass().getResource("encrypt.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        window.setScene(new Scene(encryptWindow));
        window.setResizable(true);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
