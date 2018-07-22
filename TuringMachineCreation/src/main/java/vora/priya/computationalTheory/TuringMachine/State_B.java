package vora.priya.computationalTheory.TuringMachine;

public class State_B implements State {

	private TuringMachine machine;

	public State_B(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {

		if (see.equals("+")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = 'E';
			this.machine.getTape().shiftLeft();
			// System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateB());

		}
		String direction = setDirection(see);
		char write = setWrite(see);
		if (see.equals("=") && direction.equals("E")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.setState(this.machine.getHaltState());
			// System.out.println("Transitioned to Halt State");
		} else if (see.equals("0") && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.setState(this.machine.getStateF());
			this.machine.getTape().shiftLeft();
			// System.out.println("Transitioned to State F");
		} else if (checkIfNumber(see) == true && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.setState(this.machine.getStateC());
			this.machine.getTape().shiftLeft();
			// System.out.println("Transitioned to State C");
		}

	}

	public char setWrite(String userValue) {
		if (userValue.equals("=")) {
			return '=';
		} else if (checkIfNumber(userValue) == true) {
			int positionValue = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return (char) (positionValue - 1);
		} else if (userValue.equals("0")) {
			return '0';
		} else {
			return 'x';
		}
	}

	public String setDirection(String userValue) {
		if (userValue.equals("=")) {
			return "E";
		} else if (checkIfNumber(userValue) == true) {
			int positionValue = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return "left";
		} else if (userValue.equals("0")) {
			return "left";
		} else {
			return "E";
		}
	}

	public TuringMachine getMachine() {
		return machine;
	}

	public boolean checkIfNumber(String value) {
		if (value.equals("+")) {
			return false;
		}
		if (Integer.parseInt(value) > 0 && Integer.parseInt(value) < 10) {
			return true;
		}
		return false;
	}

	public void setMachine(TuringMachine machine) {
		if (machine == null) {
			throw new IllegalArgumentException("Machine cannot be null");
		}
		this.machine = machine;
	}
}
