package vora.priya.computationalTheory.ParseTree;

public class Verb_Phrase extends Symbol {
	Noun noun_before;
	Special_Verb special_verb;
	Noun noun_after;

	public Verb_Phrase() {

	}

	public Noun getNoun_before() {
		return noun_before;
	}

	public void setNoun_before(Noun noun_before) {
		this.noun_before = noun_before;
	}

	public Special_Verb getSpecial_verb() {
		return special_verb;
	}

	public void setSpecial_verb(Special_Verb special_verb) {
		this.special_verb = special_verb;
	}

	public Noun getNoun_after() {
		return noun_after;
	}

	public void setNoun_after(Noun noun_after) {
		this.noun_after = noun_after;
	}

	@Override
	public String toString() {
		return "Verb_Phrase [noun_before=" + noun_before + ", special_verb=" + special_verb + ", noun_after="
				+ noun_after + "]";
	}

}
