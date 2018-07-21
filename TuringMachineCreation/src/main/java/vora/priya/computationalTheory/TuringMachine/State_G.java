package vora.priya.computationalTheory.TuringMachine;

public class State_G implements State {

	private TuringMachine machine;

	public State_G(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		System.out.println("Transitioned to State C");
		this.machine.setState(this.machine.getStateC());
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
