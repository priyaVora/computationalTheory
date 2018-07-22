package vora.priya.computationalTheory.TuringMachine;

public class State_G implements State {

	private TuringMachine machine;

	public State_G(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		if (see.equals("0")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = '9';
			this.machine.getTape().shiftRight();
			// System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getCheck());
		} else if (see.equals("E")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = 'E';
			this.machine.getTape().shiftLeft();
			// System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateC());
		}
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
