package vora.priya.computationalTheory.ParseTree;

public class TourRequest extends Symbol {
	private BuildingPart buildingPart;
	private CityComboInfo cityCOmboInfo;

	public TourRequest() {

	}

	public BuildingPart getBuildingPart() {
		return buildingPart;
	}

	public void setBuildingPart(BuildingPart buildingPart) {
		this.buildingPart = buildingPart;
	}

	public CityComboInfo getCityCOmboInfo() {
		return cityCOmboInfo;
	}

	public void setCityCOmboInfo(CityComboInfo cityCOmboInfo) {
		this.cityCOmboInfo = cityCOmboInfo;
	}

	@Override
	public String toString() {
		return "TourRequest [buildingPart=" + buildingPart + ", cityCOmboInfo=" + cityCOmboInfo + "]";
	}

}
