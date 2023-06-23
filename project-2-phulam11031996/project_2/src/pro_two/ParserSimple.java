package pro_two;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

class ParserSimple implements Parser {
	private Logger logger;
	private List<Article> articles = new ArrayList<>();

	public ParserSimple(Logger logger) {
		this.logger = logger;
	}

	List<Article> getArticles() {
		return this.articles;
	}

	public List<Article> parseFile(String jsonStr) throws IOException {
		Article article;
		ObjectMapper mapper = new ObjectMapper();
		article = mapper.readValue(jsonStr, Article.class);

		String des = article.getDescription();
		String tit = article.getTitle();
		String url = article.getUrl();
		String pub = article.getPublishedAt();
		if (url == null || des == null || pub == null || tit == null)
			this.logger.log(Level.WARNING, "Parsing Error");
		else
			this.articles.add(article);

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
