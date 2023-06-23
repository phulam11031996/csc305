package lab_8c;

public class WordPrinter implements Runnable {

	String str;
	int num;

	public WordPrinter(String str, int num) {
		this.num = num;
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 0; i <= num; i++)
			System.out.println("WordPrinter " + String.valueOf(i) + " " + this.str);
	}

}
