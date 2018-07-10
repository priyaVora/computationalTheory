package vora.priya.computationalTheory.starting_others;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_U implements State {
	private State_Machine machine;

	public State_U(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase("i")) {
			this.machine.setState(this.machine.getState_V());
			System.out.println("Transitioned to I ");
		} else if (!(currentSymbol.trim().length() > 0)) {
			this.machine.setState(this.machine.getState_Start());
			System.out.println("Transitiones to Space");
		} else {
			this.machine.setState(this.machine.getState_R());
			System.out.println("Transitioned back to Start");
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
