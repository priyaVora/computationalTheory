package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tour extends Symbol {
	List<String> listOfTour;
	String tour_value;

	String[] listOfValidTour;

	public Tour() {
		listOfTour = new ArrayList<String>();
		String nouns = "tour";
		String[] eachNoun = nouns.split(" ");

		listOfValidTour = eachNoun;
		for (int i = 0; i < eachNoun.length; i++) {
			listOfTour.add(i, eachNoun[i]);
		}
	}

	public boolean isTour(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfTour.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public List<String> getListOfTour() {
		return listOfTour;
	}

	public void setListOfTour(List<String> listOfTour) {
		this.listOfTour = listOfTour;
	}

	public String getTour_value() {
		return tour_value;
	}

	public void setTour_value(String tour_value) {
		this.tour_value = tour_value;
	}

	public String[] getListOfValidTour() {
		return listOfValidTour;
	}

	public void setListOfValidTour(String[] listOfValidTour) {
		this.listOfValidTour = listOfValidTour;
	}

	@Override
	public String toString() {
		return tour_value;
	}

}
