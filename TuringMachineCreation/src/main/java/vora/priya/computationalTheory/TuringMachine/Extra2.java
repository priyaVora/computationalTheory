package vora.priya.computationalTheory.TuringMachine;

public class Extra2 implements State {

	private TuringMachine machine;

	public Extra2(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);

		if (see.equals("0") && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateC());
		}
	}

	public char setWrite(String userValue) {
		if (userValue.equals("0")) {
			return '9';
		} else {
			return 'E';
		}
	}

	public String setDirection(String userValue) {
		if (userValue.equals("0")) {
			return "left";
		} else {
			return "E";
		}
	}

	public boolean checkIfNumber(String value) {
		if (Integer.parseInt(value) > 0 && Integer.parseInt(value) < 8) {
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
