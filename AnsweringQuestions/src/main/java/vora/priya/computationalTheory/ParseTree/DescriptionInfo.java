package vora.priya.computationalTheory.ParseTree;

public class DescriptionInfo {
	private Noun noun;
	private Verb verb;

	public DescriptionInfo() {

	}

	public Noun getNoun() {
		return noun;
	}

	public void setNoun(Noun noun) {
		this.noun = noun;
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	@Override
	public String toString() {
		return "[noun=" + noun + ", verb=" + verb + "]";
	}
}
