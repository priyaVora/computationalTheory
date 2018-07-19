package vora.priya.computationalTheory.TuringMachine;

public interface State {
	void getNextState(String see, String write, String direction);
}
