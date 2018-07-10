package vora.priya.computationalTheory.hi;

import vora.priya.computationalTheory.driver.State;
import vora.priya.computationalTheory.driver.State_Machine;

public class State_B implements State {
	private State_Machine machine;

	public State_B(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		// if i go to c
		if (currentSymbol.equalsIgnoreCase("i")) {
			System.out.println("Transitioned to I");
			this.machine.setState(this.machine.getState_C());
		} else if (currentSymbol.equalsIgnoreCase("e")) {
			this.machine.setState(this.machine.getState_D());
			System.out.println("Transitioned to E");
		} else if (currentSymbol.equalsIgnoreCase("o")) {
			this.machine.setState(this.machine.getState_I());
			System.out.println("Transitioned to O");
		} else if (!(currentSymbol.trim().length() > 0)) {
			this.machine.setState(this.machine.getState_Start());
			System.out.println("Transitoned to Space");
		} else {
			this.machine.setState(this.machine.getState_R());
			System.out.println("Transitioned back to Start");
		}
		// if e go to d
		// if o go to i
		// if space go to start
		// if other go to R
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
