package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Build extends Symbol {
	List<String> listOfBuild;
	String build_Value;

	String[] listofValidBuild;

	public Build() {
		listOfBuild = new ArrayList<String>();
		String builds = "Build";
		String[] eachNoun = builds.split(" ");

		listofValidBuild = eachNoun;
		for (int i = 0; i < eachNoun.length; i++) {
			listOfBuild.add(i, eachNoun[i]);
		}
	}

	public List<String> getListOfNouns() {
		return listOfBuild;
	}

	public boolean isBuild(String word) {
		String checkWord = "";
		char[] val = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			checkWord += val[i] + "";
		}

		if (listOfBuild.contains(checkWord)) {
			return true;
		} else {
			return false;
		}

	}

	public List<String> getListOfBuild() {
		return listOfBuild;
	}

	public void setListOfBuild(List<String> listOfBuild) {
		this.listOfBuild = listOfBuild;
	}

	public String getBuild_Value() {
		return build_Value;
	}

	public void setBuild_Value(String build_Value) {
		this.build_Value = build_Value;
	}

	public String[] getListofValidBuild() {
		return listofValidBuild;
	}

	public void setListofValidBuild(String[] listofValidBuild) {
		this.listofValidBuild = listofValidBuild;
	}

	@Override
	public String toString() {
		return build_Value;
	}
}
