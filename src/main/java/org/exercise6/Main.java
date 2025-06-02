package org.exercise6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException , URISyntaxException {
        URL url = new URI("https://apichallenges.eviltester.com/sim/entities/11").toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        for(String line : input.readLine().split("\n")) {
            System.out.println(line);
        }

        conn.disconnect();
        input.close();
    }
}
