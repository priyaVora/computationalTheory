package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_G implements State {
	private State_Machine machine;
	private String recognizedWord = "";

	public State_G(State_Machine machine) {
		this.setMachine(machine);
		recognizedWord = "hello";
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			State_Final finalState = this.machine.getState_Final();
			finalState.setRecognizedWord("hello");
			this.machine.setState(finalState);
			System.out.println("Final State Reached.");
		} else {
			this.machine.setState(this.machine.getState_R());
			System.out.println("Invalid Input: Transitioned back to Start.");
		}
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
