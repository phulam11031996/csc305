package TaskOne;

import java.io.IOException;

import org.json.JSONException;

class Main {

	public static void main(String[] args) throws JSONException, IOException {
		String[] fileNames = new String[] { "input1.json", "input2.json", "input3.json" };
		OrgParseJSON task1 = new OrgParseJSON();
		for (String fileName : fileNames) {
			task1.readFile(fileName);
			System.out.println(task1);
		}
	}
}