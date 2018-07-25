package vora.priya.computationalTheory.ParseTree;

public class QuestionPartOne extends Symbol {
	Determiner determiner = new Determiner();
	Verb verb = new Verb();
	Determiner determiner2 = new Determiner();

	public QuestionPartOne() {

	}

	public Determiner getDeterminer() {
		return determiner;
	}

	public void setDeterminer(Determiner determiner) {
		this.determiner = determiner;
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	public Determiner getDeterminer2() {
		return determiner2;
	}

	public void setDeterminer2(Determiner determiner2) {
		this.determiner2 = determiner2;
	}

	@Override
	public String toString() {
		return "[determiner=" + determiner + ", verb=" + verb + ", determiner2=" + determiner2 + "]";
	}

}
