package project_one;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

public class JUnitTesting {
    static String fileNameBadJson = "bad.json";
    static String fileNameExampleJson = "example.json";
    static String fileNameMytestJson = "myTest.json";

    @Test
    public void checkForCorrectOutput0() throws IOException {
        Parser parser = new Parser(null);
        parser.parseFile(fileNameMytestJson);
        String url = parser.getArticles().get(0).getUrl();
        String des = parser.getArticles().get(0).getDescription();
        String tit = parser.getArticles().get(0).getTitle();
        Date pub = parser.getArticles().get(0).getPublishedAt();
        assertTrue("The latest on the coronavirus pandemic and vaccines: Live updates - CNN".equals(tit) &&
                "The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.".equals(des) &&
                "https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html".equals(url) &&
                "2021-03-24".equals(pub.toString()));
    }

    @Test
    public void checkForCorrectOutput1() throws IOException {
        Parser parser = new Parser(null);
        parser.parseFile(fileNameMytestJson);
        String url = parser.getArticles().get(1).getUrl();
        String des = parser.getArticles().get(1).getDescription();
        String tit = parser.getArticles().get(1).getTitle();
        Date pub = parser.getArticles().get(1).getPublishedAt();
        assertTrue("People line the streets of Boulder to honor slain police Officer Eric Talley - CNN".equals(tit) &&
                "Boulder, Colorado, continued to mourn fallen Officer Eric Talley on Wednesday.".equals(des) &&
                "https://www.cnn.com/2021/03/24/us/officer-talley-procession/index.html".equals(url) &&
                "2021-03-24".equals(pub.toString()));
    }

    @Test
    public void checkForCorrectOutput2() throws IOException {
        Parser parser = new Parser(null);
        parser.parseFile(fileNameMytestJson);
        String url = parser.getArticles().get(2).getUrl();
        String des = parser.getArticles().get(2).getDescription();
        String tit = parser.getArticles().get(2).getTitle();
        Date pub = parser.getArticles().get(2).getPublishedAt();
        assertTrue(null ==  tit &&
                "It's macOS 11 now, but the DNA is the same.".equals(des) &&
                "https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/".equals(url) &&
                "2021-03-24".equals(pub.toString()));
    }


    @Test
    public void checkForCorrectOutput3() throws IOException {
        Parser parser = new Parser(null);
        parser.parseFile(fileNameMytestJson);
        String url = parser.getArticles().get(3).getUrl();
        String des = parser.getArticles().get(3).getDescription();
        String tit = parser.getArticles().get(3).getTitle();
        Date pub = parser.getArticles().get(3).getPublishedAt();
        assertTrue("Vice President Kamala Harris to lead White House efforts to stem migration at the border - USA TODAY".equals(tit) &&
                "Vice President Kamala Harris will  work on establishing a partnership with Mexico and the northern triangle of Honduras, Guatemala and El Salvador.".equals(des) &&
                "https://www.usatoday.com/story/news/politics/2021/03/24/kamala-harris-lead-biden-admin-stemming-migration-border/6984000002/".equals(url) &&
                null == pub);
    }

    @Test
    public void checkIsArticleBadMethod() throws IOException {
        Parser parser = new Parser(null);
        List<Article> articles = parser.parseFile(fileNameMytestJson);
        assertTrue(!articles.get(0).isArticleBad() &&
                !articles.get(1).isArticleBad() &&
                articles.get(2).isArticleBad() &&
                articles.get(3).isArticleBad());
    }

    @Test
    public void checkIfBadArticleIsRemoved() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new Parser(logger);
        List<Article> articles = parser.parseFile(fileNameMytestJson);

        assertTrue(!articles.get(0).isArticleBad() &&
                !articles.get(1).isArticleBad() &&
                articles.get(2).isArticleBad() &&
                articles.get(3).isArticleBad());

        int badArticles = parser.removeAndLogBadArticles();

        assertEquals(2, badArticles);
    }


    @Test
    public void checkPartFileMethodForProvidedFiles() throws IOException {
        Parser parser = new Parser(null);
        List<Article> articles = parser.parseFile(fileNameExampleJson);
        List<Article> articles1 = parser.parseFile(fileNameBadJson);
        assertTrue((articles.size() == 20 && articles1.size() == 20));
    }

    @Test
    public void checkForParsingCorrectNonNullField() throws IOException {
        Parser parser = new Parser(null);
        parser.parseFile("example.json");
        String url = parser.getArticles().get(4).getUrl();
        String des = parser.getArticles().get(4).getDescription();
        String tit = parser.getArticles().get(4).getTitle();
        Date pub = parser.getArticles().get(4).getPublishedAt();
        assertTrue("Ever Given, the massive cargo ship that ran aground in the Suez Canal, is still stuck - CNBC".equals(tit) &&
                "The Ever Given, which become lodged in the Suez Canal, is still stuck, halting traffic in one of the world's busiest waterways.".equals(des) &&
                "https://www.cnbc.com/2021/03/24/ever-given-a-massive-cargo-ship-is-still-stuck-in-the-suez-canal.html".equals(url) &&
                "2021-03-24".equals(pub.toString()));
    }

    @Test
    public void checkForParsingCorrectNullField() throws IOException {
        Parser parser = new Parser(null);
        parser.parseFile(fileNameBadJson);
        String title = parser.getArticles().get(2).getTitle();
        assertNull(title);
    }

    @Test
    public void checkIfBadArticlesIsRemovedForExampleFile() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new Parser(logger);
        parser.parseFile(fileNameExampleJson);
        parser.removeAndLogBadArticles();
        int badCount = parser.removeAndLogBadArticles();
        // we know out input; There are 0 bad articles
        assertTrue((0 == badCount && 20 == parser.getArticles().size()));
    }
    @Test
    public void checkIfBadArticlesIsRemovedForBadFile() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Parser parser = new Parser(logger);
        parser.parseFile(fileNameBadJson);
        int badCount = parser.removeAndLogBadArticles();
        // we know out input; There are 3 bad articles
        assertTrue(3 == badCount && 17 == parser.getArticles().size());
    }

}
