package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class KM extends Symbol {
	List<String> listOfKilometers;
	String km_Value;

	String[] listOfValidKiloMeters;

	public KM() {
		listOfKilometers = new ArrayList<String>();
		String determiners = "KM km";
		String[] eachDet = determiners.split(" ");

		listOfValidKiloMeters = eachDet;

		for (int i = 0; i < eachDet.length; i++) {
			listOfKilometers.add(i, eachDet[i]);
		}
	}

	public boolean isKM(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfKilometers.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public List<String> getListOfKilometers() {
		return listOfKilometers;
	}

	public void setListOfKilometers(List<String> listOfKilometers) {
		this.listOfKilometers = listOfKilometers;
	}

	public String getKm_Value() {
		return km_Value;
	}

	public void setKm_Value(String km_Value) {
		this.km_Value = km_Value;
	}

	public String[] getListOfValidKiloMeters() {
		return listOfValidKiloMeters;
	}

	public void setListOfValidKiloMeters(String[] listOfValidKiloMeters) {
		this.listOfValidKiloMeters = listOfValidKiloMeters;
	}

	@Override
	public String toString() {
		return km_Value;
	}

}
