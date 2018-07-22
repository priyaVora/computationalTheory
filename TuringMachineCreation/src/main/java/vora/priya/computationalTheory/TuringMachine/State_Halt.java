package vora.priya.computationalTheory.TuringMachine;

public class State_Halt implements State {

	private TuringMachine machine;

	public State_Halt(TuringMachine machine) {
		this.setMachine(machine);
	}

	public TuringMachine getMachine() {
		return machine;
	}

	public void setMachine(TuringMachine machine) {
		if (machine == null) {
			throw new IllegalArgumentException("Machine cannot be null");
		}
		this.machine = machine;
	}

	public void getNextState(String see) {
		//System.out.println("HALT STATE Reached...");
		this.machine.setState(this.machine.getHaltState());
	}

}
