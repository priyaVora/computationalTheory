package vora.priya.computationalTheory.TuringMachine;

public class EndState implements State {

	private TuringMachine machine;

	public EndState(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		//System.out.println("Transitioned to Halt State");
		this.machine.setState(this.machine.getHaltState());
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
