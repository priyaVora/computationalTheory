package vora.priya.computationalTheory.TuringMachine;

public class State_F implements State {

	private TuringMachine machine;

	public State_F(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		boolean currentIsNumber = checkIfNumber(see);
		boolean currentIs_Add = see.equals("+");
		boolean currentIsEquals = see.equals("=");

		boolean writeIsSubtraction = write.equals("X--");
		boolean writeIsE = write.equals("E");
		boolean writeisEquals = write.equals("=");

		boolean directionLeft = direction.equals("left");
		boolean directionRight = direction.equals("right");
		if (currentIsNumber == true && writeIsSubtraction == true && directionRight == true) {
			System.out.println("Transitioned to State G");
			this.machine.setState(this.machine.getStateG());
		} else if (currentIs_Add == true && writeIsE == true && directionLeft == true) {
			System.out.println("Transitioned to State X");
			this.machine.setState(this.machine.getStateX());
		} else if (currentIsEquals == true && writeisEquals == true && directionLeft == true) {
			System.out.println("Transitioned to Equal State");
			this.machine.setState(this.machine.getEqualState());
		} else {
			System.out.println("Failed...");
			this.machine.setState(this.machine.getStateStart());
		}
	}

	public TuringMachine getMachine() {
		return machine;
	}

	public boolean checkIfNumber(String value) {
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
