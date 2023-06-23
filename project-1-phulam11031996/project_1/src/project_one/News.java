
package project_one;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class News {

    private List<Article> articles = new ArrayList<>();

    @JsonCreator
    private News(@JsonProperty("status") String status,
            @JsonProperty("totalResults") int totalResults,
            @JsonProperty("articles") List<Article> articles) {
        this.articles = articles;
    }

    List<Article> getArticles() {
        return this.articles;
    }

}
