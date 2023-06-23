package pro_two;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

class TestParserSimple {
    static String testInputSimple = "inputs/myTestSimple.json";

    /**
     * @throws java.lang.Exception
     * @doc check for the first title of the article after parsing
     */
    @Test
    public void checkForCorrectOutputTitle() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserSimple(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputSimple);
        List<Article> articles = parser.parseFile(jsonStr);
        String tit = articles.get(0).getTitle();
        assertTrue("Assignment #2".equals(tit));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first URL of the article after parsing
     */
    @Test
    public void checkForCorrectOutputUrl() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserSimple(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputSimple);
        List<Article> articles = parser.parseFile(jsonStr);
        String url = articles.get(0).getUrl();
        assertTrue("https://canvas.calpoly.edu/courses/55411/assignments/274503".equals(url));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first publishedAt of the article after parsing
     */
    @Test
    public void checkForCorrectOutputPublishedAt() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserSimple(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputSimple);
        List<Article> articles = parser.parseFile(jsonStr);
        String pub = articles.get(0).getPublishedAt();
        assertTrue("2021-04-16 09:53:23.709229".equals(pub));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first description of the article after parsing
     */
    @Test
    public void checkForCorrectOutputDescription() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserSimple(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputSimple);
        List<Article> articles = parser.parseFile(jsonStr);
        String des = articles.get(0).getDescription();
        assertTrue("Extend Assignment #1 to support multiple sources and to introduce source processor.".equals(des));
    }

    /**
     * @throws java.lang.Exception
     * @doc
     */
    @Test
    public void checkForParseFile() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserSimple(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputSimple);
        List<Article> articles = parser.parseFile(jsonStr);
        assertEquals(1, articles.size());
    }

}
