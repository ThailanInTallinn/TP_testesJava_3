package org.exercise5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        try{
            URL url = new URI("https://apichallenges.eviltester.com/sim/entities").toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonString = """
                    {"name": "aluno"}""";

            try(OutputStream os = conn.getOutputStream()){
                os.write(jsonString.getBytes(StandardCharsets.UTF_8));
            }

            int status = conn.getResponseCode();
            System.out.println("Codigo de status: "+ status);

            String response = new String(conn.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(response);
        } catch(URISyntaxException | IOException e){
            throw new RuntimeException(e);
        }


    }
}
