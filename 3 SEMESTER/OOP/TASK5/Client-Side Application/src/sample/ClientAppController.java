package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.security.auth.login.LoginContext;
import java.sql.*;

public class ClientAppController {

//    public ClientAppController() {
//        Driver.getConnection();
//    }

    @FXML private TableColumn<Item, String> itemListColumn;
    @FXML private TableView<Item> productTable;
    @FXML private Label usernameShow;
    @FXML private Label itemName;
    @FXML private ImageView itemPicture;
    @FXML private Label itemPrice;
    @FXML private Label itemDescription;
    @FXML private Label itemQuantity;
    @FXML private Button addToCartButton;
    @FXML private TableView<ShoppingCart> orderTable;
    @FXML private TableColumn<ShoppingCart, String> orderTableColumn;
    @FXML private Button deleteButton;
    @FXML private TextField discountCodeField;
    @FXML private Button discountCodeApplyButton;
    @FXML private Label subtotalPriceLabel;
    @FXML private Label totalPriceLabel;
    @FXML private TextField countryTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField postalCodeTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField apartmentTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private Button buyButton;
    @FXML private Label discountCodeAppliedLabel;
    @FXML private Label discountLabel;

    public static ObservableList<Item> itemList = FXCollections.observableArrayList();
    public static ObservableList<ShoppingCart> cartList = FXCollections.observableArrayList();
    public static ObservableList<Item> getItemList(){
        return itemList;
    }
    public static ObservableList<ShoppingCart> getCartList(){
        return cartList;
    }
    ShoppingCart shoppingCart = new ShoppingCart();

    @FXML
    private void initialize(){
        //display items in the tables
        itemListColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        //display selected items into the orders table
        orderTableColumn.setCellValueFactory(celLData -> celLData.getValue().itemNameProperty());


        showItems(null);
        showShoppingCart(null);

        productTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> showItems(newValue));
        productTable.setItems(getItemList());


        orderTable.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue)-> showShoppingCart(newValue));
        orderTable.setItems(getCartList());
        //This caused for prices to show 0.00 euros
    }

    private void showItems(Item item){
        if(item != null) {
            itemPicture.setImage((Image) item.getItemImage());
            itemName.setText(item.getItemName());
            itemDescription.setText(item.getItemDescription());
            itemPrice.setText(Double.toString(item.getItemPrice()));
            itemQuantity.setText(Integer.toString(item.getItemInventory()));
        } else {
            itemName.setText("---");
            itemDescription.setText("---");
            itemPrice.setText("---");
            itemQuantity.setText("---");
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
    void addToCartAction(ActionEvent event) {
        Item selection = productTable.getSelectionModel().getSelectedItem();
        if (selection != null) {
            int inventory = selection.getItemInventory() -1;
            selection.setItemInventory(inventory);
            //orderTable.getItems().add(new ShoppingCart(selection.getItemName(), selection.getItemDescription(),

            Connection conn;
            Statement stmt = null;
            PreparedStatement ps = null;

            try{
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db");
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                ps=conn.prepareStatement("UPDATE Item set item_inventory ='"+selection.getItemInventory()+"' where item_name ='"+selection.getItemName()+"'");
                ps.execute();
                conn.commit();
                shoppingCart.setShoppingCartArray(selection);
                orderTable.getItems().add(new ShoppingCart(selection.getItemName(), selection.getItemDescription(), selection.getItemPrice(), selection.getItemInventory()));
                conn.close();
            System.out.println("Item added successfully");
            }catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );

            }
        }
        setPrice();
    }

    @FXML
    void deleteItemAction(ActionEvent event) {
        ShoppingCart selection = orderTable.getSelectionModel().getSelectedItem();
        if (selection != null) {
            int inventory= selection.getQuantity() +1;
            selection.setQuantity(inventory);

            Connection conn;
            Statement stmt = null;
            PreparedStatement ps =null;
            try{
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db");
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                ps=conn.prepareStatement("UPDATE Item set item_inventory ='"+selection.getQuantity()+"' where item_name ='"+selection.getItemName()+"'");
                ps.execute();
                conn.commit();
                conn.close();
                //removes selected item from the order list
                shoppingCart.getShoppingCartArray().remove(selection);
                //removes selected item from the table view
                orderTable.getItems().remove(selection);
            }catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );

            }
            System.out.println("Item deleted successfully");
        }
        setPrice();
    }

    @FXML
    void buyButtonAction(ActionEvent event) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Connection connection = Driver.addToOrder();

        if (lastNameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Last name field is empty");
            alert.setContentText("Please fill last name field and try again!");
            alert.showAndWait();
            return;
        }
        if (addressTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Address field is empty");
            alert.setContentText("Please fill address field and try again!");
            alert.showAndWait();
            return;
        }
        if (countryTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Country field is empty");
            alert.setContentText("Please fill country field and try again!");
            alert.showAndWait();
            return;
        }
        if (postalCodeTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Postal code field is empty");
            alert.setContentText("Please fill postal code field and try again!");
            alert.showAndWait();
            return;
        }
        if (cityTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("City field is empty");
            alert.setContentText("Please fill city field and try again!");
            alert.showAndWait();
            return;
        }

        String first_name = firstNameTextField.getText();
        String last_name = lastNameTextField.getText();
        String country = countryTextField.getText();
        String city = cityTextField.getText();
        String address = addressTextField.getText();
        String apartment = apartmentTextField.getText();
        String postal_code = postalCodeTextField.getText();
//        String item = cartList.get(0).getItemName();

        for (int i = 0; i < cartList.size(); i++) {
            String sql = "INSERT INTO Orders (first_name, last_name, country, city, address, apartment, postal_code, item_name)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, first_name);
                preparedStatement.setString(2, last_name);
                preparedStatement.setString(3, country);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, address);
                preparedStatement.setString(6, apartment);
                preparedStatement.setString(7, postal_code);
                preparedStatement.setString(8, cartList.get(i).getItemName());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order successful!");
        alert.setHeaderText(null);
        alert.setContentText("You have ordered successfully and now all you need to do is wait!");
        alert.showAndWait();
    }

    @FXML
    void discountCodeApplyAction(ActionEvent event) throws SQLException {
        if (discountCodeValidation(discountCodeField.getText())){

            discountCodeAppliedLabel.setText("Discount code applied successfully!");

            String price = String.format("%.2f", shoppingCart.getFinalFirstOrderDiscountPrice());
            subtotalPriceLabel.setText(price);
            price = String.format("%.2f", shoppingCart.getFinalDiscountPriceVAT());
            totalPriceLabel.setText(price);


            discountLabel.setText("-10.00");
        } else {
            discountCodeAppliedLabel.setText("The discount code you entered is invalid");
        }

    }

    public boolean discountCodeValidation(String discountCode) throws SQLException {
        Connection conn = null;
        boolean valid = false;
        try {
            String url = "jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db";
            conn = DriverManager.getConnection(url);
            String sql = "SELECT discount_code, discount_price FROM Discounts WHERE discount_code = '" + discountCode + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("Wrong discount code");
            } else {
                valid = true;
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } finally {
            if (conn.isClosed() == false) {
                conn.close();
            }
        }
        return valid;
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
}