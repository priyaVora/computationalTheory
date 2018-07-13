package vora.priya.computationalTheory.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Noun {
	List<String> listOfNouns;

	public Noun() {
		listOfNouns = new ArrayList<String>();
		String nouns = "cotton rice tree San_Francisco";
		String[] eachNoun = nouns.split(" ");
		for (int i = 0; i < eachNoun.length; i++) {
			listOfNouns.add(i, eachNoun[i]);
		}
	}

	public List<String> getListOfNouns() {
		return listOfNouns;
	}
}
