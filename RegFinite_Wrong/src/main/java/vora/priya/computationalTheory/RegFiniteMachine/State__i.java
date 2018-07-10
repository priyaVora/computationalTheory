package vora.priya.computationalTheory.RegFiniteMachine;

public class State__i implements State {
	private State_Machine machine;

	public State__i(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
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
