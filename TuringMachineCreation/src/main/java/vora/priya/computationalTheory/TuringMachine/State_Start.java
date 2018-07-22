package vora.priya.computationalTheory.TuringMachine;

public class State_Start implements State {
	private TuringMachine machine;

	public State_Start(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);

		if (direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();

			// Make the transtion!
			this.machine.setState(this.machine.getStateB());
		} else if (direction.equals("right")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftRight();
			// System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateStart());
		}

	}

	public char setWrite(String userValue) {
		if (userValue.equals("E")) {
			return 'E';
		} else if (!(userValue.equals("E"))) {
			char replace = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return replace;
		} else {
			return 'E';
		}
	}

	public String setDirection(String userValue) {
		if (userValue.equals("E")) {
			return "left";
		} else if (!(userValue.equals("E"))) {
			return "right";
		} else {
			return "right";
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
