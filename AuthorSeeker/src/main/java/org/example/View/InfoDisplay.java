package org.example.View;

import org.example.Model.ArticleInfo;

import java.util.List;
import java.util.Scanner;

/**
 * The interaction with user. Will ask for inputs and display the info saved in PostgreSQL.
 */
public class InfoDisplay {

    private final Scanner scanner = new Scanner(System.in);



    public int mainMenu() {
        System.out.println("=== MAIN MENU ===");
        System.out.println("Select an option: ");
        System.out.println("1. Add articles from the API");
        System.out.println("2. Display articles previously saved");
        System.out.println("3. EXIT");
        System.out.println("-------------------------");
        int selection = scanner.nextInt();
        scanner.nextLine();
        return selection;
    }

    public String[] getResearcherNames() {
        System.out.print("Enter the name of the first researcher: ");
        String researcher1 = scanner.nextLine();
        System.out.print("Enter the name of the second researcher: ");
        String researcher2 = scanner.nextLine();
        return new String[]{researcher1, researcher2};
    }

    public void showProcessingMessage(String researcher) {
        System.out.println("------------------------------------");
        System.out.println("Processing researcher: " + researcher);
    }

    public void showArticleSaved(ArticleInfo article) {
        System.out.println("  -> Saved article: " + article.getTitle());
    }

    public void showErrorMessage(String message) {
        System.err.println("An error occurred: " + message);
    }

    public void showGoodbyeMessage() {
        System.out.println("------------------------------------");
        System.out.println("Process finished.");
        scanner.close(); // Close the scanner when the application is done
    }

    public void showDbContent (List<ArticleInfo> articlesSaved){
        System.out.println("----- Saved Articles -----");
        if (articlesSaved.isEmpty()) {
            System.out.println("Database is empty.");
        } else {
            for (ArticleInfo articleInfo : articlesSaved){
                System.out.println("ID: " + articleInfo.getId());
                System.out.println(" Title: " + articleInfo.getTitle());
                System.out.println(" Authors: " + articleInfo.getAuthors());
                System.out.println(" Date: " + articleInfo.getPublicationDate());
                System.out.println(" Cited by: " + articleInfo.getCitedBy());
            }
        }
    }
}

