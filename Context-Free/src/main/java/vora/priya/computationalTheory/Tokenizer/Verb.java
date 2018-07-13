package vora.priya.computationalTheory.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Verb {
	List<String> listOfVerbs;

	public Verb() {
		listOfVerbs = new ArrayList<String>();
		String verbs = "gave raises going morning eat";
		String[] eachVerb = verbs.split(" ");

		for (int i = 0; i < eachVerb.length; i++) {
			listOfVerbs.add(i, eachVerb[i]);
		}
	}

	public List<String> getListOfVerbs() {
		return listOfVerbs;
	}
}
