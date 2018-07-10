package vora.priya.computationalTheory.RegFiniteMachine;

public class State_A implements State {

	private State_Machine machine;

	public State_A(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if (currentSymbol.equals("l")) {
			this.machine.setState(this.machine.getState__l());
			System.out.println("Transition to l");
		} else {
			// goes back to start
			this.machine.setState(this.machine.getState_Start());
			System.out.println("Transitioned back to the start");
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
