package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Conjunction extends Symbol {
	List<String> listOfConjunction;
	String conjunction_Value;

	String[] listOfValidConjunctions;

	public Conjunction() {
		listOfConjunction = new ArrayList<String>();
		String determiners = "and";
		String[] eachDet = determiners.split(" ");

		listOfValidConjunctions = eachDet;

		for (int i = 0; i < eachDet.length; i++) {
			listOfConjunction.add(i, eachDet[i]);
		}
	}

	public boolean isConjunction(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toUpperCase();
		}

		if (listOfConjunction.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return conjunction_Value;
	}

	public List<String> getListOfConjunction() {
		return listOfConjunction;
	}

	public void setListOfConjunction(List<String> listOfConjunction) {
		this.listOfConjunction = listOfConjunction;
	}

	public String getConjunction_Value() {
		return conjunction_Value;
	}

	public void setConjunction_Value(String conjunction_Value) {
		this.conjunction_Value = conjunction_Value;
	}

	public String[] getListOfValidConjunctions() {
		return listOfValidConjunctions;
	}

	public void setListOfValidConjunctions(String[] listOfValidConjunctions) {
		this.listOfValidConjunctions = listOfValidConjunctions;
	}

}
