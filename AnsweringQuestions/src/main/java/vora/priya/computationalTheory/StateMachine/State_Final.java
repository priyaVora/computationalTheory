package vora.priya.computationalTheory.StateMachine;

public class State_Final implements State {

	private State_Machine machine;

	public State_Final(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (!(currentSymbol.trim().length() > 0)) {
			this.machine.setState(this.machine.getState_Start());
		} else {
			this.machine.setState(this.machine.getState_Final());
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
