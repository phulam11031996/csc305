package pro_four;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class TestParserNewAPI {
	static String testInputNewsAPI = "inputs/myTestNewsAPI.json";

	/**
	 * @throws java.lang.Exception
	 * @doc check for the first title of the article after parsing
	 */
	@Test
	public void checkForCorrectOutputTitle() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String title = parser.getArticles().get(0).getTitle();

		assertTrue("The latest on the coronavirus pandemic and vaccines: Live updates - CNN".equals(title));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the first URL of the article after parsing
	 */
	@Test
	public void checkForCorrectOutputUrl() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String url = parser.getArticles().get(0).getUrl();

		assertTrue("https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html"
				.equals(url));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the first publishedAt of the article after parsing
	 */
	@Test
	public void checkForCorrectOutputPublishedAt() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String publishedAt = parser.getArticles().get(0).getPublishedAt();

		assertTrue("2021-03-24T22:32:00Z".equals(publishedAt));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the first description of the article after parsing
	 */
	@Test
	public void checkForCorrectOutputDescription() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String des = parser.getArticles().get(0).getDescription();
		assertTrue(
				"The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest."
						.equals(des));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc 4 articles in the fileNameMytestJson file, 2 goods and 2 bads
	 *      after removing there is 2 article left
	 */
	@Test
	public void checkForParseFile() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		int articleLength = parser.getArticles().size();

		assertEquals(2, articleLength);
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the second title of the article after parsing with filter
	 */
	@Test
	public void checkForCorrectOutputTitleWithFilter() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE, InputArticleSource.CNN);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String title = parser.getArticles().get(1).getTitle();

		assertTrue("People line the streets of Boulder to honor slain police Officer Eric Talley - CNN".equals(title));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the second URL of the article after parsing with filter
	 */
	@Test
	public void checkForCorrectOutputUrlWithFilter() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE, InputArticleSource.CNN);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String url = parser.getArticles().get(1).getUrl();

		assertTrue("https://www.cnn.com/2021/03/24/us/officer-talley-procession/index.html".equals(url));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the second publishedAt of the article after parsing with
	 *      filter
	 */
	@Test
	public void checkForCorrectOutputPublishedAtWithFilter() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE, InputArticleSource.CNN);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String publishedAt = parser.getArticles().get(1).getPublishedAt();

		assertTrue("2021-03-24T22:20:12Z".equals(publishedAt));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc check for the second description of the article after parsing with
	 *      filter
	 */
	@Test
	public void checkForCorrectOutputDescriptionWithFilter() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE, InputArticleSource.CNN);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		String des = parser.getArticles().get(1).getDescription();

		assertTrue(
				"Boulder, Colorado, continued to mourn fallen Officer Eric Talley on Wednesday."
						.equals(des));
	}

	/**
	 * @throws java.lang.Exception
	 * @doc 4 articles in the fileNameMytestJson file, 2 goods and 2 bads
	 *      after removing there is 2 article left
	 */
	@Test
	public void checkForParseFileWithFilter() throws IOException {
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE, InputArticleSource.CNN);
		ParserNewsApi parser = (ParserNewsApi) sourceFormat.accept(testInputNewsAPI);
		int articleLength = parser.getArticles().size();

		assertEquals(2, articleLength);
	}
}
