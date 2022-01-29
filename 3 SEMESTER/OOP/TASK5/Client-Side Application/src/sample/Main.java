package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//    public Main() {
//        Driver.getConnection();
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("clientLogin.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("clientApp.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Driver.getConnection();
    }


    public static void main(String[] args) {
        launch(args);
    }
}