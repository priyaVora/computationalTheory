package vora.priya.computationTheory.Hi;

import vora.priya.computationalTheory.stateMachine.State_Machine;

public class State_D {
	private State_Machine machine;
	private String recognizedWord = null;

	public State_D(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {

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
