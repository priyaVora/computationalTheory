package vora.priya.computationalTheory.ParseTree;

public class CityName extends Symbol {
	private String cityName_Value;
	
	public CityName() {
		
	}

	public String getCityName_Value() {
		return cityName_Value;
	}

	public void setCityName_Value(String cityName_Value) {
		this.cityName_Value = cityName_Value;
	}

	@Override
	public String toString() {
		return cityName_Value;
	}

}
