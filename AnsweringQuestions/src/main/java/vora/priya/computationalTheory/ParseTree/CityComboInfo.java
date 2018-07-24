package vora.priya.computationalTheory.ParseTree;

public class CityComboInfo {
	private CityName cityOne;
	private Conjunction conjunction;
	private CityName cityTwo;

	public CityComboInfo() {

	}

	public CityName getCityOne() {
		return cityOne;
	}

	public void setCityOne(CityName cityOne) {
		this.cityOne = cityOne;
	}

	public Conjunction getConjunction() {
		return conjunction;
	}

	public void setConjunction(Conjunction conjunction) {
		this.conjunction = conjunction;
	}

	public CityName getCityTwo() {
		return cityTwo;
	}

	public void setCityTwo(CityName cityTwo) {
		this.cityTwo = cityTwo;
	}

	@Override
	public String toString() {
		return "[cityOne=" + cityOne + ", conjunction=" + conjunction + ", cityTwo=" + cityTwo + "]";
	}
}
