package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_R implements State {
	private State_Machine machine;

	public State_R(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			// is space
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to State A");
		} else {
			// not space
			this.machine.setState(this.machine.getState_R());
			System.out.println("Transitioned to State R");
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
}
