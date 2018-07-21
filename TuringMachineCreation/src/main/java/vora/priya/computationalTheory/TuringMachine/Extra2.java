package vora.priya.computationalTheory.TuringMachine;

public class Extra2 implements State {

	private TuringMachine machine;

	public Extra2(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		if (see.equals("0") && write.equals("9") && direction.equals("left")) {
			System.out.println("Transistioned to State C");
			this.machine.setState(this.machine.getStateC());
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
