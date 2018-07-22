package vora.priya.computationalTheory.TuringMachine;

public class Extra implements State {

	private TuringMachine machine;

	public Extra(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);
		
		if(see.equals("0")) { 
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = '0';
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getExtra());
		}
		if (direction.equals("right")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftRight();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getExtra2());
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
		if (checkIfNumber(userValue) == true) {
			return "right";
		} else if (userValue.equals("0")) {
			return "left";
		}

		else {
			return "E";
		}
	}

	public boolean checkIfNumber(String value) {
		System.out.println("USER INPUT " + value);
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
