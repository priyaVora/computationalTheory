package vora.priya.computionalTheory.Finite;

public class State_Start implements State {

	private State_Machine machine;

	public State_Start(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {

		if (!(currentSymbol.trim().length() > 0)) {
			// go to current state State_A
			this.machine.setState(this.machine.getState_A());
			//System.out.println("Transition to A");
		} else if (currentSymbol.trim().length() > 0) {
			// go back to current state State_start
			this.machine.setState(this.machine.getState_Start());
			//System.out.println("Transitioned back to Start");
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
