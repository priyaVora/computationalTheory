package vora.priya.computationalTheory.StateMachine;

public class State_Machine {

	private State state;
	private State_Start state_Start;
	private State_A state_A;
	private State_Final state_Final;
	
	private String currentRecognizedWord = "";

	public State_Machine() {
		setState(state);
		this.state_Start = new State_Start(this);
		this.state_A = new State_A(this);
		this.state_Final = new State_Final(this);
	}

	public boolean is_Word(String userInput) {
		boolean input_exist = false;
		this.setState(this.getState_Start());
		State currentState = this.getState();

		String currentTestValue = userInput;

		char[] val = currentTestValue.toCharArray();

		int sizeOfTestValue = currentTestValue.length();
		int counter = 0;
		loop: while (counter != sizeOfTestValue) {
			this.getState().getNextState("" + val[counter]);
			currentState = this.getState();
			if (currentState.equals(this.getState_Final()) && (counter +1) == sizeOfTestValue) {
				input_exist = true;
				currentRecognizedWord += val[counter];
				break loop;
			}
			currentRecognizedWord += val[counter];
			counter++;
		}
		
		if(input_exist == false) { 
			setCurrentRecognizedWord(null);
		}
		return input_exist;

	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State_Start getState_Start() {
		return state_Start;
	}

	public void setState_Start(State_Start state_Start) {
		this.state_Start = state_Start;
	}

	public State_A getState_A() {
		return state_A;
	}

	public void setState_A(State_A state_A) {
		this.state_A = state_A;
	}

	public State_Final getState_Final() {
		return state_Final;
	}

	public void setState_Final(State_Final state_Final) {
		this.state_Final = state_Final;
	}

	public String getCurrentRecognizedWord() {
		return currentRecognizedWord;
	}

	public void setCurrentRecognizedWord(String currentRecognizedWord) {
		this.currentRecognizedWord = currentRecognizedWord;
	}
	
	
}
