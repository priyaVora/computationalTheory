package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


import vora.priya.computationalTheory.ParseTree.Noun;
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
			// parseTree.printStack();
			return "Sorry, I didn't understand what you said, can you please repeat yourself?";
		}
	}

	public String generateValidResponse(ParseTree parseTree) {
		Random rand = new Random();
		// Adjective adjective = new Adjective();
		Noun nouns = new Noun();
		int randomNum = rand.nextInt(15);

		// int response_random_generator =
		// rand.nextInt(adjective.getListOfValidAdjectives().length);
		// int response_random_generatorNoun =
		// rand.nextInt(nouns.getListofValidNouns().length);
		//
		//
		// if (randomNum < 3) {
		// return " That " +
		// adjective.getListOfValidAdjectives()[response_random_generator] + " " +
		// parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNoun()+
		// " "+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() +
		// " " + nouns.getListofValidNouns()[response_random_generatorNoun];
		// } else if (randomNum == 3 || randomNum == 4) {
		// return " Those " +
		// adjective.getListOfValidAdjectives()[response_random_generator] + " " +
		// parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNoun()+
		// " "+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() +
		// " " + nouns.getListofValidNouns()[response_random_generatorNoun];
		// } else if (randomNum == 5 || randomNum == 6) {
		// return " Our " +
		// adjective.getListOfValidAdjectives()[response_random_generator] + " " +
		// parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNoun()+
		// " "+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() +
		// " " + nouns.getListofValidNouns()[response_random_generatorNoun];
		// } else if (randomNum == 7 || randomNum == 8) {
		// return " Each " +
		// adjective.getListOfValidAdjectives()[response_random_generator] + " " +
		// parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNoun()+
		// " "+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() +
		// " " + nouns.getListofValidNouns()[response_random_generatorNoun];
		// } else if (randomNum == 9 || randomNum == 10) {
		// return " Every " +
		// adjective.getListOfValidAdjectives()[response_random_generator] + " " +
		// parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNoun()+
		// " "+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() +
		// " " + nouns.getListofValidNouns()[response_random_generatorNoun];
		// } else {
		// return " Such " +
		// adjective.getListOfValidAdjectives()[response_random_generator] + " " +
		// parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case().getNoun()+
		// " "+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() +
		// " " + nouns.getListofValidNouns()[response_random_generatorNoun];
		// }
		return "This is the message";
	}
}
