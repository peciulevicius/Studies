import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class UsersWindowController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button ordersWindowButton;
    @FXML private Button managersWindowButton;
    @FXML private Button usersButtonClicked;
    @FXML private Button deleteButton;
    @FXML private Button itemsWindowButton;
    @FXML
    private TableView<Client> usersTable;
    @FXML private TableColumn<Client, String> usersColumn;
    @FXML private TableColumn<Client, String> emailColumn;

    public static ObservableList<Client> clientsData= FXCollections.observableArrayList();
    public static ObservableList<Client> getClientsData() {
        return clientsData;
    }


    @FXML
    private void initialize() {
        usersColumn.setCellValueFactory(cellData->cellData.getValue().usernameProperty());
        emailColumn.setCellValueFactory(cellData->cellData.getValue().emailProperty());

        Driver.showUsers();
        usersTable.setItems(getClientsData());
    }

    @FXML
    void openManagersWindowAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent home_page_parent =  FXMLLoader.load(getClass().getResource("managersWindow.fxml"));
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