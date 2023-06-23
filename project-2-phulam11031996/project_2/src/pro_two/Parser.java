package pro_two;

import java.io.IOException;
import java.util.List;

public interface Parser {

	List<Article> parseFile(String fileName) throws IOException;

}
