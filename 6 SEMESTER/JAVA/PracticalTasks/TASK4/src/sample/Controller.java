package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.PlatformLoggingMXBean;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

public class Controller {

    @FXML private TextField artist_field;
    @FXML private TextField songName_field;
    @FXML private Button search;
    @FXML private Text output;
    private static final String USER_AGENT = "Mozilla/5.0";


    private void sendGET() throws IOException {
        String artist_field_string = artist_field.getText();
        String song_field_string = songName_field.getText();

        // properly encoded space should be %20 and not %.
        String artist_field_string_replaced = artist_field_string.replaceAll(" ", "%20");
        String song_field_string_replaced = song_field_string.replaceAll(" ", "%20");

        System.out.println(artist_field_string_replaced);
        System.out.println(song_field_string_replaced);


        String GET_URL = "https://api.lyrics.ovh/v1/"+artist_field_string_replaced+"/"+song_field_string_replaced+"/";
        System.out.println(GET_URL);

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            output.setText(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }

    @FXML
    void runSearch(ActionEvent event) throws IOException {
        sendGET();
        System.out.println("runSearch finished");
    }
}
