package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class DistanceNumber extends Symbol {
	String distanceValue;

	public DistanceNumber() {

	}

	public String getDistanceValue() {
		return distanceValue;
	}

	public void setDistanceValue(String distanceValue) {
		this.distanceValue = distanceValue;
	}

	public boolean isNumber(String userInput) {
		try {
			if (Integer.parseInt(userInput) >= 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return distanceValue;
	}

}
