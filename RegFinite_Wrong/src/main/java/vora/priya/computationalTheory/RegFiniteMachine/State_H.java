package vora.priya.computationalTheory.RegFiniteMachine;

public class State_H implements State {

	private State_Machine machine;

	public State_H(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {
		if(currentSymbol.equals("i")) { 
			//goes to current state State__i
			this.machine.setState(this.machine.getState__i());
			System.out.println("Transition to i");
		} else if(currentSymbol.equals("o")) { 
			this.machine.setState(this.machine.getState__o());
			System.out.println("Transition to o");
		} else if(currentSymbol.equals("e")) { 
			//goes to current state State__e
			this.machine.setState(this.machine.getState__e());
			System.out.println("Transition to e");
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
