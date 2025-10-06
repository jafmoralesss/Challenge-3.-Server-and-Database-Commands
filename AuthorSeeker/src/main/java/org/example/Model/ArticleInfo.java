package org.example.Model;

/**
 * Object that mirrors the PostgreSQL table.
 */

public class ArticleInfo  {

    private int id;
    private String title;
    private String authors;
    private String publicationDate;
    private String abstractText;
    private String link;
    private String keywords;
    private int citedBy;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors(){
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAbstractText() {
        return abstractText;
    }
    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getCitedBy() {
        return citedBy;
    }
    public void setCitedBy(int citedBy) {
        this.citedBy = citedBy;
    }
}
