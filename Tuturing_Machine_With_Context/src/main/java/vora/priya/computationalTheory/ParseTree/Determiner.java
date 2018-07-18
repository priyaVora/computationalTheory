package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Determiner extends Symbol {
	List<String> listOfDeterminer;
	String det_Value;

	String[] listOfValidDeterminers;

	public Determiner() {
		listOfDeterminer = new ArrayList<String>();
		String det = "the a that this these his her my all most";
		String[] eachDet = det.split(" ");

		listOfValidDeterminers = eachDet;

		for (int i = 0; i < eachDet.length; i++) {
			listOfDeterminer.add(i, eachDet[i]);
		}
	}

	public boolean isDeterminer(String word) {
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

	public List<String> getListOfDeterminer() {
		return listOfDeterminer;
	}

	public void setListOfDeterminer(List<String> listOfDeterminer) {
		this.listOfDeterminer = listOfDeterminer;
	}

	public String getDet_Value() {
		return det_Value;
	}

	public void setDet_Value(String det_Value) {
		this.det_Value = det_Value;
	}

	public String[] getListOfValidDeterminers() {
		return listOfValidDeterminers;
	}

	public void setListOfValidDeterminers(String[] listOfValidDeterminers) {
		this.listOfValidDeterminers = listOfValidDeterminers;
	}

	@Override
	public String toString() {
		return det_Value;
	}
}
