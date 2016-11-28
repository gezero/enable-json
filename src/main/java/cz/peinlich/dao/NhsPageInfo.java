package cz.peinlich.dao;

/**
 * @author Jiri
 */
public class NhsPageInfo {
    String host;
    String section_name;
    String section_url;
    String article_name;
    String article_url;
    String content;

    public NhsPageInfo() {
    }

    public NhsPageInfo(String host, String section_name, String section_url, String article_name, String article_url, String content) {
        this.host = host;
        this.section_name = section_name;
        this.section_url = section_url;
        this.article_name = article_name;
        this.article_url = article_url;
        this.content = content;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSection_url() {
        return section_url;
    }

    public void setSection_url(String section_url) {
        this.section_url = section_url;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
