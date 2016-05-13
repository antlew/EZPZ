package com.site.object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Recipes {

	public static String[] getTitles() throws MalformedURLException, ProtocolException, IOException, JSONException {
		String[] titles =  new String[30];
		JSONArray recipes = getArray();
		JSONObject test;

		for (int i = 0; i < 30; i++) {
			test = recipes.getJSONObject(i);
			String title = test.getString("title");
			titles[i] = title;
		}
		return titles;
	}

	public static JSONArray getArray()
			throws MalformedURLException, IOException, ProtocolException, JSONException {
		
		StringBuilder stringBuilder = new StringBuilder();
		String jsonString = "";
		
		URL url = new URL("http://food2fork.com/api/search?key= ~~~KEY~~~ &q=chicken");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = "";

		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}

		jsonString = stringBuilder.toString();

		JSONObject obj = new JSONObject(jsonString);
		JSONArray recipes = obj.getJSONArray("recipes");
		bufferedReader.close();
		return recipes;
	}

}
