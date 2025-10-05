package org.example.Model;

/**
 * To hold ArticleInfo content into DB in POstgreSQL.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleRepository{

    private final String dbUrl = System.getenv("postgreUrl");
    private final String dbUser = System.getenv("postgreUser");
    private final String dbPassword = System.getenv("postgrePassword");

    public void save(ArticleInfo article){
        String sql = "INSERT INTO articles (title, authors, publication_date, abstract, link, keywords, cited_by) VALUES (?, ?, ?, ? ,?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, article.getTitle());
            pstmt.setString(2, article.getAuthors());
            pstmt.setString(3, article.getPublicationDate());
            pstmt.setString(4, article.getAbstractText());
            pstmt.setString(5, article.getLink());
            pstmt.setString(6, article.getKeywords());
            pstmt.setInt(7, article.getCitedBy());

            pstmt.executeUpdate();
        } catch (SQLException z){
            if (dbUrl == null || dbUser == null){
                System.err.println("Databse credentials not found in environment variables");
                System.err.println("Set the required credentials.");
            }
            System.err.println("Database error: " + z.getMessage());
        }
    }
}