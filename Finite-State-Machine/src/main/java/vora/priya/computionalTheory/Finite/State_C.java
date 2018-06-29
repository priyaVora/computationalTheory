package vora.priya.computionalTheory.Finite;

public class State_C implements State {
	private State_Machine machine;

	public State_C(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentState, String currentSymbol) {

		if (!(currentSymbol.trim().length() > 0)) {
			//go to the accepted state D
			this.machine.setState(this.machine.getState_D());
			//System.out.println("Transformed to accepted state");
		} else if(currentSymbol.trim().length() > 0) { 
			//go back to start instead
			this.machine.setState(this.machine.getState_Start());
			//System.out.println("Transformed back to start");
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
