import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="clientButton"
    private Button clientButton; // Value injected by FXMLLoader
    @FXML // fx:id="adminButton"
    private Button adminButton; // Value injected by FXMLLoader

    @FXML
    void redirectToAdminLogin(ActionEvent event) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
            Stage adminStage = new Stage();
            adminStage.initModality(Modality.APPLICATION_MODAL);

            adminStage.setScene(new Scene(root));
            adminStage.setResizable(true);
            adminStage.show();

            // Hide this current window (if this is what you want)
            // ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void redirectToClientLogin(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("clientLogin.fxml"));
            Stage adminStage = new Stage();
            adminStage.initModality(Modality.APPLICATION_MODAL);

            adminStage.setScene(new Scene(root));
            adminStage.setResizable(true);
            adminStage.show();

            // Hide this current window (if this is what you want)
            // ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert clientButton != null : "fx:id=\"clientButton\" was not injected: check your FXML file 'home.fxml'.";
        assert adminButton != null : "fx:id=\"adminButton\" was not injected: check your FXML file 'home.fxml'.";
    }
}