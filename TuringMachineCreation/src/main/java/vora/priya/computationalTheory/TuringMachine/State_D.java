package vora.priya.computationalTheory.TuringMachine;

public class State_D implements State {

	private TuringMachine machine;

	public State_D(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		boolean currentIs9 = checkIfNine(see);
		boolean currentIsNumber = checkIfNumber(see);
		boolean currentIsE = see.equals("E");

		boolean overWriteZero = (Integer.parseInt(write) == 0);
		boolean overWriteOne = (Integer.parseInt(write) == 1);
		boolean overWriteAdd = write.equals("X+1");

		boolean directionIsLeft = direction.equals("left");
		boolean directionRight = direction.equals("right");

		if (currentIs9 == true && overWriteZero == true && directionIsLeft == true) {
			System.out.println("Transitioned to State D");
			this.machine.setState(this.machine.getStateD());
		} else if (currentIsE == true && overWriteOne == true && directionRight == true) {
			System.out.println("Transitioned to State E");
			this.machine.setState(this.machine.getStateE());
		} else if (currentIsNumber == true && overWriteAdd == true && directionRight == true) {
			System.out.println("Transitioned to State E");
			this.machine.setState(this.machine.getStateE());
		} else {
			System.out.println("Failed....");
			this.machine.setState(this.machine.getStateStart());
		}

	}

	public boolean checkIfNumber(String value) {
		if (Integer.parseInt(value) > 0 && Integer.parseInt(value) < 8) {
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
