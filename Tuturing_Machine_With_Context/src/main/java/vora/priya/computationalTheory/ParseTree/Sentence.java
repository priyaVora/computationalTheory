package vora.priya.computationalTheory.ParseTree;

public class Sentence extends Symbol {
	private Adverb adverb;
	private Verb_Phrase verb_phrase;
	private Noun_Phrase noun_phrase;

	public Sentence() {
		adverb = null;
		verb_phrase = null;
		noun_phrase = null;
	}

	public Adverb getAdverb() {
		return adverb;
	}

	public void setAdverb(Adverb adverb) {
		this.adverb = adverb;
	}

	public Verb_Phrase getVerb_phrase() {
		return verb_phrase;
	}

	public void setVerb_phrase(Verb_Phrase verb_phrase) {
		this.verb_phrase = verb_phrase;
	}

	public Noun_Phrase getNoun_phrase() {
		return noun_phrase;
	}

	public void setNoun_phrase(Noun_Phrase noun_phrase) {
		this.noun_phrase = noun_phrase;
	}

	@Override
	public String toString() {
		return "Sentence [adverb=" + adverb + ", verb_phrase=" + verb_phrase + ", noun_phrase=" + noun_phrase + "]";
	}
}
