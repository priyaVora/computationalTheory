package vora.priya.computationalTheory.TuringMachine;

public class State_C implements State {

	private TuringMachine machine;

	public State_C(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		boolean directionIsLeft = direction.equals("left");
		boolean currentIsEquals = see.equals("=");
		boolean overWrite = write.equals("=");

		if (currentIsEquals == false && overWrite == false && directionIsLeft == true) {
			System.out.println("Transitioned back to C");
			this.machine.setState(this.machine.getStateC());
		} else if (currentIsEquals == true && overWrite == true && directionIsLeft == true) {
			System.out.println("Transition to State D");
			this.machine.setState(this.machine.getStateD());
		} else {
			System.out.println("Failed...");
			this.machine.setState(this.machine.getStateStart());
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
