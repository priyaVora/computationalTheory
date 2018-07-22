package vora.priya.computationalTheory.TuringMachine;

public class State_X implements State {

	private TuringMachine machine;

	public State_X(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);

		if (direction.equals("left") && see.equals("0")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			// System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getExtra());
		} else if (direction.equals("left") && checkIfNumber(see) == true) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			// System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateC());
		}
	}

	public char setWrite(String userValue) {
		if (checkIfNumber(userValue) == true) {
			int positionValue = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return (char) (positionValue - 1);
		} else if (userValue.equals("0")) {
			return '0';
		} else {
			return 'E';
		}
	}

	public String setDirection(String userValue) {
		if (checkIfNumber(userValue) == true || userValue.equals("0")) {
			return "left";
		} else {
			return "E";
		}
	}

	public boolean checkIfNumber(String value) {
		if (Integer.parseInt(value) > 0 && Integer.parseInt(value) < 10) {
			return true;
		}
		return false;
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
