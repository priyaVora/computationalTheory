package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

		ParseTree parseTree = new ParseTree();
		boolean valid_response = parseTree.isSentence(testString);

		if (valid_response == true) {
			// System.out.println("::: " + parseTree.getSentenceRecognized().toString());
			// parseTree.printStack();
			return generateValidResponse(parseTree);
		} else {

			return "Sorry, I didn't understand what you said, can you please repeat yourself?";
		}
	}

	public String generateValidResponse(ParseTree parseTree) {
		Random random = new Random();

		List<String> responseList = new ArrayList<String>();

		String reponseOne = "Tell me more about "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseOne);
		String responseTwo = "So what do you think of "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ "this weekend?";
		responseList.add(responseTwo);
		String responseThree = parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after()
				+ " is great! I remember my childhood memories are filled with "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getNoun();
		responseList.add(responseThree);
		int size = parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb()
				.getListOfValidVerb().length;
		int rand = random.nextInt(size);
		String responseFour = "During my college days, till now I like "
				+ parseTree
						.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb().getListOfValidVerb()[rand]
				+ " a lot of things " +parseTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getNoun(); ;
		responseList.add(responseFour);

		String responseFive = "Despite that, I "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getNoun();
		responseList.add(responseFive);

		int randRepsonse = random.nextInt(responseList.size());
		return responseList.get(randRepsonse);
	}
}
