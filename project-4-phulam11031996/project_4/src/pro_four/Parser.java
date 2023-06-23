package pro_four;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

interface Parser {
    void visit(String sourceInput) throws IOException;

    List<Article> getArticles();

    Logger getLogger();

}