package sample;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML private TextArea messageFieldEnd2;
    @FXML private TextArea messageFieldEnd1;
    @FXML private Button clearButton;
    @FXML private Button verifyButton;
    @FXML private AnchorPane anchorid;
    @FXML private Button sendButton;

    RSA RSA = new RSA();

    public void sendAction()
            throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

        String message = messageFieldEnd1.getText();
        RSA.generateKeys();
        RSA.getSignature(message);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Message have been sent, you can now try and verify it");

        alert.showAndWait();
    }

    public void verifyAction() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String message = messageFieldEnd2.getText();

        if (RSA.getVerified(message, RSA.signature)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("The signature is verified.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("The signature is not verified");
            alert.setContentText("Please try sending a message and verify it again.");
            alert.showAndWait();
        }
    }

    public void clearAction() {
        messageFieldEnd1.clear();
        messageFieldEnd2.clear();
    }

    @FXML
    void initialize() {
        assert messageFieldEnd2 != null : "fx:id=\"messageFieldEnd2\" was not injected: check your FXML file 'sample.fxml'.";
        assert messageFieldEnd1 != null : "fx:id=\"messageFieldEnd1\" was not injected: check your FXML file 'sample.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert verifyButton != null : "fx:id=\"verifyButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert anchorid != null : "fx:id=\"anchorid\" was not injected: check your FXML file 'sample.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'sample.fxml'.";
    }
}
