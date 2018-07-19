package vora.priya.computationalTheory.TuringMachine;

import voar.priya.computationalTheory.tape.Tape;

public class TuringMachine {
	public State state;
	Tape tape;
	String equation;
	private State_Start start;
	private STATE_REDUCE_ONE reduceOne_State;
	private STATE_REDUCE_E_Number reduce_E_Number;

	public TuringMachine(String equation) {
		this.setState(reduceOne_State);
		setAllStates_Tape();
	}

	public void calculate() {

	}

	public void setAllStates_Tape() {
		this.start = new State_Start(this);
		this.reduce_E_Number = new STATE_REDUCE_E_Number(this);
		this.reduceOne_State = new STATE_REDUCE_ONE(this);
		this.equation = equation;
		this.tape = new Tape(equation);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
