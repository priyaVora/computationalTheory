package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Noun extends Symbol {
	List<String> listOfNouns;
	String noun_Value;

	String[] listofValidNouns;

	public Noun() {
		listOfNouns = new ArrayList<String>();
		String nouns = "road route cities cities?";
		String[] eachNoun = nouns.split(" ");

		listofValidNouns = eachNoun;
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

	@Override
	public String toString() {
		return noun_Value;
	}

	public String[] getListofValidNouns() {
		return listofValidNouns;
	}

	public void setListofValidNouns(String[] listofValidNouns) {
		this.listofValidNouns = listofValidNouns;
	}

}
