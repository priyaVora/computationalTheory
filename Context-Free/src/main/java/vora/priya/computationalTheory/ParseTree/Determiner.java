package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Determiner extends Symbol {
	List<String> listOfDeterminer;
	String determiner_Value; 

	public Determiner() {
		listOfDeterminer = new ArrayList<String>();
		String determiners = "the an that this my his her";
		String[] eachDet = determiners.split(" ");

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
			checkWord += val[i] + "".toLowerCase();
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
}
