package vora.priya.computationalTheory.driver;

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
		String[] ahoy_mate = { "Ahoy mate!", "Ahoy!" };
		String[] howareyouquestions = { "Im ok", "Great, you?!", "Meh", "Not bad!" };
		Random rand = new Random();
		int random = 0;
		String responseToBeReturned = null;
		String userInputDetected = machine.state_Machine_Helper(testString);
		System.out.println("User Input Detected: " + userInputDetected);

		if (userInputDetected != null) {
			if (userInputDetected.equals("hi")) {
				random = rand.nextInt(hi_Responses.length);
				responseToBeReturned = hi_Responses[random];
			} else if (userInputDetected.equals("hello")) {
				random = rand.nextInt(hello_Responses.length);
				responseToBeReturned = hello_Responses[random];
			} else if (userInputDetected.equals("howdy")) {
				random = rand.nextInt(howdy_Responses.length);
				responseToBeReturned = howdy_Responses[random];
			} else if (userInputDetected.equals("aloha")) {
				random = rand.nextInt(aloha_Responses.length);
				responseToBeReturned = aloha_Responses[random];
			} else if (userInputDetected.equals("thankYou")) {
				random = rand.nextInt(thank_you_Responses.length);
				responseToBeReturned = thank_you_Responses[random];
			} else if (userInputDetected.equals("thanks")) {
				random = rand.nextInt(thank_you_Responses.length);
				responseToBeReturned = thank_you_Responses[random];
			} else if (userInputDetected.equals("ahoy mate")) {
				random = rand.nextInt(ahoy_mate.length);
				responseToBeReturned = ahoy_mate[random];
			} else if (userInputDetected.equals("?")) {
				random = rand.nextInt(howareyouquestions.length);
				responseToBeReturned = howareyouquestions[random];
			}

			return responseToBeReturned;
		} else {
			random = rand.nextInt(no_match_Responses.length);
			responseToBeReturned = no_match_Responses[random];
			return responseToBeReturned;

		}
	}
}
