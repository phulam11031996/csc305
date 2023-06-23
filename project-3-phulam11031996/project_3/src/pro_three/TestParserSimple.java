package pro_three;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.Logger;

class TestParserSimple {

  static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  static String testInputSimple = "inputs/myTestSimple.json";
  static String testInputSimpleBad = "inputs/myTestSimpleBad.json";

  /**
   * @throws java.lang.Exception
   * @doc check for the first title of the article after parsing
   */
  @Test
  public void checkForCorrectOutputTitle() throws IOException {
    SourceFormat sourceFormat = new SourceFormat(Source.FILE, Format.SIMPLE);
    ParserSimple parser = (ParserSimple) sourceFormat.accept(testInputSimple);
    String title = parser.getArticleSimple().getTitle();

    assertTrue("Assignment #2".equals(title));
  }

  /**
   * @throws java.lang.Exception
   * @doc check for the first URL of the article after parsing
   */
  @Test
  public void checkForCorrectOutputUrl() throws IOException {
    SourceFormat sourceFormat = new SourceFormat(Source.FILE, Format.SIMPLE);
    ParserSimple parser = (ParserSimple) sourceFormat.accept(testInputSimple);
    String url = parser.getArticleSimple().getUrl();
    assertTrue("https://canvas.calpoly.edu/courses/55411/assignments/274503".equals(url));
  }

  /**
   * @throws java.lang.Exception
   * @doc check for the first publishedAt of the article after parsing
   */
  @Test
  public void checkForCorrectOutputPublishedAt() throws IOException {
    SourceFormat sourceFormat = new SourceFormat(Source.FILE, Format.SIMPLE);
    ParserSimple parser = (ParserSimple) sourceFormat.accept(testInputSimple);
    String pub = parser.getArticleSimple().getPublishedAt();
    assertTrue("2021-04-16 09:53:23.709229".equals(pub));
  }

  /**
   * @throws java.lang.Exception
   * @doc check for the first description of the article after parsing
   */
  @Test
  public void checkForCorrectOutputDescription() throws IOException {
    SourceFormat sourceFormat = new SourceFormat(Source.FILE, Format.SIMPLE);
    ParserSimple parser = (ParserSimple) sourceFormat.accept(testInputSimple);
    String des = parser.getArticleSimple().getDescription();
    assertTrue("Extend Assignment #1 to support multiple sources and to introduce source processor.".equals(des));
  }

  /**
   * @throws java.lang.Exception
   * @doc check ParserSimple if it can detect a bad article
   */
  @Test
  public void checkForBadArticle() throws IOException {
    SourceFormat sourceFormat = new SourceFormat(Source.FILE, Format.SIMPLE);
    ParserSimple parser = (ParserSimple) sourceFormat.accept(testInputSimpleBad);
    ArticleSimple articleSimple = parser.getArticleSimple();
    assertNull(articleSimple);
  }

}
