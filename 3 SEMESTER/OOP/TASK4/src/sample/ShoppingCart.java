package sample;

import javafx.beans.property.*;

import java.util.ArrayList;

public class ShoppingCart {

    private StringProperty dishName;
    private StringProperty dishDescription;
    private ObjectProperty picture;
    private double price;
    private double PriceVAT;
    private ArrayList<Dish> shoppingCartArray = new ArrayList<>();

    public ShoppingCart(String dishName, String dishDescription, double dishPrice) {
    }

    public ShoppingCart() {
        this(null, null,0.0);
    }

//    public ShoppingCart(String dishName, String dishDescription, Object picture, Double dishPrice) {
//        this.dishName = new SimpleStringProperty(dishName);
//        this.dishDescription = new SimpleStringProperty(dishDescription);
//        this.picture = new SimpleObjectProperty(picture);
//        this.dishPrice = new SimpleDoubleProperty(dishPrice);
//        //this.total = total;
//        //this.shoppingCartArray = shoppingCartArray;
//    }

    public ArrayList<Dish> getShoppingCartArray(){
        return shoppingCartArray;
    }

    public void setShoppingCartArray(Dish dish) {
        shoppingCartArray.add(dish);
    }

    public StringProperty dishNameProperty() {
        return dishName;
    }

    public double getFinalPrice() {
        calculateFinalPrice();
        return price;
    }

    public double getFinalPriceVAT() {
        return PriceVAT;
    }

    private void calculateFinalPrice() {
        price = 0;
        for(int i = 0; i < getShoppingCartArray().size(); i++){
            price += getShoppingCartArray().get(i).getDishPrice();
        }
        //with VAT
        PriceVAT = price * Dish.getVAT();
    }
}