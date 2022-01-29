package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class AdminLogInController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private TextField login_adminUsername;
    @FXML private Button loginButton;
    @FXML private PasswordField login_adminPassword;

    public static ObservableList<Admin> adminData = FXCollections.observableArrayList();


    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        if (adminDetailValidation(login_adminUsername.getText(), login_adminPassword.getText())) {
            Parent appWindow = FXMLLoader.load(getClass().getResource("ordersWindow.fxml"));
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

    public boolean adminDetailValidation(String admin_code, String password) throws SQLException {
        Connection conn = null;
        boolean valid = false;

        try {
            String url = "jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db";
            conn = DriverManager.getConnection(url);
            String sql = "SELECT admin_code, password FROM Admins WHERE admin_code = '" + admin_code + "'" + "AND password= " + "'" + password + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("Wrong username or password");
            } else {
                adminData.add(new Admin());
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

}
