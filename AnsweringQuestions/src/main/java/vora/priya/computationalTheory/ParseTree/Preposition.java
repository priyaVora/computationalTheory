package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preposition extends Symbol {

	List<String> listOfPreps;
	String prep_Value;

	String[] listofValidPreps;

	public Preposition() {
		listOfPreps = new ArrayList<String>();
		String preps = "for";
		String[] eachPreps = preps.split(" ");

		listofValidPreps = eachPreps;
		for (int i = 0; i < eachPreps.length; i++) {
			listOfPreps.add(i, eachPreps[i]);
		}
	}

	public List<String> getListOfNouns() {
		return listOfPreps;
	}

	public boolean isPrep(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfPreps.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public List<String> getListOfPreps() {
		return listOfPreps;
	}

	public void setListOfPreps(List<String> listOfPreps) {
		this.listOfPreps = listOfPreps;
	}

	public String getPrep_Value() {
		return prep_Value;
	}

	public void setPrep_Value(String prep_Value) {
		this.prep_Value = prep_Value;
	}

	public String[] getListofValidPreps() {
		return listofValidPreps;
	}

	public void setListofValidPreps(String[] listofValidPreps) {
		this.listofValidPreps = listofValidPreps;
	}

	@Override
	public String toString() {
		return prep_Value;
	}

}
