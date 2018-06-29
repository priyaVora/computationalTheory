package vora.priya.computionalTheory.Finite;

public class State_Machine {
	private State_Start state_Start;
	private State_A state_A;
	private State_B state_B;
	private State_C state_C;
	private State_D state_D;
	
	public State state;
	
	public State_Machine()  {
		this.state_A = new State_A(this);
		this.state_B = new State_B(this);
		this.state_C = new State_C(this);
		this.state_D = new State_D(this);
		this.state_Start = new State_Start(this);
		this.setState(state_Start);
	}
	
	public boolean state_machineHelper(String testString) {
		boolean hi_exist = false;
		this.setState(this.getState_Start());
		State currentState = this.getState();
		String currentTestValue = testString;
		char[] val = currentTestValue.toCharArray();
		
		int sizeOfTestValue = currentTestValue.length();
		int counter = 0;	
		loop: while (counter != sizeOfTestValue) {
			//System.out.println("Current char: "+val[counter] );
			this.getState().getNextState("Current ", ""+val[counter]);
			currentState = this.getState();
			if(currentState.equals(this.getState_D())) { 
				hi_exist = true;
				break loop;
			}
			counter++;
		}
		return hi_exist;
	}

	public State_Start getState_Start() {
		return state_Start;
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

	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}	
}
