package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Verb extends Symbol {
	List<String> listOfVerbs;
	String verb_Value;

	public Verb() {
		listOfVerbs = new ArrayList<String>();
		String verbs = "chased pushed walked moved ate ";
		String[] eachVerb = verbs.split(" ");

		for (int i = 0; i < eachVerb.length; i++) {
			listOfVerbs.add(i, eachVerb[i]);
		}
	}

	public List<String> getListOfVerbs() {
		return listOfVerbs;
	}

	public boolean isVerb(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfVerbs.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public String getVerb_Value() {
		return verb_Value;
	}

	public void setVerb_Value(String verb_Value) {
		this.verb_Value = verb_Value;
	}

	@Override
	public String toString() {
		return verb_Value;
	}

}
