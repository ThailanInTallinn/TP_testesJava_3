package org.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URI("https://apichallenges.eviltester.com/sim/entities/18").toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int statusCode = conn.getResponseCode();
        if (statusCode == 404) {
            System.out.println("Codigo " + statusCode + ": Nao encontrado");
            return;
        }


        conn.setRequestProperty("Accept", "application/json");

        BufferedReader answer = new BufferedReader(new InputStreamReader(conn.getInputStream()));



        for(String item : answer.readLine().split(",")) {
            System.out.println(item);
        }

        answer.close();
        conn.disconnect();
    }
}
