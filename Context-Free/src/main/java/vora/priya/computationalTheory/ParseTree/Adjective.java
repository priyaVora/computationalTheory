package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Adjective extends Symbol{
	List<String> listOfAdjectives;
	String adjectiveValue;

	public Adjective() {
		listOfAdjectives = new ArrayList<String>();
		String adjs = " angry little depressed important friendly";
		String[] eachAdj = adjs.split(" ");

		for (int i = 0; i < eachAdj.length; i++) {
			listOfAdjectives.add(i, eachAdj[i]);
		}
	}

	public List<String> getListOfAdjectives() {
		return listOfAdjectives;
	}

	public boolean isAdjective(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfAdjectives.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public String getAdjectiveValue() {
		return adjectiveValue;
	}

	public void setAdjectiveValue(String adjectiveValue) {
		this.adjectiveValue = adjectiveValue;
	}	
}
