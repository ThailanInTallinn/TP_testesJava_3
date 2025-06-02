package org.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        for(int i = 1; i <= 8; i++){
            URL url = new URI("https://apichallenges.eviltester.com/sim/entities/" + i).toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept", "application/json");

            BufferedReader answer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            for(String item : answer.readLine().split(",")) {
                System.out.println(item);
            }

            answer.close();
            conn.disconnect();
        }


    }
}
