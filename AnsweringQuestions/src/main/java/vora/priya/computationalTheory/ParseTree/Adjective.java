package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Adjective extends Symbol {
	List<String> listOfAdjectives;
	String adjectiveValue;

	String[] listOfValidAdjectives;

	public Adjective() {
		listOfAdjectives = new ArrayList<String>();
		String adjs = "shortest";
		String[] eachAdj = adjs.split(" ");
		listOfValidAdjectives = eachAdj;

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
			checkWord += val[i] + "";
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

	@Override
	public String toString() {
		return adjectiveValue;
	}

	public String[] getListOfValidAdjectives() {
		return listOfValidAdjectives;
	}

	public void setListOfValidAdjectives(String[] listOfValidAdjectives) {
		this.listOfValidAdjectives = listOfValidAdjectives;
	}

}
