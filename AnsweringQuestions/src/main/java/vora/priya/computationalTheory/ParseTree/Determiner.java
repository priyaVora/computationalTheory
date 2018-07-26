package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Determiner extends Symbol {
	List<String> listOfDeterminer;
	String determiner_Value;

	String[] listOfValidDeterminers;

	public Determiner() {
		listOfDeterminer = new ArrayList<String>();
		String determiners = "A What what the those a";
		String[] eachDet = determiners.split(" ");

		listOfValidDeterminers = eachDet;

		for (int i = 0; i < eachDet.length; i++) {
			listOfDeterminer.add(i, eachDet[i]);
		}
	}

	public List<String> getListOfDeterminer() {
		return listOfDeterminer;
	}

	public boolean isDeterminant(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toUpperCase();
		}

		if (listOfDeterminer.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public String getDeterminer_Value() {
		return determiner_Value;
	}

	public void setDeterminer_Value(String determiner_Value) {
		this.determiner_Value = determiner_Value;
	}

	@Override
	public String toString() {
		return determiner_Value;
	}

	public String[] getListOfValidDeterminers() {
		return listOfValidDeterminers;
	}

	public void setListOfValidDeterminers(String[] listOfValidDeterminers) {
		this.listOfValidDeterminers = listOfValidDeterminers;
	}

}
