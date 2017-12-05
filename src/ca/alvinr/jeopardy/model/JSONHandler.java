package ca.alvinr.jeopardy.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.JSONException;
import org.json.JSONObject;

import ca.alvinr.jeopardy.JeopardyException;

public class JSONHandler {

	private JSONObject qJSON;
	
	public JSONHandler(String URI) throws JeopardyException {
		File qFile = new File(URI);
		qJSON = readDataJSON(qFile);
	}
	
	private JSONObject readDataJSON(File qFile) throws JeopardyException {
		if (qFile == null) {
			throw new JeopardyException("Error when accessing 'data.json', which contains Jeopardy Trivia.");
		}

		InputStream is;
		try {
			is = new FileInputStream(qFile);

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			is.close();
			return json;
		} catch (IOException ioe) {
			throw new JeopardyException("Error when accessing 'data.json', which contains Jeopardy Trivia.");
		} catch(JSONException jsone) {
			throw new JeopardyException("Error when parsing 'data.json'; malformed JSON.");
		}
	}
	
	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	
	public JSONObject getJSON() throws JeopardyException {
		return qJSON;
	}
	
	@Override
	public String toString() {
		if(qJSON == null) {
			return null;
		}
		return qJSON.toString();
	}
}
