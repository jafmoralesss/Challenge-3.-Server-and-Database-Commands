package org.example.View;

import org.example.Model.ArticleInfo;
import java.util.Scanner;

/**
 * The interaction with user. Wil ask for inputs and display the info saved in PostgreSQL.
 */
public class InfoDisplay {

    private final Scanner scanner = new Scanner(System.in);

    public void showWelcomeMessage() {
        System.out.println("Starting the author seeker process...");
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
}

