package pro_three;

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

		System.out.println("News API--------------------");
		SourceFormat sourceFormat = new SourceFormat(Source.FILE, Format.NOTSIMPLE);
		Parser parser = sourceFormat.accept(newsApiFile);
		System.out.println(parser);

		System.out.println("URL-------------------------");
		sourceFormat = new SourceFormat(Source.URL, Format.NOTSIMPLE);
		GetJsonFromUrl getJson = new GetJsonFromUrl();
		String jsonStr = getJson.getJsonStrFromUrl(urlStr);
		parser = sourceFormat.accept(jsonStr);
		System.out.println(parser);

		System.out.println("Simple----------------------");
		sourceFormat = new SourceFormat(Source.FILE, Format.SIMPLE);
		parser = sourceFormat.accept(simpleFile);
		System.out.println(parser);
	}

}
