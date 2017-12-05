package ca.alvinr.jeopardy.model;

import ca.alvinr.jeopardy.JeopardyException;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionSet {

	private static QuestionSet instance;
	private static JSONObject qJSON;
	private static JSONHandler jsonHandler;

	private QuestionSet() throws JeopardyException {
		jsonHandler = new JSONHandler("WebContent/data.json");
		qJSON = jsonHandler.getJSON();
	}

	public static QuestionSet getInstance() throws JeopardyException {
		if (instance == null) {
			instance = new QuestionSet();
		}
		return instance;
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
