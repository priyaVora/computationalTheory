package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Stack;

import vora.priya.computationalTheory.Tokenizer.Tokenizer;

public class ParseTree {
	private Tokenizer tokenizer;

	Stack<Symbol> stack = new Stack<Symbol>();

	public ParseTree() {
		tokenizer = new Tokenizer();
	}

	public boolean isSentence(String userInput) {
		boolean isTokenize = tokenize(userInput.trim());
		if (isTokenize == true) {
			return grammerCheck(userInput);

		} else {
			return false;
		}
	}

	private boolean tokenize(String userInput) {
		return tokenizer.tokenize(userInput);
	}

	public boolean grammerCheck(String userInput) {
		ArrayList<String> tokenList = tokenizer.getTokenizerList();
		int counter = 0;
		for (String eachToken : tokenList) {
			// shift the next input symbol onto the stack
			Symbol symbol = new Symbol();
			symbol.setSymbol(eachToken);
			stack.add(symbol);

			// while (!(stack.peek() instanceof Sentence)) { // while the top of the stack
			// can be reduced....
			// System.out.println("Shreya!");
			// }

			if (checkIfStackCanBeReduced() == true) {

				checkifNomExist();

			}
			counter = 0;
		}

		checkifNomExist();

		printStack();
		return checkIfStackContainsAValidSentence();
	}

	public boolean checkIfStackContainsAValidSentence() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Sentence")) {
				if (stack.size() == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	public void checkifNomExist() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Noun")) {
				stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Adjective")) {
						stack.pop();
						Nominative_Case nom = new Nominative_Case();
						nom.setSymbol("Nom");
						stack.push(nom);
					} else { 
						Nominative_Case nom = new Nominative_Case();
						nom.setSymbol("Nom");
						stack.push(nom);
					}
				} else {
					Noun noun = new Noun();
					noun.setSymbol("Noun");
					stack.push(noun);
				}
			}
		}

		checkIfNounPhraseExist();
	}

	private void checkIfNounPhraseExist() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Nom")) {
				stack.pop();
				if (stack.peek().getSymbol().equals("Determinant")) {
					stack.pop();
					Noun_Phrase noun_phrase = new Noun_Phrase();
					noun_phrase.setSymbol("NP");
					stack.push(noun_phrase);
				} else {
					Nominative_Case nom = new Nominative_Case();
					nom.setSymbol("Nom");
					stack.push(nom);
				}
			}
			checkIfVerbPhrase();
		}
	}

	private void checkIfSentence() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("VP")) {
				stack.pop();
				if (stack.peek().getSymbol().equals("NP")) {
					stack.pop();
					Sentence sentence = new Sentence();
					sentence.setSymbol("Sentence");
					stack.push(sentence);
				} else {
					Nominative_Case nom = new Nominative_Case();
					nom.setSymbol("Nom");
					stack.push(nom);
				}
			}
		}
	}

	private void checkIfVerbPhrase() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("NP")) {
				stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Verb")) {
						stack.pop();
						Verb_Phrase verb_phrase = new Verb_Phrase();
						verb_phrase.setSymbol("VP");
						stack.push(verb_phrase);
					}
				} else {
					Noun_Phrase noun_phrase = new Noun_Phrase();
					noun_phrase.setSymbol("NP");
					stack.push(noun_phrase);
				}
			}
		}
		checkIfSentence();
	}

	public boolean checkIfStackCanBeReduced() {
		Sentence sentence = new Sentence();
		Noun_Phrase noun_phrase = new Noun_Phrase();
		Verb_Phrase verb_phrase = new Verb_Phrase();

		if (checkifStackCanReduceTo_Determinant() == true) {
			Determiner det = new Determiner();
			det.setSymbol("Determinant");
			stack.pop();
			stack.push(det);
			return true;
		} else if (checkifStackCanReduceTo_Noun() == true) {
			Noun noun = new Noun();
			noun.setSymbol("Noun");
			stack.pop();
			stack.push(noun);
			return true;
		} else if (checkifStackCanReduceTo_NOM() == true) {
			Nominative_Case nom = new Nominative_Case();
			nom.setSymbol("Nom");
			stack.pop();
			stack.push(nom);
			return true;
		} else if (checkifStackCanReduceTo_Adjective() == true) {
			Adjective adjective = new Adjective();
			adjective.setSymbol("Adjective");
			stack.pop();
			stack.push(adjective);
			return true;
		} else if (checkifStackCanReduceTo_Verb() == true) {
			Verb verb = new Verb();
			verb.setSymbol("Verb");
			stack.pop();
			stack.push(verb);
			return true;
		} else {
			return false;
		}
	}

	public boolean checkifStackCanReduceTo_Determinant() {
		Determiner determiner = new Determiner();
		return determiner.isDeterminant(stack.peek().getSymbol());
	}

	public boolean checkifStackCanReduceTo_Noun() {
		Noun noun = new Noun();
		return noun.isNoun(stack.peek().getSymbol());
	}

	public boolean checkifStackCanReduceTo_NOM() {
		Nominative_Case nom = new Nominative_Case();
		Noun noun = new Noun();
		noun.setSymbol(stack.peek().getSymbol());
		return nom.isNom(noun);
	}

	public boolean checkifStackCanReduceTo_Adjective() {
		Adjective adjective = new Adjective();
		return adjective.isAdjective(stack.peek().getSymbol());
	}

	public boolean checkifStackCanReduceTo_Verb() {
		Verb verb = new Verb();
		return verb.isVerb(stack.peek().getSymbol());
	}

	public void printStack() {

		System.out.println("---------------");
		int stackCount = stack.size();
		for (int i = 0; i < stackCount; i++) {
			System.out.println("     " + stack.pop().getSymbol());
			System.out.println("---------------");

		}

		System.out.println("     " + "E");
		System.out.println("---------------");
	}
}
