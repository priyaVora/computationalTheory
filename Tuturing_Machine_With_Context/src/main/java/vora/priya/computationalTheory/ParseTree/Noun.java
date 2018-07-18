package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Noun extends Symbol {
	List<String> listOfNouns;
	String noun_Value;

	String[] listOfValidNouns;

	public Noun() {
		listOfNouns = new ArrayList<String>();
		String nouns = "she he I they we all mom dad sister friends break class home movies event party homework"
				+ " golf soccer shows basketball events rooms kids dogs cars cakes cookies pizza fries burgers stress";
		String[] eachNouns = nouns.split(" ");

		listOfValidNouns = eachNouns;

		for (int i = 0; i < eachNouns.length; i++) {
			listOfNouns.add(i, eachNouns[i]);
		}
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

	public List<String> getListOfNouns() {
		return listOfNouns;
	}

	public void setListOfNouns(List<String> listOfNouns) {
		this.listOfNouns = listOfNouns;
	}

	public String getNoun_Value() {
		return noun_Value;
	}

	public void setNoun_Value(String noun_Value) {
		this.noun_Value = noun_Value;
	}

	public String[] getListOfValidNouns() {
		return listOfValidNouns;
	}

	public void setListOfValidNouns(String[] listOfValidNouns) {
		this.listOfValidNouns = listOfValidNouns;
	}

	@Override
	public String toString() {
		return noun_Value;
	}
}
