import BackEnd.Group;
import BackEnd.Student;
import BackEnd.Subject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        Parent welcomeWindow = FXMLLoader.load(getClass().getResource("Controllers/WelcomeSample.fxml"));
        window.setTitle("Academic data");

        window.setScene(new Scene(welcomeWindow, 600, 420));
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
