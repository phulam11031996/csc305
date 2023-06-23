package lab_6b;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class Driver {

	public static void main(String[] args) {

		try {
			int c;
			InputStream input = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("info.txt")));

			while((c = input.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
