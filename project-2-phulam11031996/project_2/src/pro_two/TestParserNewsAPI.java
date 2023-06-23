package pro_two;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

class TestParserNewsAPI {
    static String testInputNewsAPI = "inputs/myTestNewsAPI.json";

    /**
     * @throws java.lang.Exception
     * @doc check for the first title of the article after parsing
     */
    @Test
    public void checkForCorrectOutputTitle() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserNewsAPI(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputNewsAPI);
        List<Article> articles = parser.parseFile(jsonStr);
        assertTrue("The latest on the coronavirus pandemic and vaccines: Live updates - CNN"
                .equals(articles.get(0).getTitle()));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first URL of the article after parsing
     */
    @Test
    public void checkForCorrectOutputUrl() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserNewsAPI(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputNewsAPI);
        List<Article> articles = parser.parseFile(jsonStr);
        assertTrue("https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html"
                .equals(articles.get(0).getUrl()));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first publishedAt of the article after parsing
     */
    @Test
    public void checkForCorrectOutputPublishedAt() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserNewsAPI(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputNewsAPI);
        List<Article> articles = parser.parseFile(jsonStr);
        assertTrue("2021-03-24T22:32:00Z".equals(articles.get(0).getPublishedAt()));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first description of the article after parsing
     */
    @Test
    public void checkForCorrectOutputDescription() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserNewsAPI(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputNewsAPI);
        List<Article> articles = parser.parseFile(jsonStr);
        assertTrue(
                "The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest."
                        .equals(articles.get(0).getDescription()));
    }

    /**
     * @throws java.lang.Exception
     * @doc 4 articles in the fileNameMytestJson file, 2 goods and 2 bads
     *      after removing there is 2 article left
     */
    @Test
    public void checkForParseFile() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new ParserNewsAPI(logger);
        String jsonStr = Main.getJsonStrFromFile(testInputNewsAPI);
        List<Article> articles = parser.parseFile(jsonStr);
        assertEquals(2, articles.size());
    }

}
