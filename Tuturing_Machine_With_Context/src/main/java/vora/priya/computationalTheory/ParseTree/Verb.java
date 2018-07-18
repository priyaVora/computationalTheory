package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Verb extends Symbol {
	List<String> listOfVerbs;
	String verb_Value;

	String[] listOfValidVerb;

	public Verb() {
		listOfVerbs = new ArrayList<String>();
		String verbs = "playing watching doing eating baking walking";
		String[] eachVerbs = verbs.split(" ");

		listOfValidVerb = eachVerbs;

		for (int i = 0; i < eachVerbs.length; i++) {
			listOfVerbs.add(i, eachVerbs[i]);
		}
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
	

	public List<String> getListOfVerbs() {
		return listOfVerbs;
	}


	public void setListOfVerbs(List<String> listOfVerbs) {
		this.listOfVerbs = listOfVerbs;
	}


	public String getVerb_Value() {
		return verb_Value;
	}


	public void setVerb_Value(String verb_Value) {
		this.verb_Value = verb_Value;
	}


	public String[] getListOfValidVerb() {
		return listOfValidVerb;
	}


	public void setListOfValidVerb(String[] listOfValidVerb) {
		this.listOfValidVerb = listOfValidVerb;
	}


	@Override
	public String toString() {
		return verb_Value;
	}
}
