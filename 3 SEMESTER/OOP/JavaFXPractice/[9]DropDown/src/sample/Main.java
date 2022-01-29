package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Drop down");
        button = new Button("Click me");

        //DROPDOWN IS CHOICEBOX
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().addAll("Bananas", "Bacon", "Ham");

        //Sets a default value
        choiceBox.setValue("Apples");

        button.setOnAction(e -> getChoice(choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        window.setScene(new Scene(layout, 300, 250));
        window.show();
    }

    //To get the value of the selected item
    private void getChoice(ChoiceBox<String> choiceBox){
        String food = choiceBox.getValue(); //getting currently selected value
        System.out.println(food); //printing currently selected value
    }

    public static void main(String[] args) {
        launch(args);
    }
}
