package vora.priya.computationalTheory;

public class State_O implements State {

	private State_Machine machine;

	public State_O(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		this.machine.getState_G().setRecognizedWord("hello");
		this.machine.setState(this.machine.getState_G());
		System.out.println("Final State Reached...");
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
}
