package vora.priya.computationalTheory.RegFiniteMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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

	public void chat(State_Machine machine) throws IOException {
		System.out.println("\nCHATBOT: " + chatBot_Message(machine, readInput()));
	}

	public String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("USER: ");

		String readline = reader.readLine();
		return readline;
	}

	public String chatBot_Message(State_Machine machine, String testString) {
		String[] hi_Responses = { "Hi", "sup?", "What's up?", "Hey!" };
		String[] hello_Responses = { "Hello", "How are you?" };
		String[] howdy_Responses = { "Howdy partner", "Howdy!" };
		String[] aloha_Responses = { "Aloha", "Surf's up!" };
		String[] thank_you_Responses = { "You're welcome", "No, thank you!", "My pleasure", "No Problem" };
		String[] no_match_Responses = { "What great weather!", "Tell me about yourself", "What do you like to do?",
				"What makes you sad?" };
		Random rand = new Random();

		boolean input_Exist = machine.state_machineHelper(testString.trim());
		System.out.println("EXIST: " + input_Exist);
		if (input_Exist == true) {
			int random = 0;
			String responseToBeReturned = null;
			if (machine.getTestedValue().contains("hi") || machine.getTestedValue().contains("Hi")) {
				random = rand.nextInt(hi_Responses.length);
				responseToBeReturned = hi_Responses[random];
				return responseToBeReturned;
			} else if (machine.getTestedValue().contains("hello") || machine.getTestedValue().contains("Hello")) {
				random = rand.nextInt(hello_Responses.length);
				responseToBeReturned = hello_Responses[random];
				return responseToBeReturned;
			} else if (machine.getTestedValue().contains("Howdy") || machine.getTestedValue().contains("howdy")) {
				random = rand.nextInt(howdy_Responses.length);
				responseToBeReturned = howdy_Responses[random];
				return responseToBeReturned;
			} else if (machine.getTestedValue().contains("aloha") || machine.getTestedValue().contains("Aloha")) {
				random = rand.nextInt(aloha_Responses.length);
				responseToBeReturned = aloha_Responses[random];
				return responseToBeReturned;
			} else {
				random = rand.nextInt(no_match_Responses.length);
				responseToBeReturned = no_match_Responses[random];
				return responseToBeReturned;
			}

		} else {
			int random = rand.nextInt(no_match_Responses.length);
			return no_match_Responses[random];
		}

	}
}
