import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClientLogInController implements Initializable {

    @FXML private PasswordField login_password;
    @FXML private TextField login_username;

    public static ObservableList<Client> clientData = FXCollections.observableArrayList();

    @FXML
    void login(ActionEvent event) throws DetailsValidationException, SQLException {
        // check if provided credentials exist in the database
        if(detailValidation(login_username.getText(), login_password.getText())) {
            System.out.println("OPEN NEW WINDOW");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect information");
            alert.setContentText("Check your details and try again");
            alert.showAndWait();
        }
    }

    public void signup(javafx.scene.input.MouseEvent mouseEvent) {
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

    // details validation for user login [CUSTOM VALIDATION EXCEPTION used too]
    public boolean detailValidation(String username, String password) throws DetailsValidationException, SQLException {
        Connection connection = null;
        boolean valid = false;

        try {
            String url = "jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db";
            connection = DriverManager.getConnection(url);
            String sql = "SELECT username, password FROM Users WHERE username = '" + username + "'" + "AND password = " + "'" + password + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (!resultSet.next()) {
                System.out.println("Wrong username or password");
            } else {
                clientData.add(new Client());
                valid = true;
            }
        } catch (Exception exception) {
            throw new DetailsValidationException("Wrong username or password for user: ", exception);
        } finally {
            assert connection != null;
            if (!connection.isClosed()) {
                connection.close();
            }
        }
        return valid;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}