package project_one;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Article {
    private String title = "";
    private String description = "";
    private String url = "";
    private Date publishedAt;

    @JsonCreator
    private Article(@JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("publishDate") String publishDate,
            @JsonProperty("url") String url,
            @JsonProperty("source") Object source,
            @JsonProperty("author") String author,
            @JsonProperty("urlToImage") String urlToImage,
            @JsonProperty("publishedAt") Date publishedAt,
            @JsonProperty("content") String content) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
    }

    boolean isArticleBad() {
        return this.title == null ||
                this.description == null ||
                this.url == null ||
                this.publishedAt == null;
    }

    String getTitle() {
        return this.title;
    }

    String getDescription() {
        return this.description;
    }

    String getUrl() {
        return this.url;
    }

    Date getPublishedAt() {
        return this.publishedAt;
    }

    public String toString() {
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(this.title + "\n");
        resultStr.append(this.description + "\n");
        resultStr.append(this.publishedAt + "\n");
        resultStr.append(this.url + "\n");
        return resultStr.toString();
    }

}
