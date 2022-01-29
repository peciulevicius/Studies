package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Decrypt {

    @FXML private TextArea outputArea;
    @FXML private TextField keyInputField;

    public void decryptAction(javafx.event.ActionEvent event) {

        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection
                    ("jdbc:sqlite:D:\\MY FILES\\Studies\\4 SEMESTER\\Information-Security\\TASK2\\src\\sample\\Data.db");

            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "SELECT cipherText FROM Data WHERE yourSecretKey = '" + keyInputField.getText() + "'";
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while ( rs.next() ) {
                String  text = rs.getString("cipherText");

                String decrypted = AES.decryption(text,keyInputField.getText());
                outputArea.appendText(decrypted+"\n");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void openEncryptWindow(javafx.event.ActionEvent event) throws IOException {
        Parent encryptWindow =  FXMLLoader.load(getClass().getResource("encrypt.fxml"));
        Scene encryptWindow_scene = new Scene(encryptWindow);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(encryptWindow_scene);
        app_stage.show();
    }
}
