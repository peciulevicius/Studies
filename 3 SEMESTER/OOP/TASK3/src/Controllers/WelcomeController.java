package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WelcomeController {

    @FXML
    private Button exitButton;

    @FXML
    private void startButtonAction(){
        try {
            Parent secondaryWindow = FXMLLoader.load(getClass().getResource("SecondaryScreen.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Grade system");
            window.setScene(new Scene(secondaryWindow));
            window.setResizable(true);
            window.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("CAN'T LOAD A WINDOW");
            alert.setContentText("Window you are trying to open cannot be reached at the moment!");
            alert.showAndWait();
        }
    }

    @FXML
    private void exitButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
