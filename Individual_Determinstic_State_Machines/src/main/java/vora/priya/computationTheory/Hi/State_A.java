package vora.priya.computationTheory.Hi;

import vora.priya.computationalTheory.stateMachine.State;
import vora.priya.computationalTheory.stateMachine.State_Machine;

public class State_A implements State {
	private State_Machine machine;

	public State_A(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			// was space
			System.out.println("Current symbol is: " + currentSymbol);
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to Space");
		} else if (currentSymbol.equalsIgnoreCase("h")) {
			// current state is h
			this.machine.setState(this.machine.getState_B());
			System.out.println("Transitioned to H");
		} else {
			this.machine.setState(this.machine.getState_S());
			System.out.println("Transitioned to Starting Point");
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
