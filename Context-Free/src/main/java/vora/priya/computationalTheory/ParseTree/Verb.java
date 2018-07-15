package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Verb extends Symbol {
	List<String> listOfVerbs;

	public Verb() {
		listOfVerbs = new ArrayList<String>();
		String verbs = " chased gave raises going morning eat";
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
}
