package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {
//passing 2 parameters (title and message to display to a user)
    public static void display(String title, String message){
        Stage window = new Stage();

        //adding no use of background windows functionality till this window is open
        window.initModality(Modality.APPLICATION_MODAL);
        //setting passed in title
        window.setTitle(title);
        //minimum width for window
        window.setMinWidth(250);

        //text for a window
        Label label = new Label();
        //setting text whatever message was passed in
        label.setText(message);
        //Adding close button after the text
        Button closeButton = new Button("Close the window");
        //Functionality
        closeButton.setOnAction(e -> window.close());

        //layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        //aligning all buttons and text
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // making it show and wait for input/closed to go back
    }
}
