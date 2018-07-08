package vora.priya.computationTheory.Hi;

import vora.priya.computationalTheory.stateMachine.State;
import vora.priya.computationalTheory.stateMachine.State_Machine;

public class State_B implements State {
	private State_Machine machine;

	public State_B(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			// was space
			this.machine.setState(this.machine.getState_start());
			System.out.println("Transitioned to Space");
		} else if (currentSymbol.equalsIgnoreCase("i")) {
			// current state is i
			this.machine.setState(this.machine.getState_C());
			System.out.println("Transitioned to I");
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
