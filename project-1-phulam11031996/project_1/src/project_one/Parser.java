package project_one;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

class Parser {
    private Logger logger;
    private List<Article> articles = new ArrayList<>();

    public Parser(Logger logger) {
        this.logger = logger;
    }

    List<Article> getArticles() {
        return this.articles;
    }

    List<Article> parseFile(String fileName) throws IOException {
        News news;
        ObjectMapper mapper = new ObjectMapper();
        news = mapper.readValue(new File(fileName), News.class);
        this.articles = news.getArticles();

        return this.articles;
    }

    Integer removeAndLogBadArticles() {
        int badCount = 0;
        for (int i = this.articles.size() - 1; i > 0; i--) {
            if (this.articles.get(i).isArticleBad()) {
                this.logger.log(Level.WARNING, "Parsing Error");
                this.articles.remove(i);
                badCount += 1;
            }
        }

        return badCount;
    }

    public String toString() {
        StringBuilder resultStr = new StringBuilder();
        for (Article article : this.articles) {
            resultStr.append(article.toString());
            resultStr.append("\n");
        }

        return resultStr.toString();
    }

}
