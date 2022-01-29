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

public class ItemsWindowController {

    @FXML private TableView<Item> itemTable;
    @FXML private TableColumn<Item, String> itemPriceColumn;
    @FXML private TableColumn<Item, String> itemInventoryColumn;
    @FXML private TableColumn<Item, String> itemNameColumn;
    @FXML private TableColumn<Item, String> itemDescriptionColumn;
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button ordersWindowButton;
    @FXML private Button managersButtonClicked;
    @FXML private Button deleteButton;
    @FXML private Button usersWindowButton;
    @FXML private Button itemsButtonClicked;
    @FXML private Button managersWindowButton;
    @FXML private Button editItemButton;
    @FXML private Button addItemButton;

    public static ObservableList<Item> itemData= FXCollections.observableArrayList();
    public static ObservableList<Item> getItemData() {
        return itemData;
    }


    @FXML
    private void initialize() {

        itemNameColumn.setCellValueFactory(cellData ->cellData.getValue().item_nameProperty());
        itemPriceColumn.setCellValueFactory(cellData -> cellData.getValue().item_priceProperty().asString());
        itemDescriptionColumn.setCellValueFactory(cellData ->cellData.getValue().item_descriptionProperty());
        itemInventoryColumn.setCellValueFactory(cellData ->cellData.getValue().item_inventoryProperty().asString());

        itemTable.setItems(getItemData());
    }


    @FXML
    void deleteItemAction(ActionEvent event) {
        Item selectedItem = itemTable.getSelectionModel().getSelectedItem();
        itemTable.getItems().remove(selectedItem);

        Connection conn;
        Statement stmt = null;
        PreparedStatement ps = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps=conn.prepareStatement("DELETE FROM Item where item_name ='"+selectedItem.getItem_name()+"'");
            ps.execute();
            conn.commit();
            conn.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        System.out.println("Item deleted successfully");
    }

    @FXML
    void editItemAction(ActionEvent event) {

    }

    @FXML
    void addItemAction(ActionEvent event) {

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
    void openOrdersWindowAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent home_page_parent =  FXMLLoader.load(getClass().getResource("ordersWindow.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}