package vora.priya.computationalTheory.RegFiniteMachine;

public interface State {
	void getNextState(String currentState, String currentSymbol);
}
