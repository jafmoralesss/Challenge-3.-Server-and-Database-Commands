package org.example.Controller;

import org.example.Services.ApiService;
import org.example.Services.JsonParser;
import org.example.Model.ArticleInfo;
import org.example.Model.ArticleRepository;
import org.example.View.InfoDisplay;

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
        while (true) {
            int choice = view.mainMenu();

            switch (choice) {
                case 1:

                    addArticles();
                    break;
                case 2:
                    // Logic to display articles
                    displayAllArticles();
                    break;
                case 3:
                    // Exit the application
                    view.showGoodbyeMessage();
                    System.exit(0);
                default:
                    view.showErrorMessage("Invalid choice. Please try again.");
            }
        }

    }

    private void addArticles(){
        view.mainMenu();

        String[] researchers = view.getResearcherNames();

        for (String researcher : researchers) {
            view.showProcessingMessage(researcher);
            try {
                String jsonResponse = apiService.requestApi(researcher);

                if (jsonResponse != null) {
                    List<ArticleInfo> articles = jsonParser.parseJsonData(jsonResponse);
                    for (ArticleInfo article : articles) {
                        repository.saveInfo(article);
                        view.showArticleSaved(article);
                    }
                }
            } catch (Exception e) {
                view.showErrorMessage(e.getMessage());
            }
        }
    }

    private void displayAllArticles(){
        List<ArticleInfo> articleInfo = repository.findInfo();
        view.showDbContent(articleInfo);
    }
}