package vora.priya.computationalTheory.TuringMachine;

public class State_X implements State {

	private TuringMachine machine;

	public State_X(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see, String write, String direction) {
		if (see.equals("0") && write.equals("0") && direction.equals("left")) {
			System.out.println("Transitioned to State Extra");
			this.machine.setState(this.machine.getExtra());
		} else if (checkIfNumber(see) == true && write.equals("X--") && direction.equals("left")) {
			System.out.println("Transitioned to State C");
			this.machine.setState(this.machine.getStateC());
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
