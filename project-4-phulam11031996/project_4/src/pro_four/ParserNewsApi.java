package pro_four;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class ParserNewsApi implements Parser {

    Logger logger;
    List<Article> articles = new ArrayList<>();

    public ParserNewsApi(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public void visit(String sourceInput) throws IOException {
        ArticleNews news;
        ObjectMapper mapper = new ObjectMapper();
        news = mapper.readValue(new File(sourceInput), ArticleNews.class);

        List<Article> tmpArticle = news.getArticles();

        for (int i = tmpArticle.size() - 1; i > 0; i--) {
            String url = tmpArticle.get(i).getUrl();
            String des = tmpArticle.get(i).getDescription();
            String pub = tmpArticle.get(i).getTitle();
            String date = tmpArticle.get(i).getPublishedAt();
            if (url == null || des == null || pub == null || date == null) {
                this.logger.log(Level.WARNING, "Parsing Error");
                tmpArticle.remove(i);
            }
        }
        this.articles.addAll(tmpArticle);
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
