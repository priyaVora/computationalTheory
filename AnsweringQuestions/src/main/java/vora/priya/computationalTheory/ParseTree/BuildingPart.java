package vora.priya.computationalTheory.ParseTree;

public class BuildingPart extends Symbol {
	private Build build;
	private Determiner det;
	private Tour tourset;
	private Verb verb;

	public BuildingPart() {

	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public Determiner getDet() {
		return det;
	}

	public void setDet(Determiner det) {
		this.det = det;
	}

	public Tour getTourset() {
		return tourset;
	}

	public void setTourset(Tour tourset) {
		this.tourset = tourset;
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	@Override
	public String toString() {
		return "[build=" + build + ", det=" + det + ", tourset=" + tourset + ", verb=" + verb + "]";
	}

}
