package dataProviders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

import managers.FileReaderManager;

public class JsonFileReader {
	private static String jsonPath = FileReaderManager.getInstance().getPropertyFileDataReader().getTestDataResourcePath()
			+ "jsonData/jsonData.json";

	public static String JsonDataReader(String key) throws FileNotFoundException, IOException, ParseException {
		String value = null;
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(jsonPath));
		for (Object jsonObject : jsonArray) {
			JSONObject person = (JSONObject) jsonObject;

			value = (String) person.get(key);
			return value;
		}
		return value;
	}
}
