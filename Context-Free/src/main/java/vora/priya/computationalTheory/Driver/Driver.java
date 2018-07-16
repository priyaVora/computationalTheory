package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import vora.priya.computationalTheory.ParseTree.ParseTree;
import vora.priya.computationalTheory.ParseTree.Sentence;
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
			//parseTree.printStack();
			return "Sorry, I didn't understand what you said, can you please repeat yourself?";
		}
	}

	public String generateValidResponse(ParseTree parseTree) {
		Random rand = new Random();
		int randomNum = rand.nextInt(15);
		if (randomNum < 3) {
			return "How did you feel when you found out that " + parseTree.getSentenceRecognized().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNomCombination() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case()
							.getNomCombination()
					+ "?";
		} else if (randomNum == 3 || randomNum == 4) {
			return "Oh I see, " + parseTree.getSentenceRecognized().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNomCombination() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case()
							.getNomCombination()
					+ ", that is very odd...";
		} else if (randomNum == 5 || randomNum == 6) {
			return "Oh no, " + parseTree.getSentenceRecognized().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNomCombination() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case()
							.getNomCombination()
					+ ", I don't like that...!";
		} else if (randomNum == 7 || randomNum == 8) {
			return "Did I hear this right, that " + parseTree.getSentenceRecognized().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNomCombination() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case()
							.getNomCombination()
					+ "?";
		} else if (randomNum == 9 || randomNum == 10) {
			return "Well since " + parseTree.getSentenceRecognized().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNomCombination() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case()
							.getNomCombination()
					+ ", this world is getting weird day by day. Would you agree?";
		} else {
			return "Yea that doesn't sound good to me... When you said, "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getNoun_Phrase().getNominative_Case().getNomCombination() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getVerb() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getDeterminer() + " "
					+ parseTree.getSentenceRecognized().getVerb_Phrase().getNoun_Phrase().getNominative_Case()
							.getNomCombination()
					+ ", I got a cold shiver in my body";
		}
	}
}
