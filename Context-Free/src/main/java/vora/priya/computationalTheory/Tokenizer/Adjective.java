package vora.priya.computationalTheory.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Adjective {
	List<String> listOfAdjectives;

	public Adjective() {
		listOfAdjectives = new ArrayList<String>();
		String adjs = "depressed important friendly";
		String[] eachAdj = adjs.split(" ");

		for (int i = 0; i < eachAdj.length; i++) {
			listOfAdjectives.add(i, eachAdj[i]);
		}
	}

	public List<String> getListOfAdjectives() {
		return listOfAdjectives;
	}
}
