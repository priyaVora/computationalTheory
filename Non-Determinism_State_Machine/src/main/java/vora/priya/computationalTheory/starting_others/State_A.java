package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_A implements State {

	private State_Machine machine;

	public State_A(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase("a")) {
			this.machine.setState(this.machine.getState_HH());
			System.out.println("Transitioned to A");
		} else if (currentSymbol.equalsIgnoreCase("h")) {
			this.machine.setState(this.machine.getState_B());
			System.out.println("Transitioned to H");
		} else if (currentSymbol.equalsIgnoreCase("t")) {
			this.machine.setState(this.machine.getState_UU());
			System.out.println("Transitioned to T");
		} else if (!(currentSymbol.trim().length() > 0)) {
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to Space");
		} else {
			// go to R
			System.out.println("Transitioned to State R");
			this.machine.setState(this.machine.getState_R());
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
