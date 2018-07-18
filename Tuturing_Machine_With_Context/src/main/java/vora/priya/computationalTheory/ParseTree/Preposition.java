package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Preposition extends Symbol {
	List<String> listOfPreposition;
	String preposition_Value;

	String[] listOfValidPreposition;

	public Preposition() {
		listOfPreposition = new ArrayList<String>();
		String preposition = "with at during until despite toward from";
		String[] eachPreposition = preposition.split(" ");

		listOfValidPreposition = eachPreposition;

		for (int i = 0; i < eachPreposition.length; i++) {
			listOfPreposition.add(i, eachPreposition[i]);
		}
	}

	public boolean isPreposition(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfPreposition.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public List<String> getListOfPreposition() {
		return listOfPreposition;
	}

	public void setListOfPreposition(List<String> listOfPreposition) {
		this.listOfPreposition = listOfPreposition;
	}

	public String getPreposition_Value() {
		return preposition_Value;
	}

	public void setPreposition_Value(String preposition_Value) {
		this.preposition_Value = preposition_Value;
	}

	public String[] getListOfValidPreposition() {
		return listOfValidPreposition;
	}

	public void setListOfValidPreposition(String[] listOfValidPreposition) {
		this.listOfValidPreposition = listOfValidPreposition;
	}

	@Override
	public String toString() {
		return preposition_Value;
	}
}
