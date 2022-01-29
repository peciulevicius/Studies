package sample;

import javafx.beans.property.*;

public class Item extends ShoppingCart {
    private StringProperty itemName;
    private StringProperty itemDescription;
    private SimpleObjectProperty itemImage;
    private DoubleProperty itemPrice;
    private IntegerProperty itemInventory;
    private static double VAT = 1.21;


    public Item() {
        this(null, null, 0.0,0,null);
    }

    public Item(String itemName, String itemDescription, Double itemPrice, Integer itemInventory, Object itemImage) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.itemPrice = new SimpleDoubleProperty(itemPrice);
        this.itemInventory = new SimpleIntegerProperty(itemInventory);
        this.itemImage = new SimpleObjectProperty(itemImage);

    }

    public String getItemName() {
        return itemName.get();
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getItemDescription() {
        return itemDescription.get();
    }

    public StringProperty itemDescriptionProperty() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription.set(itemDescription);
    }

    public Object getItemImage() {
        return itemImage.get();
    }

    public SimpleObjectProperty itemImageProperty() {
        return itemImage;
    }

    public void setItemImage(Object itemImage) {
        this.itemImage.set(itemImage);
    }

    public double getItemPrice() {
        return itemPrice.get();
    }

    public DoubleProperty itemPriceProperty() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice.set(itemPrice);
    }

    public static double getVAT() {
        return VAT;
    }

    public int getItemInventory() {
        return itemInventory.get();
    }

    public IntegerProperty itemInventoryProperty() {
        return itemInventory;
    }

    public void setItemInventory(int itemInventory) {
        this.itemInventory.set(itemInventory);
    }

    public static void setVAT(double VAT) {
        Item.VAT = VAT;
    }
}
