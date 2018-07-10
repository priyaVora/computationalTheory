package vora.priya.computationalTheory.RegFiniteMachine;

public class State__o implements State {
	private State_Machine machine;

	public State__o(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if (currentSymbol.equals("#")) {
			this.machine.setState(this.machine.getFinalState());
			System.out.println("Transitioned to final accepted state.");
		} else if (currentSymbol.equals("h")) {
			this.machine.setState(this.machine.getState__h());
			System.out.println("Transition to h");
		} else if (currentSymbol.equals("w")) {
			this.machine.setState(this.machine.getState__w());
			System.out.println("Transition to w");
		} else {
			this.machine.setState(this.machine.getState_Start());
			System.out.println("Transitioned back to the Start State");
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
