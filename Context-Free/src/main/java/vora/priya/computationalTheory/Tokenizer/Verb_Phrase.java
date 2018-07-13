package vora.priya.computationalTheory.Tokenizer;

public class Verb_Phrase {
	private Verb verb;
	private Noun_Phrase noun_Phrase;

	public Verb_Phrase() {
		this.setNoun_Phrase(noun_Phrase);
		this.setVerb(verb);
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	public Noun_Phrase getNoun_Phrase() {
		return noun_Phrase;
	}

	public void setNoun_Phrase(Noun_Phrase noun_Phrase) {
		this.noun_Phrase = noun_Phrase;
	}
}
