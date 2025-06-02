package org.exercise4;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URI("https://apichallenges.eviltester.com/sim/entities?categoria=teste&limite=5").toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int statusCode = conn.getResponseCode();
        System.out.println(url);
        System.out.println(statusCode);
        conn.disconnect();
    }
}
