package vora.priya.computationalTheory.TuringMachine;

public class State_D implements State {

	private TuringMachine machine;

	public State_D(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);

//		if (see.equals("0")) {
//			int position = this.machine.getTape().getHead();
//			this.machine.getTape().getTapeArray()[position] = '1';
//			this.machine.getTape().shiftLeft();
//			System.out.println("Head: " + this.machine.getTape().getHead());
//
//			this.machine.setState(this.machine.getStateD());
//
//		}

		if (direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateD());
		} else if (direction.equals("right") && see.equals("E")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftRight();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateE());
		} else if (direction.equals("right") && checkIfNumber(see) == true) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftRight();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateE());
		}
	}

	public char setWrite(String userValue) {
		if (userValue.equals("9")) {
			return '0';
		} else if (userValue.equals("E")) {
			return '1';

		} else if (checkIfNumber(userValue) == true) {
			int positionValue = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return (char) (positionValue + 1);

		} else {
			return 'E';
		}
	}

	public String setDirection(String userValue) {
		if (userValue.equals("9")) {
			return "left";
		} else if (userValue.equals("E")) {
			return "right";
		} else if (checkIfNumber(userValue) == true) {
			return "right";
		} else {
			return "E";
		}
	}

	public boolean checkIfNumber(String value) {
		if (Integer.parseInt(value) > -1 && Integer.parseInt(value) <= 8) {
			return true;
		}
		return false;
	}

	public boolean checkIfNine(String value) {
		int integer = Integer.parseInt(value);
		if (integer == 9) {
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
