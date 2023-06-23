package pro_four;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static String newsApiFile = "inputs/newsapi.txt";
	static String simpleFile = "inputs/simple.txt";
	static String urlStr = "http://newsapi.org/v2/top-headlines?country=us&apiKey=b79afa9aa64f4633a50060d2e187650e";

	public static void main(String[] args) throws IOException {
		FileHandler fh;
		fh = new FileHandler("Logger.txt");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		logger.setUseParentHandlers(false);

		System.out.println("\nNEWS API - WITH FILTER");
		SourceFormat sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE, InputArticleSource.CNN);
		Parser parser = sourceFormat.accept(newsApiFile);
		System.out.println(parser);

		System.out.println("\nNEWS API - WITH NO FILTER");
		sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.NOTSIMPLE);
		parser = sourceFormat.accept(newsApiFile);
		System.out.println(parser);

		System.out.println("\nURL - WITH FILTER");
		sourceFormat = new SourceFormat(InputSource.URL, InputFormat.NOTSIMPLE, InputArticleSource.CNBC);
		GetJsonFromUrl getJson = new GetJsonFromUrl();
		String jsonStr = getJson.getJsonStrFromUrl(urlStr);
		parser = sourceFormat.accept(jsonStr);
		System.out.println(parser);

		System.out.println("\nURL - WITH NO FILTER");
		sourceFormat = new SourceFormat(InputSource.URL, InputFormat.NOTSIMPLE);
		getJson = new GetJsonFromUrl();
		jsonStr = getJson.getJsonStrFromUrl(urlStr);
		parser = sourceFormat.accept(jsonStr);
		System.out.println(parser);

		System.out.println("\nSIMPLE----------------------");
		sourceFormat = new SourceFormat(InputSource.FILE, InputFormat.SIMPLE);
		parser = sourceFormat.accept(simpleFile);
		System.out.println(parser);

	}

}
