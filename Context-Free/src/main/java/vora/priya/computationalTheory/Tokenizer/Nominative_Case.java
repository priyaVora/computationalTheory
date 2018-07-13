package vora.priya.computationalTheory.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Nominative_Case {
	private Adjective adjective;
	private Nominative_Case nominative_case;
	private Noun noun;

	private Nominative_Case() {

	}

	private Nominative_Case(Adjective adjective, Nominative_Case nominative_case) {
		this.adjective = adjective;
		this.nominative_case = nominative_case;
	}

	public Nominative_Case(Noun noun) {

	}

	public Nominative_Case(Adjective adjective, Noun noun) {
		this.adjective = adjective;
		this.noun = noun;
	}

	public Adjective getAdjective() {
		return adjective;
	}

	public void setAdjective(Adjective adjective) {
		this.adjective = adjective;
	}

	public Nominative_Case getNominative_case() {
		return nominative_case;
	}

	public void setNominative_case(Nominative_Case nominative_case) {
		this.nominative_case = nominative_case;
	}

	public Noun getNoun() {
		return noun;
	}

	public void setNoun(Noun noun) {
		this.noun = noun;
	}
}
