package vora.priya.computationalTheory;

public class State_C implements State {

	private State_Machine machine;

	public State_C(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase("d")) {
			this.machine.setState(this.getMachine().getState_D());
			System.out.println("Transitioned to d");
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
