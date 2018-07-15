package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import vora.priya.computationalTheory.ParseTree.ParseTree;
import vora.priya.computationalTheory.StateMachine.State_Machine;

public class Driver {

	public static void main(String[] args) throws IOException {
		System.out.println("Chat Service has Started...");

		State_Machine machine = new State_Machine();
		Driver driver = new Driver();
		boolean run = true;
		while (run) {
			driver.chat(machine);
		}
	}

	public String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("USER: ");

		String readline = reader.readLine();
		return readline;
	}

	public void chat(State_Machine machine) throws IOException {
		System.out.println("\nCHATBOT: " + chatBot_Message(machine, readInput()));
	}

	public String chatBot_Message(State_Machine machine, String testString) {
		String[] hi_Responses = { "Hi", "sup?", "What's up?", "Hey!" };
		String[] hello_Responses = { "Hello", "How are you?" };
		String[] howdy_Responses = { "Howdy partner", "Howdy!" };
		String[] aloha_Responses = { "Aloha", "Surf's up!" };
		String[] thank_you_Responses = { "You're welcome", "No, thank you!", "My pleasure", "No Problem" };
		String[] no_match_Responses = { "What great weather!", "Tell me about yourself", "What do you like to do?",
				"What makes you sad?" };
		
		ParseTree parseTree = new ParseTree();
		parseTree.isSentence(testString);
				
		return "This is my message";
	}
}
