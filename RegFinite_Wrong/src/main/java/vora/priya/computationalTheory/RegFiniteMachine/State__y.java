package vora.priya.computationalTheory.RegFiniteMachine;

public class State__y implements State {

	private State_Machine machine;

	public State__y(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		System.out.println("Current symbol: " + currentSymbol);
			this.machine.setState(this.machine.getFinalState());
			System.out.println("Transitioned to final accepted state.");
	
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
