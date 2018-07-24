package vora.priya.computationalTheory.ParseTree;

public class DistanceInfo extends Symbol {
	private Determiner deteriminer;
	private DistanceNumber distanceNumber;
	private KM kilometers;

	public DistanceInfo() {

	}

	public Determiner getDeteriminer() {
		return deteriminer;
	}

	public void setDeteriminer(Determiner deteriminer) {
		this.deteriminer = deteriminer;
	}

	public DistanceNumber getDistanceNumber() {
		return distanceNumber;
	}

	public void setDistanceNumber(DistanceNumber distanceNumber) {
		this.distanceNumber = distanceNumber;
	}

	public KM getKilometers() {
		return kilometers;
	}

	public void setKilometers(KM kilometers) {
		this.kilometers = kilometers;
	}

	@Override
	public String toString() {
		return "[deteriminer=" + deteriminer + ", distanceNumber=" + distanceNumber + ", kilometers=" + kilometers
				+ "]";
	}

}
