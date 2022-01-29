package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("JavaFX");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); //Insets are padding for each edge
        grid.setVgap(8); //setting vertical spacing (padding)
        grid.setHgap(8); //setting horizontal spacing (padding)


        //Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("username"); //GREY INDICATOR LIKE IN HTML
        GridPane.setConstraints(nameInput, 1, 0);

        //Password label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        window.setScene(new Scene(grid, 300, 200));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
