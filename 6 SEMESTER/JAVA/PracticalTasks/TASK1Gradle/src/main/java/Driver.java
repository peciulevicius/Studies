import java.sql.*;

public class Driver {

    public static Connection connection() {
        String connect_string = "jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db";
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

    public static Connection getConnection() {
        String connect_string = "jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db";
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

    public static void showOrders(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rst = stmt.executeQuery( "SELECT * FROM Orders;" );

            while ( rst.next() ) {

                String first_name = rst.getString("first_name");
                String last_name = rst.getString("last_name");
                String country = rst.getString("country");
                String city = rst.getString("city");
                String address = rst.getString("address");
                String apartment = rst.getString("apartment");
                String postal_code = rst.getString("postal_code");
                String item_name = rst.getString("items_name");

                OrdersWindowController.orderData.add(new Orders(first_name, last_name,country,city, address, apartment, postal_code, item_name));
            }
            rst.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public static void showItems(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rst = stmt.executeQuery( "SELECT * FROM Item;" );

            while ( rst.next() ) {

                String item_name = rst.getString("item_name");
                String item_description = rst.getString("item_description");
                double item_price = rst.getDouble("item_price");
                int item_inventory = rst.getInt("item_inventory");


                ItemsWindowController.itemData.add(new Item(item_name,item_description,item_price, item_inventory));
            }
            rst.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public static void showAdmins(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db");
            c.setAutoCommit(false);


            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Admins;" );

            while ( rs.next() ) {

                String admin_code= rs.getString("admin_id");
                String password = rs.getString("password");

                ManagersWindowController.managerData.add(new Admin(admin_code,password))  ;
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void showUsers(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:D:\\MY FILES\\Studies\\6 SEMESTER\\JAVA\\PracticalTasks\\TASK1Gradle\\data.db");
            c.setAutoCommit(false);


            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Users;" );

            while ( rs.next() ) {

                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");

                ManagersWindowController.managerData.add(new Client(username,email,password))  ;
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
