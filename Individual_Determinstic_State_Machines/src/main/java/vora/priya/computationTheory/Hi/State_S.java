package vora.priya.computationTheory.Hi;

import vora.priya.computationalTheory.stateMachine.State;
import vora.priya.computationalTheory.stateMachine.State_Machine;

public class State_S implements State {
	private State_Machine machine;

	public State_S(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if ((!(currentSymbol.trim().length() > 0))) {
			// space
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to Space");
		} else {
			// not space
			this.machine.setState(this.machine.getState_S());
			System.out.println("Transitioned to not space");
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
