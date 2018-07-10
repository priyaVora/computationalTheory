package vora.priya.computationalTheory.driver;

import vora.priya.computationalTheory.hi.State_B;
import vora.priya.computationalTheory.hi.State_C;
import vora.priya.computationalTheory.starting_others.State_A;
import vora.priya.computationalTheory.starting_others.State_AA;
import vora.priya.computationalTheory.starting_others.State_AAA;
import vora.priya.computationalTheory.starting_others.State_BB;
import vora.priya.computationalTheory.starting_others.State_BBB;
import vora.priya.computationalTheory.starting_others.State_CC;
import vora.priya.computationalTheory.starting_others.State_CCC;
import vora.priya.computationalTheory.starting_others.State_D;
import vora.priya.computationalTheory.starting_others.State_DD;
import vora.priya.computationalTheory.starting_others.State_DDD;
import vora.priya.computationalTheory.starting_others.State_E;
import vora.priya.computationalTheory.starting_others.State_EE;
import vora.priya.computationalTheory.starting_others.State_F;
import vora.priya.computationalTheory.starting_others.State_FF;
import vora.priya.computationalTheory.starting_others.State_Final;
import vora.priya.computationalTheory.starting_others.State_G;
import vora.priya.computationalTheory.starting_others.State_GG;
import vora.priya.computationalTheory.starting_others.State_H;
import vora.priya.computationalTheory.starting_others.State_HH;
import vora.priya.computationalTheory.starting_others.State_I;
import vora.priya.computationalTheory.starting_others.State_II;
import vora.priya.computationalTheory.starting_others.State_J;
import vora.priya.computationalTheory.starting_others.State_JJ;
import vora.priya.computationalTheory.starting_others.State_K;
import vora.priya.computationalTheory.starting_others.State_KK;
import vora.priya.computationalTheory.starting_others.State_L;
import vora.priya.computationalTheory.starting_others.State_LL;
import vora.priya.computationalTheory.starting_others.State_M;
import vora.priya.computationalTheory.starting_others.State_MM;
import vora.priya.computationalTheory.starting_others.State_N;
import vora.priya.computationalTheory.starting_others.State_NN;
import vora.priya.computationalTheory.starting_others.State_O;
import vora.priya.computationalTheory.starting_others.State_P;
import vora.priya.computationalTheory.starting_others.State_PP;
import vora.priya.computationalTheory.starting_others.State_PPP;
import vora.priya.computationalTheory.starting_others.State_Q;
import vora.priya.computationalTheory.starting_others.State_QQ;
import vora.priya.computationalTheory.starting_others.State_Question;
import vora.priya.computationalTheory.starting_others.State_R;
import vora.priya.computationalTheory.starting_others.State_RR;
import vora.priya.computationalTheory.starting_others.State_RRR;
import vora.priya.computationalTheory.starting_others.State_S;
import vora.priya.computationalTheory.starting_others.State_SS;
import vora.priya.computationalTheory.starting_others.State_Start;
import vora.priya.computationalTheory.starting_others.State_T;
import vora.priya.computationalTheory.starting_others.State_TT;
import vora.priya.computationalTheory.starting_others.State_U;
import vora.priya.computationalTheory.starting_others.State_UU;
import vora.priya.computationalTheory.starting_others.State_V;
import vora.priya.computationalTheory.starting_others.State_VV;
import vora.priya.computationalTheory.starting_others.State_W;
import vora.priya.computationalTheory.starting_others.State_WW;
import vora.priya.computationalTheory.starting_others.State_WWW;
import vora.priya.computationalTheory.starting_others.State_X;
import vora.priya.computationalTheory.starting_others.State_XX;
import vora.priya.computationalTheory.starting_others.State_Y;
import vora.priya.computationalTheory.starting_others.State_YY;
import vora.priya.computationalTheory.starting_others.State_Z;
import vora.priya.computationalTheory.starting_others.State_ZZ;
import vora.priya.computationalTheory.starting_others.State_oo;

public class State_Machine {
	public State state;
	private State_Question state_Question;
	private State_A state_A;
	private State_B state_B;
	private State_C state_C;
	private State_D state_D;
	private State_E state_E;
	private State_F state_F;
	private State_G state_G;
	private State_H state_H;
	private State_I state_I;
	private State_J state_J;
	private State_K state_K;
	private State_L state_L;
	private State_M state_M;
	private State_N state_N;
	private State_O state_O;
	private State_P state_P;
	private State_Q state_Q;
	private State_R state_R;
	private State_S state_S;
	private State_T state_T;
	private State_U state_U;
	private State_V state_V;
	private State_W state_W;
	private State_X state_X;
	private State_Y state_Y;
	private State_Z state_Z;

	private State_AA state_AA;
	private State_BB state_BB;
	private State_CC state_CC;
	private State_DD state_DD;
	private State_EE state_EE;
	private State_FF state_FF;
	private State_GG state_GG;
	private State_HH state_HH;
	private State_II state_II;
	private State_JJ state_JJ;
	private State_KK state_KK;
	private State_LL state_LL;
	private State_MM state_MM;
	private State_NN state_NN;
	private State_oo state_OO;
	private State_PP state_PP;
	private State_QQ state_QQ;
	private State_RR state_RR;
	private State_SS state_SS;
	private State_TT state_TT;
	private State_UU state_UU;
	private State_VV state_VV;
	private State_WW state_WW;
	private State_XX state_XX;
	private State_YY state_YY;
	private State_ZZ state_ZZ;

	private State_AAA state_AAA;
	private State_BBB state_BBB;
	private State_CCC state_CCC;

	private State_Start state_Start;
	private State_Final state_Final;
	private State_RRR state_RRR;
	private State_WWW state_WWW;
	private State_DDD state_DDD;
	private State_PPP state_PPP;

	public State_Machine() {
		this.setState(state_Start);
		setAllStates();
	}

	public void setAllStates() {
		this.state_WWW = new State_WWW(this);
		this.state_RRR = new State_RRR(this);
		this.state_DDD = new State_DDD(this);
		this.state_PPP = new State_PPP(this);
		this.state_Question = new State_Question(this);

		this.state_A = new State_A(this);
		this.state_B = new State_B(this);
		this.state_C = new State_C(this);
		this.state_D = new State_D(this);
		this.state_E = new State_E(this);
		this.state_F = new State_F(this);
		this.state_G = new State_G(this);
		this.state_H = new State_H(this);
		this.state_I = new State_I(this);
		this.state_J = new State_J(this);
		this.state_K = new State_K(this);
		this.state_L = new State_L(this);
		this.state_M = new State_M(this);
		this.state_N = new State_N(this);
		this.state_O = new State_O(this);
		this.state_P = new State_P(this);
		this.state_Q = new State_Q(this);
		this.state_R = new State_R(this);
		this.state_S = new State_S(this);
		this.state_T = new State_T(this);
		this.state_U = new State_U(this);
		this.state_V = new State_V(this);
		this.state_W = new State_W(this);
		this.state_X = new State_X(this);
		this.state_Y = new State_Y(this);
		this.state_Z = new State_Z(this);

		this.state_AA = new State_AA(this);
		this.state_BB = new State_BB(this);
		this.state_CC = new State_CC(this);
		this.state_DD = new State_DD(this);
		this.state_EE = new State_EE(this);
		this.state_FF = new State_FF(this);
		this.state_GG = new State_GG(this);
		this.state_HH = new State_HH(this);
		this.state_II = new State_II(this);
		this.state_JJ = new State_JJ(this);
		this.state_KK = new State_KK(this);
		this.state_LL = new State_LL(this);
		this.state_MM = new State_MM(this);
		this.state_NN = new State_NN(this);
		this.state_OO = new State_oo(this);
		this.state_PP = new State_PP(this);
		this.state_QQ = new State_QQ(this);
		this.state_RR = new State_RR(this);
		this.state_SS = new State_SS(this);
		this.state_TT = new State_TT(this);
		this.state_UU = new State_UU(this);
		this.state_VV = new State_VV(this);
		this.state_WW = new State_WW(this);
		this.state_XX = new State_XX(this);
		this.state_YY = new State_YY(this);
		this.state_ZZ = new State_ZZ(this);

		this.state_AAA = new State_AAA(this);
		this.state_BBB = new State_BBB(this);
		this.state_CCC = new State_CCC(this);

		this.state_Start = new State_Start(this);
		this.state_Final = new State_Final(this);
	}

	public State_DDD getState_DDD() {
		return state_DDD;
	}

	public boolean state_Machine_Helper(String userInput) {
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

			counter++;
		}
		if (currentState.equals(this.getState_C()) || currentState.equals(this.getState_Final())
				|| currentState.equals(this.getState_G()) || currentState.equals(this.getState_K())
				|| currentState.equals(this.getState_Question()) || currentState.equals(this.getState_LL())
				|| currentState.equals(this.getState_TT()) || currentState.equals(this.getState_DDD())
				|| currentState.equals(this.getState_ZZ())) {
			input_exist = true;
			// break loop;
		}
		return input_exist;

	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State_A getState_A() {
		return state_A;
	}

	public State_WWW getState_WWW() {
		return state_WWW;
	}

	public State_B getState_B() {
		return state_B;
	}

	public State_Question getState_Question() {
		return state_Question;
	}

	public State_C getState_C() {
		return state_C;
	}

	public State_Start getState_Start() {
		return state_Start;
	}

	public State_Final getState_Final() {
		return state_Final;
	}

	public State_D getState_D() {
		return state_D;
	}

	public State_PPP getState_PPP() {
		return state_PPP;
	}

	public State_E getState_E() {
		return state_E;
	}

	public State_F getState_F() {
		return state_F;
	}

	public State_G getState_G() {
		return state_G;
	}

	public State_H getState_H() {
		return state_H;
	}

	public State_I getState_I() {
		return state_I;
	}

	public State_J getState_J() {
		return state_J;
	}

	public State_K getState_K() {
		return state_K;
	}

	public State_L getState_L() {
		return state_L;
	}

	public State_M getState_M() {
		return state_M;
	}

	public State_N getState_N() {
		return state_N;
	}

	public State_O getState_O() {
		return state_O;
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

	public State_T getState_T() {
		return state_T;
	}

	public State_U getState_U() {
		return state_U;
	}

	public State_V getState_V() {
		return state_V;
	}

	public State_W getState_W() {
		return state_W;
	}

	public State_X getState_X() {
		return state_X;
	}

	public State_Y getState_Y() {
		return state_Y;
	}

	public State_Z getState_Z() {
		return state_Z;
	}

	public State_AA getState_AA() {
		return state_AA;
	}

	public State_BB getState_BB() {
		return state_BB;
	}

	public State_CC getState_CC() {
		return state_CC;
	}

	public State_DD getState_DD() {
		return state_DD;
	}

	public State_EE getState_EE() {
		return state_EE;
	}

	public State_FF getState_FF() {
		return state_FF;
	}

	public State_GG getState_GG() {
		return state_GG;
	}

	public State_HH getState_HH() {
		return state_HH;
	}

	public State_II getState_II() {
		return state_II;
	}

	public State_JJ getState_JJ() {
		return state_JJ;
	}

	public State_KK getState_KK() {
		return state_KK;
	}

	public State_LL getState_LL() {
		return state_LL;
	}

	public State_MM getState_MM() {
		return state_MM;
	}

	public State_NN getState_NN() {
		return state_NN;
	}

	public State_oo getState_OO() {
		return state_OO;
	}

	public State_PP getState_PP() {
		return state_PP;
	}

	public State_QQ getState_QQ() {
		return state_QQ;
	}

	public State_RR getState_RR() {
		return state_RR;
	}

	public State_SS getState_SS() {
		return state_SS;
	}

	public State_TT getState_TT() {
		return state_TT;
	}

	public State_UU getState_UU() {
		return state_UU;
	}

	public State_VV getState_VV() {
		return state_VV;
	}

	public State_WW getState_WW() {
		return state_WW;
	}

	public State_XX getState_XX() {
		return state_XX;
	}

	public State_YY getState_YY() {
		return state_YY;
	}

	public State_ZZ getState_ZZ() {
		return state_ZZ;
	}

	public State_AAA getState_AAA() {
		return state_AAA;
	}

	public State_BBB getState_BBB() {
		return state_BBB;
	}

	public State_CCC getState_CCC() {
		return state_CCC;
	}

	public State_RRR getState_RRR() {
		return state_RRR;
	}

}
