package sample;

import javafx.scene.image.Image;

import java.io.*;
import java.sql.*;

public class Driver {

    public static void ConnectionDB() {
        Connection conn = null;
        Statement stmt = null;
        FileInputStream fis;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:dish.db");
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Dish");

            while (rs.next()) {
                Dish newDish = new Dish();
                newDish.setDishName(rs.getString("dish_name"));
                newDish.setDishDescription(rs.getString("dish_description"));
                newDish.setDishPrice(rs.getDouble("dish_price"));

                InputStream input = rs.getBinaryStream("dish_picture");
                InputStreamReader inputReader = new InputStreamReader(input);
                if(inputReader.ready())
                {
                    File tempFile = new File("tempFile.jpg");

                    FileOutputStream fos = new FileOutputStream(tempFile);
                    byte[] buffer = new byte[1024];
                    while(input.read(buffer) > 0){
                        fos.write(buffer);
                    }
                    Image image = new Image(tempFile.toURI().toURL().toString());
                    newDish.setPicture(image);
                }
                MenuController.dishList.add(newDish);
                //MenuController.dishList.add(new Dish(dishName, dishDescription, dishPrice, picture));
            }
            rs.close();
            stmt.close();
            conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on building data");
                System.exit(0);
            }
        System.out.println("DB OK");
    }
}