package vora.priya.computionalTheory.Finite;

public class State_B implements State {

	private State_Machine machine;

	public State_B(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if (currentSymbol.equals("i")) {
			//go to transition C
			this.machine.setState(this.machine.getState_C());
			//System.out.println("Transformed to C");
		} else if (!(currentSymbol.equals("i"))) {
			//go back to transition B
			this.machine.setState(this.machine.getState_C());
			//System.out.println("Transformed back to B");
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
