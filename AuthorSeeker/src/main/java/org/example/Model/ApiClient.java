package org.example.Model;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiClient {

    private final String apiKey = System.getenv("serpApiKey");

    public void displayUrl (String queryText) {

        String encodedQuery = URLEncoder.encode(queryText, StandardCharsets.UTF_8);

        String base = "https://serpapi.com/search.json";
        String completeUrl = base
                + "?engine=google_scholar"
                + "&q=" + encodedQuery
                + "&hl=en"
                + "&num=5"
                + "&start=0"
                + "&api_key=" + apiKey;

        System.out.println("URL: " + completeUrl);

        HttpGet request = new HttpGet(completeUrl);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200){

                if (entity != null){
                    String jsonBody = EntityUtils.toString(entity);

                    System.out.println("Status: " + statusCode);
                    System.out.println("JSON body" + jsonBody);


                }
            } else {
                System.err.println("API call failed. Status: " + statusCode);
            }
        }  catch (IOException e){
            System.err.println("Connection error for this request: " + e.getMessage());
        }
    }
}
