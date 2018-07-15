package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Noun extends Symbol {
	List<String> listOfNouns;
	String noun_Value;

	public Noun() {
		listOfNouns = new ArrayList<String>();
		String nouns = " bear squirrel cotton rice tree california";
		String[] eachNoun = nouns.split(" ");
		for (int i = 0; i < eachNoun.length; i++) {
			listOfNouns.add(i, eachNoun[i]);
		}
	}

	public List<String> getListOfNouns() {
		return listOfNouns;
	}

	public boolean isNoun(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfNouns.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public String getNoun_Value() {
		return noun_Value;
	}

	public void setNoun_Value(String noun_Value) {
		this.noun_Value = noun_Value;
	}

}
