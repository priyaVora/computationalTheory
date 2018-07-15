package vora.priya.computationalTheory.ParseTree;

public class Sentence extends Symbol {
	private Noun_Phrase noun_Phrase;
	private Verb_Phrase verb_Phrase;

	public void Sentence() {
		noun_Phrase = null;
		verb_Phrase = null;
	}

	public Noun_Phrase getNoun_Phrase() {
		return noun_Phrase;
	}

	public void setNoun_Phrase(Noun_Phrase noun_Phrase) {
		this.noun_Phrase = noun_Phrase;
	}

	public Verb_Phrase getVerb_Phrase() {
		return verb_Phrase;
	}

	public void setVerb_Phrase(Verb_Phrase verb_Phrase) {
		this.verb_Phrase = verb_Phrase;
	}
}
