package pro_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class GetJsonFromUrl {
	String getJsonStrFromUrl(String urlStr) {

		StringBuilder jsonStr = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) urlConnection;

			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String current;

			while ((current = in.readLine()) != null) {
				jsonStr.append(current);
			}

			return jsonStr.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr.toString();
	}

}
