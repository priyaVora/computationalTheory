package vora.priya.computationalTheory;

public class State_X implements State {
	private State_Machine machine;

	public State_X(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase(" ")) {
			this.machine.setState(this.machine.getState_x());
			System.out.println("Transitioned to space");
		} else if (currentSymbol.equalsIgnoreCase("h")) {
			this.machine.setState(this.machine.getState_H());
			System.out.println("Transitioned to H");
		} else if (currentSymbol.equalsIgnoreCase("y")) {
			this.machine.setState(this.machine.getState_S());
			System.out.println("Transitioned to Y");
		} else if (currentSymbol.equalsIgnoreCase("a")) {
			this.machine.setState(this.machine.getState_A());
			System.out.println("Transitioned to A");
		}

		else {
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
