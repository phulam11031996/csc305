package pro_three;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

class ParserSimple implements Parser{

	Logger logger;
	ArticleSimple articleSimple = null;
	
	public ParserSimple(Logger logger) {
		this.logger = logger;
	}
	
	ArticleSimple getArticleSimple(){
		return this.articleSimple;
	}

    public void visit(String sourceInput) throws IOException {
        ArticleSimple article;
        ObjectMapper mapper = new ObjectMapper();
        article = mapper.readValue(new File(sourceInput), ArticleSimple.class);

        String des = article.getDescription();
        String tit = article.getTitle();
        String url = article.getUrl();
        String pub = article.getPublishedAt();
        if (url == null || des == null || pub == null || tit == null)
            this.logger.log(Level.WARNING, "Parsing Error");
        else
            this.articleSimple = article;
    }

    public String toString() {
        StringBuilder resultStr = new StringBuilder();

		resultStr.append(this.articleSimple.toString());
		resultStr.append("\n");

        return resultStr.toString();
    }

}
