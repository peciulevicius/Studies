package sample;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML private TableView<Dish> dishTable;
    @FXML private TableColumn<Dish, String> nameColumn;
    @FXML private ImageView foodPicture;
    @FXML private Label foodName;
    @FXML private Label foodPrice;
    @FXML private Label dishDescription;
    @FXML private TableView<ShoppingCart> orderTable;
    @FXML private TableColumn<ShoppingCart, String> orderColumn;
    @FXML private Button addDishToCart;
    @FXML private Label subtotalPriceLabel;
    @FXML private Label totalPriceLabel;
    @FXML private Button buyButton;
    @FXML private Button deleteButton;

    ShoppingCart shoppingCart = new ShoppingCart();

    public static ObservableList<Dish> dishList = FXCollections.observableArrayList();
    public static ObservableList<Dish> cartList = FXCollections.observableArrayList();
    public static ObservableList<Dish> getDishList(){
        return dishList;
    }

    public static ObservableList<Dish> getCartList(){
        return cartList;
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().dishNameProperty());
        orderColumn.setCellValueFactory(celLData -> celLData.getValue().dishNameProperty());

        showDishes(null);
        showShoppingCart(null);

        dishTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> showDishes(newValue));
//        orderTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue)-> showShoppingCart(newValue));
        //This caused for prices to show 0.00 euros
        dishTable.setItems(getDishList());
    }

    private void showDishes(Dish dish){
        if(dish != null) {
            foodPicture.setImage(dish.getPicture());
            foodName.setText(dish.getDishName());
            dishDescription.setText(dish.getDishDescription());
            foodPrice.setText(Double.toString(dish.getDishPrice()));
        } else {
            foodName.setText("");
            dishDescription.setText("");
            foodPrice.setText("");
        }
    }

    private void showShoppingCart(ShoppingCart shoppingCart){
        if (shoppingCart != null) {
            subtotalPriceLabel.setText(Double.toString(shoppingCart.getFinalPrice()));
            totalPriceLabel.setText(Double.toString(shoppingCart.getFinalPriceVAT()));
        } else {
            subtotalPriceLabel.setText("");
            totalPriceLabel.setText("");
        }
    }

    @FXML
    void addDishToCartAction(ActionEvent event) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("disName"));
        //get selected items
        Dish selectedItem = dishTable.getSelectionModel().getSelectedItem();
        //adds selected item to shopping cart
        shoppingCart.setShoppingCartArray(selectedItem);
        //adds selected item to the tableview
        if (selectedItem != null) {
            orderTable.getItems().add(selectedItem);
        }
        setPrice();
    }

    @FXML
    void deleteItemAction(ActionEvent event) {
        ShoppingCart selectedItem = orderTable.getSelectionModel().getSelectedItem();
        //removes selected item from the order list
        shoppingCart.getShoppingCartArray().remove(selectedItem);
        //removes selected item from the table view
        if (selectedItem != null) {
            orderTable.getItems().remove(selectedItem);
        }
        setPrice();
    }

    //function to set final price
    private void setPrice(){
        //set price labels
        //formats to string
        String price = String.format("%.2f", shoppingCart.getFinalPrice());
        subtotalPriceLabel.setText(price);
        //with VAT

        price = String.format("%.2f", shoppingCart.getFinalPriceVAT());
        totalPriceLabel.setText(price);
    }

    @FXML
    private void buyButtonAction(){

    }
}