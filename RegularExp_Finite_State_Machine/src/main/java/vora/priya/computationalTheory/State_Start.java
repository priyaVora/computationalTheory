package vora.priya.computationalTheory;

public class State_Start implements State {

	private State_Machine machine;

	public State_Start(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase("h")) {
			// goes to State_H
			this.machine.setState(this.machine.getState_H());
			System.out.println("Transitioned to H");
		} else if (currentSymbol.equalsIgnoreCase("a")) {
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to A");
		} else if (currentSymbol.equalsIgnoreCase("T")) {
			this.machine.setState(this.machine.getState_T());
			System.out.println("Transitioned to T");
		} else {
			this.machine.setState(this.machine.getState_start());
			System.out.println("Transitioned to Start");
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
