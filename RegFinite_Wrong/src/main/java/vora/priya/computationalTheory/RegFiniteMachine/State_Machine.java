package vora.priya.computationalTheory.RegFiniteMachine;

public class State_Machine {
	private State_Start state_Start;
	private State_H state_H;
	private State__h state__h;
	private State__e state__e;
	private State__i state__i;
	private State__l state__l;
	private State__o state__o;
	private State__w state__w;
	private State__y state__y;
	private State__d state__d;

	private State__a state__a;
	private State_A state_A;

	private State_finalAcceptedState finalState;

	public State state;
	String testedValue;

	public State_Machine() {
		this.state_Start = new State_Start(this);
		this.state_H = new State_H(this);

		this.state__a = new State__a(this);
		this.state_A = new State_A(this);
		this.state__h = new State__h(this);
		this.state__e = new State__e(this);
		this.state__i = new State__i(this);
		this.state__l = new State__l(this);
		this.state__o = new State__o(this);
		this.state__w = new State__w(this);
		this.state__d = new State__d(this);
		this.state__y = new State__y(this);
		this.finalState = new State_finalAcceptedState(this);

		this.setState(state_Start);
		testedValue = null;
	}

	public boolean state_machineHelper(String testString) {
		boolean input_exist = false;
		this.setState(this.getState_Start());
		State currentState = this.getState();
		testedValue = testString;
		String currentTestValue = testString + "#";

		char[] val = currentTestValue.toCharArray();

		int sizeOfTestValue = currentTestValue.length();
		int counter = 0;
		loop: while (counter != sizeOfTestValue) {
			// System.out.println("Current char: "+val[counter] );
			this.getState().getNextState("Current ", "" + val[counter]);
			currentState = this.getState();
			if (currentState.equals(this.getFinalState())) {
				input_exist = true;
				break loop;
			}
			counter++;
		}
		return input_exist;
	}

	public State_Start getState_Start() {
		return state_Start;
	}

	public State_H getState_H() {
		return state_H;
	}

	public State__h getState__h() {
		return state__h;
	}

	public State__e getState__e() {
		return state__e;
	}

	public State__i getState__i() {
		return state__i;
	}

	public State__l getState__l() {
		return state__l;
	}

	public State__o getState__o() {
		return state__o;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State_finalAcceptedState getFinalState() {
		return finalState;
	}

	public String getTestedValue() {
		return testedValue;
	}

	public State__d getState__d() {
		return state__d;
	}

	public State__w getState__w() {
		return state__w;
	}

	public State__y getState__y() {
		return state__y;
	}

	public State__a getState__a() {
		return state__a;
	}

	public State_A getState_A() {
		return state_A;
	}

}
