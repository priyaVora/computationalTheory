package vora.priya.computationalTheory.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Determiner {
	List<String> listOfDeterminer;

	public Determiner() {
		listOfDeterminer = new ArrayList<String>();
		String determiners = "The an that this my his her";
		String[] eachDet = determiners.split(" ");

		for (int i = 0; i < eachDet.length; i++) {
			listOfDeterminer.add(i, eachDet[i]);
		}
	}

	public List<String> getListOfDeterminer() {
		return listOfDeterminer;
	}
}
