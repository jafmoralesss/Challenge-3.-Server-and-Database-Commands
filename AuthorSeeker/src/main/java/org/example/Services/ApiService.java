package org.example.Services;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiService {

    private final String apiKey = System.getenv("serpApiKey");

    public String requestApi (String queryText) {

        String encodedQuery = URLEncoder.encode(queryText, StandardCharsets.UTF_8);

        String base = "https://serpapi.com/search.json";
        String completeUrl = base
                + "?engine=google_scholar"
                + "&q=" + encodedQuery
                + "&hl=en"
                + "&num=2"
                + "&start=0"
                + "&api_key=" + apiKey;

        HttpGet request = new HttpGet(completeUrl);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200){

                if (entity != null){
                    String jsonBody = EntityUtils.toString(entity);

                    System.out.println("SUCCESSFUL CONNECTION. Status: " + statusCode);
                    System.out.println("JSONNNNN: " +jsonBody);

                    return jsonBody;
                }
            } else {
                System.err.println("API call failed. Status: " + statusCode);
            }

            return null;
        }  catch (IOException e){
            System.err.println("Connection error for this request: " + e.getMessage());
            return null;
        }
    }
}
