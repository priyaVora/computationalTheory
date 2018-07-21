package vora.priya.computationalTheory.TuringMachine;

public class State_B implements State {

	private TuringMachine machine;

	public State_B(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
//		boolean currentIsEquals = see.equals("=");
//		boolean currentIsZero = see.equals("0");
//		boolean currentIsNumber = checkIfNumber(see);
//
//		boolean overWriteIsNumberSubtraction = write.equals("X--");
//		boolean overWriteisEquals = write.equals("=");
//		boolean overWriteIsE = write.equals("E");
//
//		boolean directionIsLeft = direction.equals("left");
//		boolean directionIsRight = direction.equals("right");
//		boolean directionIsE = direction.equals("E");
//
//		if (currentIsEquals == true && overWriteisEquals == true && directionIsE == true) {
//			this.machine.setState(this.machine.getHaltState());
//			System.out.println("Reached the Halt State");
//		} else if (currentIsNumber == true && overWriteIsNumberSubtraction == true && directionIsLeft == true) {
//			this.machine.setState(this.machine.getStateC());
//			System.out.println("Tranitioning to State C");
//		} else if (currentIsZero == true && write.equals("0")&& directionIsLeft == true) {
//			this.machine.setState(this.machine.getStateF());
//			System.out.println("Transitioned to Stat F");
//		} else {
//			System.out.println("Failed");
//			this.machine.setState(this.machine.getStateStart());
//		}
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
