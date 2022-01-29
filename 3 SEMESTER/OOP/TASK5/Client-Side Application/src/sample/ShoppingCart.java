package sample;

import javafx.beans.property.*;

import java.util.ArrayList;

public class ShoppingCart implements ShoppingCartInterface{

    private StringProperty itemName;
    private StringProperty itemDescription;
    private ObjectProperty picture;
    private DoubleProperty price;
    private double PriceVAT;
    private IntegerProperty quantity;
    private double total;
    private int myFirstOrderDiscount = 10;
    private int happy2020discount = 20;
    private ArrayList<Item> shoppingCartArray = new ArrayList<>();

    public ShoppingCart(){
        this(null,null,0,0);
    }


    public ShoppingCart(String itemName,String itemDescription,double price, int quantity){
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        /*try {
            this.picture = new FileInputStream(String.valueOf(picture));
        } catch (FileNotFoundException e) {
            System.out.println("This method of picture doesn't work");
        }
        */
    }

    public ArrayList<Item> getShoppingCartArray(){
        return shoppingCartArray;
    }

    public void setShoppingCartArray(Item item) {
        shoppingCartArray.add(item);
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getFinalPrice() {
        calculateFinalPrice();
        return total;
    }

    public double getFinalFirstOrderDiscountPrice() {
        calculateFinalFirstOrderDiscountPrice();
        return total;
    }

    public double getFinalPriceVAT() {
        return PriceVAT;
    }

    public double getFinalDiscountPriceVAT() {
        calculateFinalFirstOrderDiscountPrice();
        return PriceVAT;
    }

    public void calculateFinalPrice() {
        total = 0;
        for(int i = 0; i < getShoppingCartArray().size(); i++){
            total += getShoppingCartArray().get(i).getItemPrice();
        }
        //with VAT
        PriceVAT = total * Item.getVAT();
    }

    public void calculateFinalFirstOrderDiscountPrice() {
        total = 0;
        for(int i = 0; i < getShoppingCartArray().size(); i++){
            total += getShoppingCartArray().get(i).getItemPrice();
        }
        //with VAT
        PriceVAT = total * Item.getVAT() - myFirstOrderDiscount;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }
}