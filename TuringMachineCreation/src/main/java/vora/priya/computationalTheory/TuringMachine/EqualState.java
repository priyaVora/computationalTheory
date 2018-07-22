package vora.priya.computationalTheory.TuringMachine;

public class EqualState implements State {

	private TuringMachine machine;

	public EqualState(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		if (checkIfNumber(see) == true) {
			this.machine.setState(this.machine.getEndState());
			System.out.println("Transitioned to End State");
		}
	}

	public boolean checkIfNumber(String value) {
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
