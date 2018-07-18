package vora.priya.computationalTheory.ParseTree;

public class Noun_Phrase {
	Preposition preposition;
	Determiner determiner;
	Noun noun;

	Noun_Phrase noun_phrase;

	public Noun_Phrase() {

	}

	public Preposition getPreposition() {
		return preposition;
	}

	public void setPreposition(Preposition preposition) {
		this.preposition = preposition;
	}

	public Determiner getDeterminer() {
		return determiner;
	}

	public void setDeterminer(Determiner determiner) {
		this.determiner = determiner;
	}

	public Noun getNoun() {
		return noun;
	}

	public void setNoun(Noun noun) {
		this.noun = noun;
	}

	public Noun_Phrase getNoun_phrase() {
		return noun_phrase;
	}

	public void setNoun_phrase(Noun_Phrase noun_phrase) {
		this.noun_phrase = noun_phrase;
	}

	@Override
	public String toString() {
		return "Noun_Phrase [preposition=" + preposition + ", determiner=" + determiner + ", noun=" + noun
				+ ", noun_phrase=" + noun_phrase + "]";
	}

}
