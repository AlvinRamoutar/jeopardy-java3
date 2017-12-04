package ca.alvinr.jeopardy.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import ca.alvinr.jeopardy.JeopardyException;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionSet {

	private static QuestionSet instance;
	private static JSONObject qJSON;

	private QuestionSet() throws JeopardyException {
		File qFile = new File("WebContent/data.json");
		qJSON = readDataJSON(qFile);
	}

	public static QuestionSet getInstance() throws JeopardyException {
		if (instance == null) {
			instance = new QuestionSet();
		}
		return instance;
	}

	private static JSONObject readDataJSON(File qFile) throws JeopardyException {
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
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	
	
	
	
	public String getCategoryName(int c) throws JeopardyException {
		try {
			return qJSON.getJSONObject("c" + c).getString("name");
		} catch (JSONException e) {
			throw new JeopardyException("Invalid category number.");
		}
	}
	
	public String getCategoryDesc(int c) throws JeopardyException {
		try {
			return qJSON.getJSONObject("c" + c).getString("description");
		} catch (JSONException e) {
			throw new JeopardyException("Invalid category number.");
		}
	}
	
	public String getCategoryQuestion(int c, int l) throws JeopardyException {
		try {
			return qJSON.getJSONObject("c" + c).getJSONObject("lv" + l).getString("question");
		} catch(JSONException jsone) {
			throw new JeopardyException("Invalid category and/or level number.");
		}
	}
	
	public String[] getCategoryQuestions(int c, int l) throws JeopardyException {
		try {
			String[] questions = new String[4];
			for(int j = 0; j < 4; j++) {
				questions[j] = qJSON.getJSONObject("c" + c).getJSONObject("lv" + l).getString(((char)(j + 97) + "").trim());
			}
			return questions;
		} catch(JSONException jsone) {
			
			throw new JeopardyException("Invalid category and/or level number.");
		}
	}
	
	public String getCategorySpecificChoice(int c, int l, char q) throws JeopardyException {
		String[] questions = getCategoryQuestions(c, l);
		return questions[q - 97];
	}
	
	public String getCategoryQuestionAnswer(int c, int l) throws JeopardyException {
		try {
			return qJSON.getJSONObject("c" + c).getJSONObject("lv" + l).getString("answer");
		} catch (JSONException e) {
			throw new JeopardyException("Invalid category and/or level number.");
		}
	}
	
	@Override
	public String toString() {
		if(qJSON == null) {
			return null;
		}
		return qJSON.toString();
	}
}
