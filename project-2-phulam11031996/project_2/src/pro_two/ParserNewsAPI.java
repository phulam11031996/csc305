package pro_two;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

class ParserNewsAPI implements Parser {
    private Logger logger;
    private List<Article> articles = new ArrayList<>();

    public ParserNewsAPI(Logger logger) {
        this.logger = logger;
    }

    List<Article> getArticles() {
        return this.articles;
    }

    public List<Article> parseFile(String fileName) throws IOException {
        News news;
        ObjectMapper mapper = new ObjectMapper();
        news = mapper.readValue(fileName, News.class);

        this.articles = news.getArticles();

        for (int i = this.articles.size() - 1; i > 0; i--) {
            String url = this.articles.get(i).getUrl();
            String des = this.articles.get(i).getDescription();
            String pub = this.articles.get(i).getTitle();
            String date = this.articles.get(i).getPublishedAt();
            if (url == null || des == null || pub == null || date == null) {
                this.logger.log(Level.WARNING, "Parsing Error");
                this.articles.remove(i);
            }
        }

        return this.articles;
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
