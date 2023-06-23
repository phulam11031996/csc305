package lab_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Document {

	/**
	 * document filename from which to read from and write into
	 */
	public static final String filename="text.txt";

	/**
	 * reads content from the file and displays to the terminal
	 */
	void readFile() {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}		

	/**
	 * writes the String "CSE 305, Cal Poly" into the file
	 */
	void writeFile() {
		try {
			FileWriter myWriter = new FileWriter(filename);
			myWriter.append("CSC 305, Cal Poly\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
