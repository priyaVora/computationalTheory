package vora.priya.computationalTheory.RegFiniteMachine;

public class State_Start implements State {

	private State_Machine machine;

	public State_Start(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if(currentSymbol.equals("H")) { 
			//transition goes to state H
			this.machine.setState(this.machine.getState_H());
			System.out.println("Transition to H");
		} else if(currentSymbol.equals("h")) { 
			//transition goes to state h
			this.machine.setState(this.machine.getState__h());
			System.out.println("Transition to h");	
		} else if(currentSymbol.equals("a")) { 
			//transition goes to state a
			this.machine.setState(this.machine.getState__a());
			System.out.println("Transition to a");
		} else { 
			//transition goes back to the start state
			this.machine.setState(this.machine.getState_Start());
			System.out.println("Transitioned back to Start");
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
