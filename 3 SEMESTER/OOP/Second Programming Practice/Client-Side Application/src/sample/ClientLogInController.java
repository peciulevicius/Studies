package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClientLogInController implements Initializable {

    @FXML private PasswordField login_password;
    @FXML private TextField login_username;

        public static ObservableList<User> userData = FXCollections.observableArrayList();


    @FXML
    private void login(ActionEvent event) throws SQLException, IOException {
        //checks if provided credentials exist in the database
        if(detailValidation(login_username.getText(), login_password.getText())){
            Parent appWindow = FXMLLoader.load(getClass().getResource("clientApp.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);

            window.setScene(new Scene(appWindow));
            window.setResizable(true);
            window.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect information");
            alert.setContentText("Check your details and try again");
            alert.showAndWait();
        }
    }

    public boolean detailValidation(String username, String password) throws SQLException {
        Connection conn = null;
        boolean valid = false;

        try {
            String url = "jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db";
            conn = DriverManager.getConnection(url);
            String sql = "SELECT username, password FROM users WHERE username = '" + username + "'" + "AND password= " + "'" + password + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("Wrong username or password");
            } else {
                userData.add(new User());
                valid = true;
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } finally {
            if (conn.isClosed() == false) {
                conn.close();
            }
        }
//        userData.add(new User());
        return valid;
    }


    @FXML
    private void signup() throws IOException {
        try {
            Parent signupWindow = FXMLLoader.load(getClass().getResource("clientSignUp.fxml"));
            Stage window = new Stage();
            //Node node = (Node) event.getSource();
            window.initModality(Modality.APPLICATION_MODAL);
            //Stage stage = (Stage) node.getScene().getWindow();
            window.setScene(new Scene(signupWindow));
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