package vora.priya.computationalTheory.TuringMachine;

public class State_Start implements State {

	private TuringMachine machine;

	public State_Start(TuringMachine turingMachine) {
		this.setMachine(turingMachine);
	}

	public void getNextState(String see, String write, String direction) {
		// TODO Auto-generated method stub

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
