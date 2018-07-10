package vora.priya.computationalTheory.RegFiniteMachine;

public class State__l implements State {
	private State_Machine machine;

	public State__l(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if(currentSymbol.trim().equals("l")) { 
			//goes to State l
			this.machine.setState(this.machine.getState__l());
			System.out.println("Transition to State l");
		} else if(currentSymbol.trim().equals("o")) { 
			//goes to State o
			this.machine.setState(this.machine.getState__o());
			System.out.println("Transition to State o");
		} else { 
			//goes back to the current state State_start
			this.machine.setState(this.machine.getState_Start());
			System.out.println("Transition to Start state");
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
