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
	ArrayList<ParseTree> parseTreeList = new ArrayList<ParseTree>();

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
			parseTreeList.add(parseTree);
			String genResponse = generateValidResponse(parseTree);
			parseTree.setParseTreeResponse(genResponse);
			return genResponse;
		} else {
			// parseTree.getSentenceRecognized().toString();
			// parseTree.printStack();
			if (parseTreeList != null && !(parseTreeList.isEmpty())) {
				String newR = generateValidResponse_ForInvalidInput(parseTreeList.get(parseTreeList.size() - 1));
				return newR;
			} else {
				return "Sorry I don't understand";
			}
		}
	}

	public String generateValidResponse_ForInvalidInput(ParseTree previosTree) {
		Random random = new Random();

		List<String> responseList = new ArrayList<String>();

		String reponseOne = "Tell me more about "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseOne);
		String responseTwo = "So what do you think of "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ "this weekend?";
		responseList.add(responseTwo);
		String responseThree = previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after()
				+ " is great! I remember my childhood memories are filled with "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getNoun();
		responseList.add(responseThree);
		int size = previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb()
				.getListOfValidVerb().length;
		int rand = random.nextInt(size);
		String responseFour = "During my college days, till now I like "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb()
						.getListOfValidVerb()[rand]
				+ " a lot of things " + previosTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getNoun();
		;
		responseList.add(responseFour);

		String responseFive = "Despite that, I can't stop "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ previosTree.getSentenceRecognized().getNoun_phrase().getNoun();
		responseList.add(responseFive);

		String responseSix = "I have been thinking about "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ "this weekend";
		responseList.add(responseSix);

		String reponseSeven = "Do you know if your friends are okay with "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseSeven);

		String reponseEight = "Are you okay with "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseEight);

		String reponseNine = "Interesting tell me more about "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseNine);

		String reponseTen = "People can't stop talking about "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ previosTree.getSentenceRecognized().getVerb_phrase().getNoun_after()
				+ " go ahead tell me more about it...";
		responseList.add(reponseTen);

		int randRepsonse = random.nextInt(responseList.size());
		String newR = responseList.get(randRepsonse);
		boolean valid = true;

		if (!(previosTree.getParseTreeResponse().equals(newR))) {
			previosTree.setParseTreeResponse(newR);
			parseTreeList.add(previosTree);
			return newR;
		} else {
			return generateValidResponse_ForInvalidInput(previosTree);
		}

		// loop: for (ParseTree eachPreviousParseTree : parseTreeList) {
		// System.out.println("New Possible Response: " + newR);
		// if (eachPreviousParseTree.getParseTreeResponse().equals(newR)) {
		// System.out.println("Not Valid: " +
		// eachPreviousParseTree.getParseTreeResponse());
		// valid = false;
		// break loop;
		// } else {
		// System.out.println("Current Each: " +
		// eachPreviousParseTree.getParseTreeResponse());
		// }
		//
		// }
		// if (valid == true) {
		// //previosTree.setParseTreeResponse(newR);
		// ParseTree parseT = new ParseTree();
		// parseT = previosTree;
		// parseT.setParseTreeResponse(newR);
		// //parseTreeList.add(parseT);
		// return newR;
		// } else {
		// return generateValidResponse_ForInvalidInput(previosTree);
		// }
		// System.out.println("VALID");
		// if (valid == true) {
		// parseTreeList.add(previosTree);
		// return newR;
		// }
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
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb()
						.getListOfValidVerb()[rand]
				+ " a lot of things " + parseTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getNoun();
		;
		responseList.add(responseFour);

		String responseFive = "Despite that, I can't stop "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getPreposition() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getDeterminer() + " "
				+ parseTree.getSentenceRecognized().getNoun_phrase().getNoun();
		responseList.add(responseFive);

		String responseSix = "I have been thinking about "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " " + "this weekend";
		responseList.add(responseSix);

		String reponseSeven = "Do you know if your friends are okay with "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseSeven);

		String reponseEight = "Are you okay with "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseEight);

		String reponseNine = "Interesting tell me more about "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after();
		responseList.add(reponseNine);

		String reponseTen = "People can't stop talking about "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getSpecial_verb().getVerb() + " "
				+ parseTree.getSentenceRecognized().getVerb_phrase().getNoun_after()
				+ " go ahead tell me more about it...";
		responseList.add(reponseTen);

		int randRepsonse = random.nextInt(responseList.size());
		return responseList.get(randRepsonse);
	}
}
