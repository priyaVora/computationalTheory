package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_Final implements State {
	private State_Machine machine;
	private String recognizedWord = "";

	public State_Final(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		System.out.println("ACCEPTED STATE REACHED...");
	}

	public State_Machine getMachine() {
		return machine;
	}

	public void setMachine(State_Machine machine) {
		if (machine == null) {
			throw new IllegalArgumentException("Machine cannot be null");
		}
		this.machine = machine;
	}

	public String getRecognizedWord() {
		return recognizedWord;
	}

	public void setRecognizedWord(String recognizedWord) {
		this.recognizedWord = recognizedWord;
	}

}
