package org.example.Services;

import org.example.Model.ArticleInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JsonParser {

    /**
     *
     * @param rawJson The info retrieved from the API as a JSON.
     * @return A list with content from the JSON in objects
     * @throws IOException It returns the exception in case the JSON isn't well structures
     */

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
                String summary = resultNode.path("publication_info").path("summary").asText();
                String abstractText = resultNode.path("snippet").asText();
                String publicationDate = "";
                int citedBy = resultNode.path("inline_links").path("cited_by").path("total").asInt();


                String[] summarySeparation = summary.split(" - ");

                Pattern pattern = Pattern.compile("\\d{4}");
                Matcher matcher = pattern.matcher(summarySeparation[1]);

                if (matcher.find()){
                    publicationDate = matcher.group(0);
                }

                article.setTitle(title);
                article.setLink(link);
                article.setAuthors(summarySeparation[0]);
                article.setAbstractText(abstractText);
                article.setCitedBy(citedBy);
                article.setPublicationDate(publicationDate);

                articles.add(article);
            }
        }
            return articles;
    }
}