package org.example.Controller;

import org.example.Services.ApiService;
import org.example.Services.JsonParser;
import org.example.Model.ArticleInfo;
import org.example.Model.ArticleRepository;
import org.example.View.InfoDisplay;

import java.util.Scanner;
import java.util.List;

/**
 * Controller for program's workflow
 */

public class SeekerLogic {

    private final ApiService apiService = new ApiService();
    private final JsonParser jsonParser = new JsonParser();
    private final ArticleRepository repository = new ArticleRepository();
    private final InfoDisplay view = new InfoDisplay();

    public void run() {
        view.showWelcomeMessage();

        String[] researchers = view.getResearcherNames();

        for (String researcher : researchers) {
            view.showProcessingMessage(researcher);
            try {
                String jsonResponse = apiService.requestApi(researcher);

                if (jsonResponse != null) {
                    List<ArticleInfo> articles = jsonParser.parseJsonData(jsonResponse);
                    for (ArticleInfo article : articles) {
                        repository.save(article);
                        view.showArticleSaved(article);
                    }
                }
            } catch (Exception e) {
                view.showErrorMessage(e.getMessage());
            }
        }

        view.showGoodbyeMessage();
    }
}