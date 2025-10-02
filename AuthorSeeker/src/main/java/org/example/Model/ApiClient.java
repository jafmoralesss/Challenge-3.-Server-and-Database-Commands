package org.example.Model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
    }
}
