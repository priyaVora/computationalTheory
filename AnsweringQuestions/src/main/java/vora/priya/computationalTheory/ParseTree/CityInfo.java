package vora.priya.computationalTheory.ParseTree;

public class CityInfo {
	private DistanceInfo distanceInfo;
	private DescriptionInfo descriptionInfo;
	private CityComboInfo cityComboInfo;

	public CityInfo() {

	}

	public DistanceInfo getDistanceInfo() {
		return distanceInfo;
	}

	public void setDistanceInfo(DistanceInfo distanceInfo) {
		this.distanceInfo = distanceInfo;
	}

	public DescriptionInfo getDescriptionInfo() {
		return descriptionInfo;
	}

	public void setDescriptionInfo(DescriptionInfo descriptionInfo) {
		this.descriptionInfo = descriptionInfo;
	}

	public CityComboInfo getCityComboInfo() {
		return cityComboInfo;
	}

	public void setCityComboInfo(CityComboInfo cityComboInfo) {
		this.cityComboInfo = cityComboInfo;
	}

	@Override
	public String toString() {
		return "CityInfo [distanceInfo=" + distanceInfo + ", descriptionInfo=" + descriptionInfo + ", cityComboInfo="
				+ cityComboInfo + "]";
	}

}
