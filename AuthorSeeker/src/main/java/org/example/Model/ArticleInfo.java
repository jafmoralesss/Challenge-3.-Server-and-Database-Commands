package org.example.Model;

public class ArticleInfo {

    private String id;
    private String title;
    private String authors;
    private String publicationDate;
    private String summary;
    private String link;
    private String keywords;
    private String numberCites;

    public String getId() {
        return id;
    }
    public void setId(String id) {
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

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getNumberCites() {
        return numberCites;
    }
    public void setNumberCites(String numberCites) {
        this.numberCites = numberCites;
    }
}
