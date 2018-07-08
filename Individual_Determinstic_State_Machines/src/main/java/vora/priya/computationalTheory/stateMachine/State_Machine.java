package vora.priya.computationalTheory.stateMachine;

import vora.priya.computationTheory.Hi.State_A;
import vora.priya.computationTheory.Hi.State_B;
import vora.priya.computationTheory.Hi.State_C;
import vora.priya.computationTheory.Hi.State_D;
import vora.priya.computationTheory.Hi.State_S;
import vora.priya.computationTheory.Hi.State_Start;

public class State_Machine {
	private State state;
	private State_Start state_start;
	private State_A state_A;
	private State_B state_B;
	private State_C state_C;
	private State_D state_D;
	private State_S state_S;

	public State_Machine() {
		this.state_A = new State_A(this);
		this.state_B = new State_B(this);
		this.state_C = new State_C(this);
		this.state_D = new State_D(this);
		this.state_S = new State_S(this);
		this.state_start = new State_Start(this);
		this.setState(this.state_start);
	}

	public boolean state_Machine_Helper(String userInput) {
		boolean input_exist = false;
		this.setState(this.getState_start());
		State currentState = this.getState();

		String currentTestValue = userInput;

		char[] val = currentTestValue.toCharArray();

		int sizeOfTestValue = currentTestValue.length();
		int counter = 0;
		loop: while (counter != sizeOfTestValue) {
			this.getState().getNextState("" + val[counter]);
			currentState = this.getState();
			if (currentState.equals(this.getState_C())) {
				input_exist = true;
				// break loop;
			}
			counter++;
		}

		if (currentState.equals(this.state_D)) {
			System.out.println("REACHED");
			input_exist = true;
		} else if (currentState.equals(this.state_C)) {
			System.out.println("REACHED");
			input_exist = true;
		} else {
			System.out.println("FAILED TO REACH");
			input_exist = false;
		}
		return input_exist;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State_Start getState_start() {
		return state_start;
	}

	public State_A getState_A() {
		return state_A;
	}

	public State_B getState_B() {
		return state_B;
	}

	public State_C getState_C() {
		return state_C;
	}

	public State_D getState_D() {
		return state_D;
	}

	public State_S getState_S() {
		return state_S;
	}

	public void setState_S(State_S state_S) {
		this.state_S = state_S;
	}
}
