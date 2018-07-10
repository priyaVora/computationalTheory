package vora.priya.computationalTheory.RegFiniteMachine;

public class State__d implements State {

	private State_Machine machine;

	public State__d(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if (currentSymbol.equals("y")) {
			this.machine.setState(this.machine.getState__y());
			System.out.println("Transitioned to y");
		} else {
			// goes back to start
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
