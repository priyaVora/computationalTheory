package vora.priya.computationalTheory.TuringMachine;

public class TuringMachine {
	public State state;
	private State_Start start;
	private STATE_REDUCE_ONE reduceOne_State;
	private STATE_REDUCE_E_Number reduce_E_Number;

	public TuringMachine() {
		this.setState(reduceOne_State);
		setAllStates();
	}

	public void setAllStates() { 
		this.start = new State_Start(this);
		this.reduce_E_Number = new STATE_REDUCE_E_Number(this);
		this.reduceOne_State =  new STATE_REDUCE_ONE(this);
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
