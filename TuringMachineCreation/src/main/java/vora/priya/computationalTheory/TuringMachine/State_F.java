package vora.priya.computationalTheory.TuringMachine;

public class State_F implements State {

	private TuringMachine machine;

	public State_F(TuringMachine machine) {
		this.setMachine(machine);
	}

	public void getNextState(String see) {
		String direction = setDirection(see);
		char write = setWrite(see);
		
		
		if(see.equals("0")) { 
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = '0';
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateF());
		} 
		
		
		if (see.equals("=") && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getEqualState());
		} else if (see.equals("+") && direction.equals("left")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftLeft();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateX());
		} else if (checkIfNumber(see) == true && direction.equals("right")) {
			int position = this.machine.getTape().getHead();
			this.machine.getTape().getTapeArray()[position] = write;
			this.machine.getTape().shiftRight();
			System.out.println("Head: " + this.machine.getTape().getHead());

			this.machine.setState(this.machine.getStateG());

		}

	}

	public TuringMachine getMachine() {
		return machine;
	}

	public char setWrite(String userValue) {
		if (userValue.equals("=")) {
			return '=';
		} else if (userValue.equals("+")) {
			return 'E';
		} else if (checkIfNumber(userValue) == true) {
			int positionValue = this.machine.getTape().getTapeArray()[this.machine.getTape().getHead()];
			return (char) (positionValue - 1);
		} else {
			return 'E';
		}
	}

	public String setDirection(String userValue) {
		if (userValue.equals("=")) {
			return "left";
		} else if (userValue.equals("+")) {
			return "left";
		} else if (checkIfNumber(userValue) == true) {
			return "right";
		} else {
			return "E";
		}
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
