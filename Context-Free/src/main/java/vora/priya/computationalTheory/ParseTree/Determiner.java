package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Determiner extends Symbol {
	List<String> listOfDeterminer;

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
}
