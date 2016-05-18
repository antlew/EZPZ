package com.site.object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class API {

	public static JSONObject getObject() throws MalformedURLException, IOException, ProtocolException, JSONException {

		StringBuilder stringBuilder = new StringBuilder();
		String jsonString = "";

		URL url = new URL(
				"https://api.nutritionix.com/v1_1/item?id=57276be8c18f872528f73a5b&appId=&appKey=");
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

		bufferedReader.close();
		return obj;
	}


	public static String[] getData() throws MalformedURLException, ProtocolException, IOException, JSONException{
		String[] params = new String[5];
		String[] objParams = {"nf_protein","nf_total_carbohydrate","nf_dietary_fiber", "nf_calories"};
		JSONObject obj = getObject();
		double value;
		
		params[0] = obj.getString("item_name");
		
		for(int i=0; i < objParams.length; i++){
			value = obj.getDouble(objParams[i]);
			params[i+1] = Double.toString(value);
		}
	
		return params;
	}
		

}
