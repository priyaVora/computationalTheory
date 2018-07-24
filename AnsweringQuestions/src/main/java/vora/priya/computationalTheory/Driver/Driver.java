package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import vora.priya.computationalTheory.ParseTree.ParseTree;
import vora.priya.computationalTheory.StateMachine.State_Machine;
import vora.priya.computationalTheory.Tokenizer.Tokenizer;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Traffic Advisor...");
		Driver driver = new Driver();
		boolean run = true;

		loop: while (run) {
			ParseTree parseTree = new ParseTree();
			try {
				String userInput = driver.readInput().trim();
				if (userInput.equals("0")) {
					break loop;
				} else {
					// parseTree.getTokenizer().tokenize(userInput);
					for (int i = 0; i < parseTree.getTokenizer().getTokenizerList().size(); i++) {
						System.out.println(": " + parseTree.getTokenizer().getTokenizerList().get(i));
					}
					System.out.println(" ");

					boolean valid_response = parseTree.isCityInfo(userInput);
					// System.out.println("VALID: " + valid_response);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("USER: ");

		String readline = reader.readLine();
		return readline;
	}

}
