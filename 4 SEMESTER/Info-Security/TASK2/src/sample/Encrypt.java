package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Encrypt {

    @FXML private TextArea outputArea;
    @FXML private TextArea plainText;
    @FXML private TextField keyField;

    public void encryptAction(javafx.event.ActionEvent event) {

        String text = plainText.getText();
        String secretKey = keyField.getText();
        String encrypted = AES.encryption(text, secretKey);
        outputArea.setText(encrypted);

        try{
            Connection conn = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection
                    ("jdbc:sqlite:D:\\MY FILES\\Studies\\4 SEMESTER\\Information-Security\\TASK2\\src\\sample\\Data.db");
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Data (cipherText, yourSecretKey) VALUES('" +encrypted+ "', '" + secretKey + "')");
            conn.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void openDecryptWindow(javafx.event.ActionEvent event) throws IOException {
        Parent decryptWindow =  FXMLLoader.load(getClass().getResource("decrypt.fxml"));
        Scene decryptWindow_scene = new Scene(decryptWindow);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(decryptWindow_scene);
        app_stage.show();
    }
}
