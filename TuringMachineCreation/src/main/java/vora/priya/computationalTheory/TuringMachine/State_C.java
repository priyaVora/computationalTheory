package vora.priya.computationalTheory.TuringMachine;

public class State_C implements State {

	private TuringMachine machine;

	public State_C(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);

		if (see.equals("=") && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateD());
		} else if (!(see.equals("=")) && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateC());
		}
	}

	public char setWrite(String userValue) {
		if (userValue.equals("=")) {
			return '=';
		} else if (!(userValue.equals("="))) {
			char replace = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return replace;
		} else {
			return '-';
		}
	}

	public String setDirection(String userValue) {
		if (userValue.equals("=")) {
			return "left";
		} else if (!(userValue.equals("="))) {
			return "left";
		} else {
			return "E";
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
