package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adverb extends Symbol {
	List<String> listOfAdverbs;
	String adverb_Value;

	String[] listOfValidAdverbs;

	public Adverb() {
		listOfAdverbs = new ArrayList<String>();
		String adverbs = "often still before then today weekly now daily";
		String[] eachAdverbs = adverbs.split(" ");

		listOfValidAdverbs = eachAdverbs;

		for (int i = 0; i < eachAdverbs.length; i++) {
			listOfAdverbs.add(i, eachAdverbs[i]);
		}
	}

	
	public boolean isAdverb(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfAdverbs.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public List<String> getListOfAdverbs() {
		return listOfAdverbs;
	}

	public void setListOfAdverbs(List<String> listOfAdverbs) {
		this.listOfAdverbs = listOfAdverbs;
	}

	public String getAdverb_Value() {
		return adverb_Value;
	}

	public void setAdverb_Value(String adverb_Value) {
		this.adverb_Value = adverb_Value;
	}

	public String[] getListOfValidAdverbs() {
		return listOfValidAdverbs;
	}

	public void setListOfValidAdverbs(String[] listOfValidAdverbs) {
		this.listOfValidAdverbs = listOfValidAdverbs;
	}

	@Override
	public String toString() {
		return adverb_Value;
	}
}
