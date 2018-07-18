package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Special_Verb extends Symbol {
	Description_Verb desc_verb;
	Verb verb;

	public Special_Verb() {

	}

	public Description_Verb getDesc_verb() {
		return desc_verb;
	}

	public void setDesc_verb(Description_Verb desc_verb) {
		this.desc_verb = desc_verb;
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	@Override
	public String toString() {
		return "Special_Verb [desc_verb=" + desc_verb + ", verb=" + verb + "]";
	}
}
