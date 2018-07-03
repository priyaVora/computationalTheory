package vora.priya.computationalTheory;

public class State_P implements State {
	private State_Machine machine;

	public State_P(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase("n")) {
			this.machine.setState(this.machine.getState_Q());
			System.out.println("Transitioned to N");
		} else if (currentSymbol.equalsIgnoreCase("l")) {
			this.machine.setState(this.machine.getState_F());
			System.out.println("Transitioned to L");
		} else if (currentSymbol.equalsIgnoreCase("h")) {
			this.machine.setState(this.machine.getState_H());
			System.out.println("Transitioned to H");
		} else if (currentSymbol.equalsIgnoreCase("a")) {
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to A");
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
