package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_DDD implements State {
	private State_Machine machine;
	private String recognizedWord = "";

	public State_DDD(State_Machine machine) {
		this.setMachine(machine);
		recognizedWord = "thank you";
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			State_Final state = this.machine.getState_Final();
			state.setRecognizedWord("thank you");
			this.machine.setState(state);
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
