package vora.priya.computationalTheory.ParseTree;

public class QuestionPartTwo extends Symbol {
	Preposition preposition = new Preposition();
	Determiner determiner = new Determiner();
	Noun noun = new Noun();

	public QuestionPartTwo() {

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

	@Override
	public String toString() {
		return "[preposition=" + preposition + ", determiner=" + determiner + ", noun=" + noun + "]";
	}

}
