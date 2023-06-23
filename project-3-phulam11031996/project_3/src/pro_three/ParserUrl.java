package pro_three;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

class ParserUrl implements Parser {

	Logger logger;
	List<Article> articles = new ArrayList<>();
	
	public ParserUrl(Logger logger) {
		this.logger = logger;
	}

	List<Article> getArticles() {
		return this.articles;
	}

    public void visit(String sourceInput) throws IOException {
        News news;
        ObjectMapper mapper = new ObjectMapper();
        news = mapper.readValue(sourceInput, News.class);

        List<Article> tmpArticles = news.getArticles();

        for (int i = tmpArticles.size() - 1; i > 0; i--) {
            String url = tmpArticles.get(i).getUrl();
            String des = tmpArticles.get(i).getDescription();
            String pub = tmpArticles.get(i).getTitle();
            String date = tmpArticles.get(i).getPublishedAt();
            if (url == null || des == null || pub == null || date == null) {
                this.logger.log(Level.WARNING, "Parsing Error");
                tmpArticles.remove(i);
            }
        }
        this.articles.addAll(tmpArticles);
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
