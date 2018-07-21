package vora.priya.computationalTheory.TuringMachine;

public class State_E implements State {

	private TuringMachine machine;

	public State_E(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		System.out.println("Goes Back to Start --- Reached E");
		this.machine.setState(this.machine.getStateE());
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
}
