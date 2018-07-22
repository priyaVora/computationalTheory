package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import voar.priya.computationalTheory.tape.Tape;
import vora.priya.computationalTheory.TuringMachine.TuringMachine;

public class Driver {
	public static void main(String[] args) throws IOException {
		System.out.println("Calculating Service has started...");
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		boolean run = true;
		while (run) {
			driver.answer(machine);
		}
	}

	public String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEquation(Without Equal Sign): ");

		String readline = reader.readLine();
		return readline;
	}

	public void answer(TuringMachine machine) throws IOException {
		System.out.println("\nAnswer: " + calculate(machine, readInput()));
	}

	public String calculate(TuringMachine machine, String readInput) {
		String userInputDetected = machine.calculate(readInput);
		return userInputDetected;
	}
}
