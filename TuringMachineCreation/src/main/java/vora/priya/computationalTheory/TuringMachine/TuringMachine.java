package vora.priya.computationalTheory.TuringMachine;

import voar.priya.computationalTheory.tape.Tape;

public class TuringMachine {
	public State state;
	Tape tape;
	String equation;

	private State_Start stateStart;
	private State_B stateB;
	private State_C stateC;
	private State_D stateD;
	private State_E stateE;
	private State_F stateF;
	private State_G stateG;
	private State_X stateX;
	private EqualState equalState;
	private EndState endState;
	private State_Halt haltState;

	private Extra extra;
	private Extra2 extra2;

	public TuringMachine(String equation) {
		setStates();
		this.setState(stateStart);
		setAllStates_Tape(equation);
	}

	public void setStates() {
		stateStart = new State_Start(this);
		haltState = new State_Halt(this);
		stateB = new State_B(this);
		stateC = new State_C(this);
		stateD = new State_D(this);
		stateE = new State_E(this);
		stateF = new State_F(this);
		stateG = new State_G(this);
		stateX = new State_X(this);
		equalState = new EqualState(this);
		endState = new EndState(this);
		extra = new Extra(this);
		extra2 = new Extra2(this);
	}

	public String calculate(String userInput) {
		this.setAllStates_Tape(userInput);
		this.tape.printTape();
		State currentState = this.getState();
		String currentTestValue = userInput;

		char[] val = currentTestValue.toCharArray();

		int sizeOfTestValue = this.tape.getTapeArray().length;
		System.out.println("\nSize of Tape: " + sizeOfTestValue);
		int counter = 0;
		if (userInput != "") {
			char currentSymbol = this.getTape().getTapeArray()[this.tape.getHead()];
			System.out.println("CHAR: " + currentSymbol);
			loop: while (counter != sizeOfTestValue) {
				currentSymbol = this.getTape().getTapeArray()[this.tape.getHead()];

				this.getState().getNextState("" + this.getTape().getTapeArray()[this.tape.getHead()]);
				currentState = this.getState();
				counter++;
			}
		}
		return "=" + userInput;
	}

	public void setAllStates_Tape(String equation) {
		this.equation = equation;
		this.tape = new Tape(equation);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Tape getTape() {
		return tape;
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
		this.tape = new Tape(equation);
	}

	public State_Start getStateStart() {
		return stateStart;
	}

	public void setStateStart(State_Start stateStart) {
		this.stateStart = stateStart;
	}

	public State_B getStateB() {
		return stateB;
	}

	public void setStateB(State_B stateB) {
		this.stateB = stateB;
	}

	public State_C getStateC() {
		return stateC;
	}

	public void setStateC(State_C stateC) {
		this.stateC = stateC;
	}

	public State_D getStateD() {
		return stateD;
	}

	public void setStateD(State_D stateD) {
		this.stateD = stateD;
	}

	public State_E getStateE() {
		return stateE;
	}

	public void setStateE(State_E stateE) {
		this.stateE = stateE;
	}

	public State_F getStateF() {
		return stateF;
	}

	public void setStateF(State_F stateF) {
		this.stateF = stateF;
	}

	public State_G getStateG() {
		return stateG;
	}

	public void setStateG(State_G stateG) {
		this.stateG = stateG;
	}

	public State_X getStateX() {
		return stateX;
	}

	public void setStateX(State_X stateX) {
		this.stateX = stateX;
	}

	public State_Halt getHaltState() {
		return haltState;
	}

	public void setHaltState(State_Halt haltState) {
		this.haltState = haltState;
	}

	public EqualState getEqualState() {
		return equalState;
	}

	public void setEqualState(EqualState equalState) {
		this.equalState = equalState;
	}

	public EndState getEndState() {
		return endState;
	}

	public void setEndState(EndState endState) {
		this.endState = endState;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public Extra2 getExtra2() {
		return extra2;
	}

	public void setExtra2(Extra2 extra2) {
		this.extra2 = extra2;
	}
}
