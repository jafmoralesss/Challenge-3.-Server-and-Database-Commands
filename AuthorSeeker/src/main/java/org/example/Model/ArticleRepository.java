package org.example.Model;

/**
 * To hold ArticleInfo content into DB in POstgreSQL.
 *
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository{

    private final String dbUrl = System.getenv("postgreUrl");
    private final String dbUser = System.getenv("postgreUser");
    private final String dbPassword = System.getenv("postgrePassword");

    public void saveInfo(ArticleInfo article){
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

    public List<ArticleInfo> findInfo() {
        String sql = "SELECT * FROM articles";
        List<ArticleInfo> articles = new ArrayList<>(); // Create a list to hold the results

        // Use a try-with-resources to automatically close the connection
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through each row in the ResultSet
            while (rs.next()) {

                ArticleInfo article = new ArticleInfo();

                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setAuthors(rs.getString("authors"));
                article.setPublicationDate(rs.getString("publication_date"));
                article.setAbstractText(rs.getString("abstract"));
                article.setLink(rs.getString("link"));
                article.setKeywords(rs.getString("keywords"));
                article.setCitedBy(rs.getInt("cited_by"));

                articles.add(article);
            }
        } catch (SQLException e) {
            System.err.println("Database error when finding info: " + e.getMessage());
        }
        return articles;
    }
}