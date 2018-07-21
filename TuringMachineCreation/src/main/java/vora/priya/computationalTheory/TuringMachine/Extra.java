package vora.priya.computationalTheory.TuringMachine;

public class Extra implements State {

	private TuringMachine machine;

	public Extra(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
//		if (checkIfNumber(see) == true && write.equals("X--") && direction.equals("right")) {
//			System.out.println("Transitioned to Extra 2");
//			this.machine.setState(this.machine.getExtra2());
//		} else {
//			System.out.println("Failed...");
//			this.machine.setState(this.machine.getStateStart());
//		}
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
