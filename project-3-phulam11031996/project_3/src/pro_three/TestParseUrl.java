package pro_three;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TestParseUrl {

    static String jsonStr = "{  \"status\": \"ok\",  \"totalResults\": 38,  \"articles\": [    {      \"source\": {        \"id\": \"cnn\",        \"name\": \"CNN\"      },      \"title\": \"The latest on the coronavirus pandemic and vaccines: Live updates - CNN\",      \"description\": \"The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.\",      \"url\": \"https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html\",      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/200213175739-03-coronavirus-0213-super-tease.jpg\",      \"publishedAt\": \"2021-03-24T22:32:00Z\",      \"content\": \"A senior European diplomat is urging caution over the use of proposed new rules that would govern exports of Covid-19 vaccines to outside of the EU. The rules were announced by the European Commissio… [+2476 chars]\"    },    {      \"source\": {        \"id\": \"cnn\",        \"name\": \"CNN\"      },      \"author\": \"Ralph Ellis, CNN\",      \"title\": \"People line the streets of Boulder to honor slain police Officer Eric Talley - CNN\",      \"description\": \"Boulder, Colorado, continued to mourn fallen Officer Eric Talley on Wednesday.\",      \"url\": \"https://www.cnn.com/2021/03/24/us/officer-talley-procession/index.html\",      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/210322232935-officer-eric-talley-headshot-super-tease.jpg\",      \"publishedAt\": \"2021-03-24T22:20:12Z\",      \"content\": null    },    {      \"source\": {        \"id\": \"ars-technica\",        \"name\": \"Ars Technica\"      },      \"author\": \"Samuel Axon\",      \"description\": \"It's macOS 11 now, but the DNA is the same.\",      \"url\": \"https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/\",      \"urlToImage\": \"https://cdn.arstechnica.net/wp-content/uploads/2020/06/Screen-Shot-2020-06-22-at-11.27.17-AM-2-1-760x380.png\",      \"publishedAt\": \"2021-03-24T21:44:01Z\",      \"content\": \"Enlarge/ When presenting a new path forward, Apple CEO Tim Cook put the ARM transition up with the Mac's other big transitions: PowerPC, MacOS X, and Intel.\\r\\n40 with 35 posters participating\\r\\nIt was … [+2618 chars]\"    },    {      \"source\": {        \"id\": \"usa-today\",        \"name\": \"USA Today\"      },      \"author\": \"Rebecca Morin\",      \"title\": \"Vice President Kamala Harris to lead White House efforts to stem migration at the border - USA TODAY\",      \"description\": \"Vice President Kamala Harris will  work on establishing a partnership with Mexico and the northern triangle of Honduras, Guatemala and El Salvador.\",      \"url\": \"https://www.usatoday.com/story/news/politics/2021/03/24/kamala-harris-lead-biden-admin-stemming-migration-border/6984000002/\",      \"urlToImage\": \"https://www.gannett-cdn.com/presto/2021/03/24/USAT/916b6cbc-bebc-4475-b510-4890de28baa7-GTY_1308935420.jpg?crop=5105,2872,x0,y0&width=3200&height=1680&fit=bounds\",      \"content\": \"The footage was released by the U.S. Customs and Border Protection as media has been denied access to border facilities.\\r\\nUSA TODAY\\r\\nWASHINGTON  As the Biden administration grapples with the growing … [+4575 chars]\"    }  ]}\n";
    static String dummyUrl = "google.com";

    /**
     * @throws java.lang.Exception
     * @doc check for the first title of the article after parsing
     */
    @Test
    public void checkForCorrectOutputTitle() throws IOException {
        GetJsonFromUrl getJson = Mockito.mock(GetJsonFromUrl.class);
        when(getJson.getJsonStrFromUrl(dummyUrl)).thenReturn(jsonStr);

        String json = getJson.getJsonStrFromUrl(dummyUrl);

        SourceFormat sourceFormat = new SourceFormat(Source.URL, Format.NOTSIMPLE);
        ParserUrl parser = (ParserUrl) sourceFormat.accept(json);
        String title = parser.getArticles().get(0).getTitle();

        assertTrue("The latest on the coronavirus pandemic and vaccines: Live updates - CNN".equals(title));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first URL of the article after parsing
     */
    @Test
    public void checkForCorrectOutputUrl() throws IOException {
        GetJsonFromUrl getJson = Mockito.mock(GetJsonFromUrl.class);
        when(getJson.getJsonStrFromUrl(dummyUrl)).thenReturn(jsonStr);

        SourceFormat sourceFormat = new SourceFormat(Source.URL, Format.NOTSIMPLE);
        ParserUrl parser = (ParserUrl) sourceFormat.accept(jsonStr);
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
        GetJsonFromUrl getJson = Mockito.mock(GetJsonFromUrl.class);
        when(getJson.getJsonStrFromUrl(dummyUrl)).thenReturn(jsonStr);

        SourceFormat sourceFormat = new SourceFormat(Source.URL, Format.NOTSIMPLE);
        ParserUrl parser = (ParserUrl) sourceFormat.accept(jsonStr);
        String publishedAt = parser.getArticles().get(0).getPublishedAt();

        assertTrue("2021-03-24T22:32:00Z".equals(publishedAt));
    }

    /**
     * @throws java.lang.Exception
     * @doc check for the first description of the article after parsing
     */
    @Test
    public void checkForCorrectOutputDescription() throws IOException {
        GetJsonFromUrl getJson = Mockito.mock(GetJsonFromUrl.class);
        when(getJson.getJsonStrFromUrl(dummyUrl)).thenReturn(jsonStr);

        SourceFormat sourceFormat = new SourceFormat(Source.URL, Format.NOTSIMPLE);
        ParserUrl parser = (ParserUrl) sourceFormat.accept(jsonStr);
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
        GetJsonFromUrl getJson = Mockito.mock(GetJsonFromUrl.class);
        when(getJson.getJsonStrFromUrl(dummyUrl)).thenReturn(jsonStr);

        SourceFormat sourceFormat = new SourceFormat(Source.URL, Format.NOTSIMPLE);
        ParserUrl parser = (ParserUrl) sourceFormat.accept(jsonStr);
        int articleLength = parser.getArticles().size();

        assertEquals(2, articleLength);
    }

}
