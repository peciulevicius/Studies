package sample;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Dish extends ShoppingCart {

    private StringProperty dishName;
    private StringProperty dishDescription;
    private SimpleObjectProperty picture;
    private DoubleProperty dishPrice;
    private static double VAT = 1.21;

    public Dish() {
        this(null, null, 0.0, null);
    }

    public Dish(String dishName, String dishDescription, Double dishPrice, Object picture) {
        this.dishName = new SimpleStringProperty(dishName) ;
        this.dishDescription = new SimpleStringProperty(dishDescription);
        this.dishPrice = new SimpleDoubleProperty(dishPrice);
        this.picture = new SimpleObjectProperty(picture);

    }

    public String getDishName() {
        return dishName.get();
    }

    public StringProperty dishNameProperty() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName.set(dishName);
    }

    public String getDishDescription() {
        return dishDescription.get();
    }

    public StringProperty dishDescriptionProperty() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription.set(dishDescription);
    }

    public Image getPicture() {
        return (Image) picture.get();
    }

    public ObjectProperty pictureProperty() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture.set(picture);
    }

    public double getDishPrice() {
        return dishPrice.get();
    }

    public DoubleProperty dishPriceProperty() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice.set(dishPrice);
    }

    public static double getVAT() {
        return VAT;
    }
}