package cz.peinlich.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiri
 */
public class NhsResponse {
    String query;
    List<String> urls = new ArrayList<>();

    public NhsResponse(String query, List<String> urls) {

        this.query = query;
        this.urls = urls;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public void addUrl(String url) {
        this.urls.add(url);
    }
}
