package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    //creating table<What type of data> name;
    TableView<Product> table;
    //3 Inputs
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Table View");

        //Name column (type of data in the table, and what type of data is going to be in the comlum)
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //"" has to be same as class attributes

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //"" has to be same as class attributes

        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity")); //"" has to be same as class attributes

        //----------------------------------------------------------------------------

        //Name Input field
        nameInput = new TextField();
        nameInput.setPromptText("Name"); //label in grey background
        nameInput.setMinWidth(100);

        //Price Input field
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //Quantity Input field
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        //----------------------------------------------------------------------------

        //Buttons (and actions/functionality)
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        //----------------------------------------------------------------------------

        HBox hBox = new HBox();
        //padding for the "container" (input fields padding)
        hBox.setPadding(new Insets(10, 10, 10, 10));
        //spacing items withing layout (spacing buttons)
        hBox.setSpacing(10);
        //Adding items to layout
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        //----------------------------------------------------------------------------

        //Setting up table
        table = new TableView<>();
        //What data we want to use in the table (load data)
        table.setItems(getProduct());
        //Adding columns
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        //----------------------------------------------------------------------------

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText())); //it will take a string and convert to double
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        //adding to table
        table.getItems().add(product);
        //Clearing input fields after adding
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        //get items all in the table
        allProducts = table.getItems();
        //return items selected by user
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        //We can store java objects in this list
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Keyboard", 36.99, 10));
        products.add(new Product("DVD", 29.99, 99));
        products.add(new Product("Monitor", 110.89, 51));
        return products;
    }

    public static void main(String[] args) {
        launch(args);
    }
}