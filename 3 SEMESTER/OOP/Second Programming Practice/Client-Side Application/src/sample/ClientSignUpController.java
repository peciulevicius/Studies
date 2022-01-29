package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClientSignUpController implements Initializable {

    @FXML private TextField signup_email;
    @FXML private TextField signup_username;
    @FXML private PasswordField signup_password;
    @FXML private PasswordField signup_passwordConfirm;

      @FXML
    void signup(ActionEvent event) {
        Connection connection = Driver.connection();

        try {
            if (signup_username.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Username field is empty");
                alert.setContentText("Please fill username field and try again!");
                alert.showAndWait();
                return;
            }
            if (signup_email.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Email field is empty");
                alert.setContentText("Please fill email field and try again!");
                alert.showAndWait();
                return;
            }
            if (signup_password.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Password field is empty");
                alert.setContentText("Please fill password field and try again!");
                alert.showAndWait();
                return;
            }
            if (!(signup_passwordConfirm.getText().equals(signup_password.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Password don't match");
                alert.setContentText("Please make sure you enter matching passwords!");
                alert.showAndWait();
                return;
            }

            String username = signup_username.getText();
            String email = signup_email.getText();
            String password = signup_password.getText();

            String sql = "INSERT INTO users (username, email, password) VALUES(?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration successful!");
            alert.setHeaderText(null);
            alert.setContentText("You have registered successfully and can now login into your account!");
            alert.showAndWait();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void login() throws IOException {
        try {
            Parent loginWindow = FXMLLoader.load(getClass().getResource("clientLogin.fxml"));
            Stage window = new Stage();
            //Node node = (Node) event.getSource();
            //Stage stage = (Stage) node.getScene().getWindow();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(new Scene(loginWindow));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}