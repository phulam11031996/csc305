package lab_8d;

import java.util.concurrent.Semaphore;

public class AlternatingThreadExample {

	  private static final int MAX_TIMES = 100;

	  /**
	   * Demonstration of the use of a Semaphore.
	   *
	   * @param args command-line arguments, not used
	   */
	  public static void main(String[] args) {

		Semaphore evenSemaphore = new Semaphore(0, false);
		Semaphore oddSemaphore = new Semaphore(1, false);

		WordPrinter wordPrinter1 = new WordPrinter("hello", MAX_TIMES, evenSemaphore, oddSemaphore);
		WordPrinter wordPrinter2 = new WordPrinter("hi", MAX_TIMES, evenSemaphore, oddSemaphore);

		new Thread(wordPrinter1).start();
		new Thread(wordPrinter2).start() ;
	    
	  }
}
