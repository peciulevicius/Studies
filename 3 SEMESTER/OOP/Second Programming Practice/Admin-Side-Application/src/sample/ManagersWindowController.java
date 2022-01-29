package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ManagersWindowController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button ordersWindowButton;
    @FXML private Button deleteButton;
    @FXML private Button managersButtonClicked;
    @FXML private Button usersWindowButton;
    @FXML private Button itemsWindowButton;
    @FXML private TextField adminCodeField;
    @FXML private PasswordField adminPasswordField;
    @FXML private Button addManagerButton;
    @FXML private TableView<Admin> managersTable;
    @FXML private TableColumn<Admin, String> managersColumn;

    public static ObservableList<Admin> managerData= FXCollections.observableArrayList();
    public static ObservableList<Admin> getManagerData() {
        return managerData;
    }

    @FXML
    private void initialize() {
        managersColumn.setCellValueFactory(cellData->cellData.getValue().admin_codeProperty());

        managersTable.setItems(getManagerData());
    }

    @FXML
    void addManagerAction(ActionEvent event) {
        Connection connection = Driver.getConnection();
        try {
            if (adminCodeField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Admin code field is empty");
                alert.setContentText("Please fill code field and try again!");
                alert.showAndWait();
                return;
            }
            if (adminPasswordField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Password field is empty");
                alert.setContentText("Please fill password field and try again!");
                alert.showAndWait();
                return;
            }

            String admin_code = adminCodeField.getText();
            String password = adminPasswordField.getText();

            String sql = "INSERT INTO Admins (admin_code, password) VALUES(?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin_code);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Admin added successfully!");
            alert.setHeaderText(null);
            alert.setContentText("Admin has been successfully added to database!");
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

        @FXML
    void deleteManagerAction(ActionEvent event) {
        Admin selectedAdmin = managersTable.getSelectionModel().getSelectedItem();
        Connection connection;
        Statement statement;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db");
            statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Admins WHERE admin_code = ?");
            preparedStatement.setString(1, selectedAdmin.getAdmin_code());
            managersTable.getItems().remove(selectedAdmin);
            preparedStatement.execute();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openUsersWindowAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent home_page_parent =  FXMLLoader.load(getClass().getResource("usersWindow.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    void openOrdersWindowAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent home_page_parent =  FXMLLoader.load(getClass().getResource("ordersWindow.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    void openItemsWindowAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent home_page_parent =  FXMLLoader.load(getClass().getResource("itemsWindow.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}