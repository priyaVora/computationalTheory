package vora.priya.computationalTheory.Tokenizer;

public class Sentence {
	private Noun_Phrase noun_Phrase;
	private Verb_Phrase verb_Phrase;

	public void Sentence() {
		
	}

	public void Sentence(Noun_Phrase noun_Phrase, Verb_Phrase verb_Phrase) {
		this.noun_Phrase = noun_Phrase;
		this.verb_Phrase = verb_Phrase;
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
