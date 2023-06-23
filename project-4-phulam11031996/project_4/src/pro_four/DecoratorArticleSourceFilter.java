package pro_four;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class DecoratorArticleSourceFilter extends DecoratorBase {
	InputArticleSource articleSource;

	public DecoratorArticleSourceFilter(Parser parser, InputArticleSource articleSource) {
		super.parser = parser;
		this.articleSource = articleSource;
	}

	public void visit(String sourceInput) throws IOException {
		super.parser.visit(sourceInput);
		List<Article> articles = super.parser.getArticles();
		Logger logger = super.parser.getLogger();

		for (int i = articles.size() - 1; i > 0; i--) {
			String sourceName = articles.get(i).getSource().getName();
			if (!(sourceName.equals(this.articleSource.toString()))) {
				logger.log(Level.WARNING, "Parsing Error");
				articles.remove(i);
			}
		}
	}

}
