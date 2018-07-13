package vora.priya.computationalTheory.Tokenizer;

public class Noun_Phrase {
	private Determiner determiner;
	private Nominative_Case nominative_Case;

	public Noun_Phrase() {

	}

	public Determiner getDeterminer() {
		return determiner;
	}

	public void setDeterminer(Determiner determiner) {
		this.determiner = determiner;
	}

	public Nominative_Case getNominative_Case() {
		return nominative_Case;
	}

	public void setNominative_Case(Nominative_Case nominative_Case) {
		this.nominative_Case = nominative_Case;
	}
}
