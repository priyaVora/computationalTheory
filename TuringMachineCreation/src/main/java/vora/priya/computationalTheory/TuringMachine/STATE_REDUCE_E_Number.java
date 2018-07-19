package vora.priya.computationalTheory.TuringMachine;

public class STATE_REDUCE_E_Number implements State {

	private TuringMachine machine;

	public STATE_REDUCE_E_Number(TuringMachine turingMachine) {
		this.setMachine(turingMachine);
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

	public void getNextState(String see, String write, String direction) {
		// TODO Auto-generated method stub

	}
}
