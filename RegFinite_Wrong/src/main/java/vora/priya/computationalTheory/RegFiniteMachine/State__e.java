package vora.priya.computationalTheory.RegFiniteMachine;

public class State__e implements State {
	private State_Machine machine;

	public State__e(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if(currentSymbol.trim().equals("l")) { 
			//goes to current state State__l
			this.machine.setState(this.machine.getState__e());
		} else if(!(currentSymbol.trim().equals("i"))) { 
			//goes to current state State_Start
			this.machine.setState(this.machine.getState__i());
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
