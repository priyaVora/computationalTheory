package vora.priya.computationalTheory.TuringMachine;

public class State_Start implements State {
	private TuringMachine machine;

	public State_Start(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {

		boolean currentIsE = see.equals("E");
		boolean overWriteIsE = write.equals("E");
		boolean directionSymbol = direction.equals("left");

		if (currentIsE == true && overWriteIsE == true && directionSymbol == true) {
			this.machine.setState(this.machine.getStateB());
			System.out.println("Transitioned to State B");
		} else if (currentIsE == false && overWriteIsE == false && directionSymbol == false) {
			this.machine.setState(this.machine.getStateStart());
			System.out.println("Transitioned back to Start");
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
