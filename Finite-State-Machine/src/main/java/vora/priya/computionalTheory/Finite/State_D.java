package vora.priya.computionalTheory.Finite;

public class State_D implements State {
private State_Machine machine;
	
	public State_D(State_Machine machine) { 
		this.setMachine(machine);
	}
	public void getNextState(String currentState, String currentSymbol) {
		//System.out.println("Accepted state has been already reached...");
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
