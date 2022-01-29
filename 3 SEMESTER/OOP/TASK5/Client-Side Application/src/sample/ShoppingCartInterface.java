package sample;

import java.sql.SQLException;

public interface ShoppingCartInterface {
    double getFinalPrice();
    double getFinalFirstOrderDiscountPrice();
    double getFinalPriceVAT();
    double getFinalDiscountPriceVAT();
    void calculateFinalPrice();
    void calculateFinalFirstOrderDiscountPrice();
}