package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_G implements State {
	private State_Machine machine;

	public State_G(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			this.machine.setState(this.machine.getState_Final());
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
}
