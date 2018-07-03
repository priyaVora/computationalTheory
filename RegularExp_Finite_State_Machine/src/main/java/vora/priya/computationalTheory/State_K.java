package vora.priya.computationalTheory;

public class State_K implements State {
	private State_Machine machine;

	public State_K(State_Machine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String currentSymbol) {
		if (currentSymbol.equalsIgnoreCase("a")) {
			this.machine.setState(this.machine.getState_M());
			System.out.println("Transitioned to A");
		} else if (currentSymbol.equalsIgnoreCase("h")) {
			this.machine.setState(this.machine.getState_H());
			System.out.println("Transitioned to H");
		} else if (currentSymbol.equalsIgnoreCase("i")) {
			this.machine.setState(this.machine.getState_I());
			System.out.println("Transitioned to I");
		} else if (currentSymbol.equalsIgnoreCase("o")) {
			this.machine.setState(this.machine.getState_B());
			System.out.println("Transitioned to O");
		} else if(currentSymbol.equalsIgnoreCase("e")) { 
			this.machine.setState(this.machine.getState_E());
			System.out.println("Transitioned to E");
		} else {
			this.machine.setState(this.machine.getState_start());
			System.out.println("Transitioned to Start");
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
