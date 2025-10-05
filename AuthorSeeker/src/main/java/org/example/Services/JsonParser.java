package org.example.Services;

import org.example.Model.ArticleInfo;
import org.example.Services.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {

    public List<ArticleInfo> parseJsonData (String rawJson) throws IOException {
        List<ArticleInfo> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(rawJson);
        JsonNode resultsNode = rootNode.path("organic_results");

        if (resultsNode.isArray()) {
            for (JsonNode resultNode : resultsNode){
                ArticleInfo article = new ArticleInfo();

                String title = resultNode.path("title").asText();
                String link = resultNode.path("link").asText();
                String authorsAndDate = resultNode.path("publication_info").asText();
                String abstractText = resultNode.path("snippet").asText();
                int citedBy = resultNode.path("cited_by").path("total").asInt();

                article.setTitle(title);
                article.setLink(link);
                article.setAuthors(authorsAndDate);
                article.setPublicationDate("");
                article.setAbstractText(abstractText);
                article.setCitedBy(citedBy);

                articles.add(article);
            }
        }
            return articles;
    }

}
