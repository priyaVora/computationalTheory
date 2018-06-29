package vora.priya.computionalTheory.Finite;

public class State_A implements State {
	private State_Machine machine;

	public State_A(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		
		if(currentSymbol.equals("h")) { 
			//go to transition B
			this.machine.setState(this.machine.getState_B());
			//System.out.println("Tranformed to B");
		} else if(!(currentSymbol.equals("h"))) { 
			//go back to Start instead
			this.machine.setState(this.machine.getState_Start());
			//System.out.println("Tranformed back to Start");
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
