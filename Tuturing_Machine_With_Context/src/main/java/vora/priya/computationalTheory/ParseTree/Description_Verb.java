package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Description_Verb extends Symbol {
	List<String> listOfDescriptionVerbs;
	String descriptionVerb_Value;

	String[] listOfValidDescriptionVerb;

	public Description_Verb() {
		listOfDescriptionVerbs = new ArrayList<String>();
		String descriptionVerb = "loves loved hates hated likes like hate love";
		String[] eachDescriptionVerb = descriptionVerb.split(" ");

		listOfValidDescriptionVerb = eachDescriptionVerb;

		for (int i = 0; i < eachDescriptionVerb.length; i++) {
			listOfDescriptionVerbs.add(i, eachDescriptionVerb[i]);
		}
	}

	public boolean isDescriptionVerb(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "".toLowerCase();
		}

		if (listOfDescriptionVerbs.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public List<String> getListOfDescriptionVerbs() {
		return listOfDescriptionVerbs;
	}

	public void setListOfDescriptionVerbs(List<String> listOfDescriptionVerbs) {
		this.listOfDescriptionVerbs = listOfDescriptionVerbs;
	}

	public String getDescriptionVerb_Value() {
		return descriptionVerb_Value;
	}

	public void setDescriptionVerb_Value(String descriptionVerb_Value) {
		this.descriptionVerb_Value = descriptionVerb_Value;
	}

	public String[] getListOfValidDescriptionVerb() {
		return listOfValidDescriptionVerb;
	}

	public void setListOfValidDescriptionVerb(String[] listOfValidDescriptionVerb) {
		this.listOfValidDescriptionVerb = listOfValidDescriptionVerb;
	}

	@Override
	public String toString() {
		return descriptionVerb_Value;
	}

}
