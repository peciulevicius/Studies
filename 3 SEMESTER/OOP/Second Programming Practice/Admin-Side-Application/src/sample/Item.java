package sample;

import javafx.beans.property.*;

import java.io.FileInputStream;

public class Item {
    private StringProperty item_name;
    private StringProperty item_description;
    private DoubleProperty item_price;
    private IntegerProperty item_inventory;

    public Item(String item_name, String item_description, String item_price, int item_inventory){
        this(null,null,0.0,0);
    }

    public Item(String item_name,String item_description,double item_price,int item_inventory){
        this.item_name = new SimpleStringProperty(item_name);
        this.item_description= new SimpleStringProperty(item_description);
        this.item_price = new SimpleDoubleProperty(item_price);
        this.item_inventory= new SimpleIntegerProperty(item_inventory);

    }

    public String getItem_name() {
        return item_name.get();
    }

    public StringProperty item_nameProperty() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name.set(item_name);
    }

    public double getItem_price() {
        return item_price.get();
    }

    public DoubleProperty item_priceProperty() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price.set(item_price);
    }

    public String getItem_description() {
        return item_description.get();
    }

    public StringProperty item_descriptionProperty() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description.set(item_description);
    }


    public int getItem_inventory() {
        return item_inventory.get();
    }

    public IntegerProperty item_inventoryProperty() {
        return item_inventory;
    }

    public void setItem_inventory(int item_inventory) {
        this.item_inventory.set(item_inventory);
    }
}