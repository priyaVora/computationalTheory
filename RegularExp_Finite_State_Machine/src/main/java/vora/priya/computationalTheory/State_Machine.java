package vora.priya.computationalTheory;

public class State_Machine {

	private State state;
	private State_Start state_start;
	private State_H state_H;
	private State_I state_I;
	private State_G state_G;

	private State_E state_E;
	private State_O state_O;
	private State_L state_L;

	private State_Second_L state_second_L;

	private State_B state_B;
	private State_C state_C;
	private State_D state_D;
	private State_Y state_Y;

	private State_A state_A;
	private State_F state_F;
	private State_J state_J;
	private State_K state_K;
	private State_M state_M;

	private State_T state_T;
	private State_N state_N;
	private State_P state_P;
	private State_Q state_Q;
	private State_R state_R;
	private State_S state_S;
	private State_U state_U;
	private State_V state_V;

	private State_S_end s_end;
	private State_X state_x;

	public State_Machine() {

		this.state_x = new State_X(this);
		this.s_end = new State_S_end(this);
		this.state_H = new State_H(this);
		this.state_I = new State_I(this);
		this.state_G = new State_G(this);

		this.state_E = new State_E(this);
		this.state_O = new State_O(this);
		this.state_L = new State_L(this);
		this.state_second_L = new State_Second_L(this);

		this.state_B = new State_B(this);
		this.state_C = new State_C(this);
		this.state_D = new State_D(this);
		this.state_Y = new State_Y(this);

		this.state_A = new State_A(this);
		this.state_F = new State_F(this);
		this.state_J = new State_J(this);
		this.state_K = new State_K(this);
		this.state_M = new State_M(this);

		this.state_T = new State_T(this);
		this.state_N = new State_N(this);
		this.state_P = new State_P(this);
		this.state_Q = new State_Q(this);
		this.state_R = new State_R(this);
		this.state_U = new State_U(this);
		this.state_V = new State_V(this);
		this.state_S = new State_S(this);

		this.state_start = new State_Start(this);
		this.setState(state_start);
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
			if (currentState.equals(this.getState_G())) {
				input_exist = true;
				break loop;
			}
			counter++;
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

	public State_H getState_H() {
		return state_H;
	}

	public State_I getState_I() {
		return state_I;
	}

	public State_G getState_G() {
		return state_G;
	}

	public State_E getState_E() {
		return state_E;
	}

	public State_O getState_O() {
		return state_O;
	}

	public State_L getState_L() {
		return state_L;
	}

	public State_Second_L getState_second_L() {
		return state_second_L;
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

	public State_Y getState_Y() {
		return state_Y;
	}

	public State_A getState_A() {
		return state_A;
	}

	public State_F getState_F() {
		return state_F;
	}

	public State_J getState_J() {
		return state_J;
	}

	public State_K getState_K() {
		return state_K;
	}

	public State_M getState_M() {
		return state_M;
	}

	public State_T getState_T() {
		return state_T;
	}

	public State_N getState_N() {
		return state_N;
	}

	public State_P getState_P() {
		return state_P;
	}

	public State_Q getState_Q() {
		return state_Q;
	}

	public State_R getState_R() {
		return state_R;
	}

	public State_S getState_S() {
		return state_S;
	}

	public State_U getState_U() {
		return state_U;
	}

	public State_V getState_V() {
		return state_V;
	}

	public State_S_end getS_end() {
		return s_end;
	}

	public State_X getState_x() {
		return state_x;
	}

}
