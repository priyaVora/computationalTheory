package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Nominative_Case extends Symbol {
	private Adjective adjective;

	private Noun noun;

	public Nominative_Case() {

	}

	public Adjective getAdjective() {
		return adjective;
	}

	public void setAdjective(Adjective adjective) {
		this.adjective = adjective;
	}

	public Noun getNoun() {
		return noun;
	}

	public void setNoun(Noun noun) {
		this.noun = noun;
	}

	public boolean isNom(Noun noun) {
		Noun checkNoun = new Noun();
		boolean check = checkNoun.isNoun(noun.getSymbol());
		if (check == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		if (adjective != null) {

			return "[adjective=" + adjective + ", noun=" + noun + "]";
		} else {
			return "[noun=" + noun + "]";
		}
	}

	public String getNomCombination() {
		if (adjective != null) {

			return adjective.getAdjectiveValue() + " " + noun.getNoun_Value();
		} else {
			return noun.getNoun_Value();
		}
	}

}
