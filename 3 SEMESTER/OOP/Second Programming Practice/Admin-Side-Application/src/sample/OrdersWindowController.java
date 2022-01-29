package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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

public class OrdersWindowController {

    @FXML private TableView<Orders> orderTable;
    @FXML private TableColumn<Orders, String> firstNameColumn;
    @FXML private TableColumn<Orders, String> lastNameColumn;
    @FXML private TableColumn<Orders, String> countryColumn;
    @FXML private TableColumn<Orders, String> cityColumn;
    @FXML private TableColumn<Orders, String> addressColumn;
    @FXML private TableColumn<Orders, String> apartmentColumn;
    @FXML private TableColumn<Orders, String> postalCodeColumn;
    @FXML private TableColumn<Orders, String> itemsColumn;
    @FXML private Button orderButtonClicked;
    @FXML private Button managersWindowButton;
    @FXML private Button deleteButton;
    @FXML private Button usersWindowButton;
    @FXML private Button itemsWindowButton;

    public static ObservableList<Orders> orderData= FXCollections.observableArrayList();
    public static ObservableList<Orders> getOrderData() {
        return orderData;
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        countryColumn.setCellValueFactory(cellData ->cellData.getValue().countryProperty());
        cityColumn.setCellValueFactory(cellData ->cellData.getValue().cityProperty());
        addressColumn.setCellValueFactory(cellData ->cellData.getValue().addressProperty());
        apartmentColumn.setCellValueFactory(cellData ->cellData.getValue().apartmentProperty());
        postalCodeColumn.setCellValueFactory(cellData ->cellData.getValue().postalCodeProperty());
        itemsColumn.setCellValueFactory(cellData ->cellData.getValue().itemProperty());

        orderTable.setItems(getOrderData());
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
    void openItemsWindowAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent home_page_parent =  FXMLLoader.load(getClass().getResource("itemsWindow.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    void deleteOrderAction(ActionEvent event) {
        Orders selectedItem = orderTable.getSelectionModel().getSelectedItem();
        orderTable.getItems().remove(selectedItem);

        Connection conn;
        Statement stmt = null;
        PreparedStatement ps = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps=conn.prepareStatement("DELETE FROM Orders where first_name ='"+selectedItem.getFirstName()+"' and item_name='"+selectedItem.getItem()+"'");
            ps.execute();
            conn.commit();
            conn.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        System.out.println("Order deleted successfully");
    }
}