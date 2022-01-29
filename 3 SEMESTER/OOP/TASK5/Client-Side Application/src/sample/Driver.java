package sample;

import javafx.scene.image.Image;

import java.io.*;
import java.sql.*;

public class Driver {

//    private Driver(){
//
//    }

//    public static Driver getInstance(){
//        return new Driver();
//    }

    public static void getConnection(){
        Connection conn = null;
        Statement stmt = null;
        FileInputStream fis;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db");
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Item;");

            while (rs.next()) {
                Item newItem = new Item();
                newItem.setItemName(rs.getString("item_name"));
                newItem.setItemPrice(rs.getDouble("item_price"));
                newItem.setItemDescription(rs.getString("item_description"));
                newItem.setItemInventory(rs.getInt("item_inventory"));
                InputStream input = rs.getBinaryStream("item_picture");
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
                    newItem.setItemImage(image);
                }
                ClientAppController.itemList.add(newItem);
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


    public static Connection addToOrder(){
        String connect_string = "jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db";
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connect_string);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection connection() {
        String connect_string = "jdbc:sqlite:D:\\MY FILES\\Studies\\3 SEMESTER\\Object-Oriented-Programming\\Second Programming Practice\\data.db";
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connect_string);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
