package project_one;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static String fileName = "bad.json";

    public static void main(String[] args) throws IOException {
        FileHandler fh;
        fh = new FileHandler("Logger.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.setUseParentHandlers(false);

        Parser parser = new Parser(logger);

        parser.parseFile(fileName);
        parser.removeAndLogBadArticles();
        System.out.println(parser);

    }

}