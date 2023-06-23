package pro_two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection; 

public class Main {
    static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static String newsapiFile = "inputs/newsapi.txt";
    static String simpleFile = "inputs/simple.txt";
    static String url = "http://newsapi.org/v2/top-headlines?country=us&apiKey=b79afa9aa64f4633a50060d2e187650e";

    static String getJsonStrFromFile(String fileName) {
        StringBuilder jsonStr = new StringBuilder();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                jsonStr.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return jsonStr.toString();
    } 

    static String getJsonStrFromUrl(String urlStr) {
        StringBuilder jsonStr = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) urlConnection;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String current;

            while((current = in.readLine()) != null) {
                jsonStr.append(current);
            }

            return jsonStr.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr.toString();

    }


    public static void main(String[] args) throws IOException {
        FileHandler fh;
        fh = new FileHandler("Logger.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.setUseParentHandlers(false);


        System.out.println("Simple file\n");
        
        Parser parser = new ParserSimple(logger);
        String jsonStr = getJsonStrFromFile(simpleFile);
        parser.parseFile(jsonStr);
        System.out.println(parser);


        System.out.println("News API file\n");

        parser = new ParserNewsAPI(logger);
        jsonStr = getJsonStrFromFile(newsapiFile);
        parser.parseFile(jsonStr);
        System.out.println(parser);

    }

}