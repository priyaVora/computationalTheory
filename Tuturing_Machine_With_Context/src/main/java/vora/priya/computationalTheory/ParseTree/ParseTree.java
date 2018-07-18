package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Stack;

import vora.priya.computationalTheory.Tokenizer.Tokenizer;

public class ParseTree {
	private Tokenizer tokenizer;

	Stack<Symbol> stack = new Stack<Symbol>();
	Sentence sentenceRecognized = new Sentence();

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

	private boolean grammerCheck(String userInput) {
		ArrayList<String> tokenList = tokenizer.getTokenizerList();
		int counter = 0;
		for (String eachToken : tokenList) {
			Symbol symbol = new Symbol();
			symbol.setSymbol(eachToken);
			stack.add(symbol);

			if (checkIfStackCanBeReduced(symbol) == true) {
				checkIfSpecialVerbExist();
			}
			counter = 0;
		}
		checkIfSpecialVerbExist();
		// boolean valid = checkIfStackContainsAValidSentence();
		boolean valid = false;
		printStack();
		return valid;
	}

	private void checkIfSpecialVerbExist() {
		Description_Verb descriptiveVerb = new Description_Verb();
		Verb verb = new Verb();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Verb")) {
				verb = (Verb) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Description_Verb")) {
						descriptiveVerb = (Description_Verb) stack.pop();
						Special_Verb specialVerb = new Special_Verb();
						specialVerb.setDesc_verb(descriptiveVerb);
						specialVerb.setVerb(verb);
						specialVerb.setSymbol("Special Verb");
						stack.push(specialVerb);
					} else {
						Special_Verb specialVerb = new Special_Verb();
						specialVerb.setSymbol("Special Verb");
						specialVerb.setVerb(verb);
						stack.push(specialVerb);
					}

				} else {
					stack.push(verb);
				}
			}
		}
		checkIfVerbPhraseExist();
	}

	private void checkIfVerbPhraseExist() {
		Noun beforeNoun = new Noun();
		Special_Verb specialVerb = new Special_Verb();
		Noun afterNoun = new Noun();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Noun")) {
				beforeNoun = (Noun) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Special Verb")) {
						specialVerb = (Special_Verb) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Noun")) {
								afterNoun = (Noun) stack.pop();
								Verb_Phrase verb_Phrase = new Verb_Phrase();
								verb_Phrase.setSymbol("Verb Phrase");
								verb_Phrase.setNoun_before(beforeNoun);
								verb_Phrase.setSpecial_verb(specialVerb);
								verb_Phrase.setNoun_after(afterNoun);
								stack.push(verb_Phrase);
							} else {
								stack.push(specialVerb);
							}
						} else {
							stack.push(specialVerb);
						}
					} else {
						stack.push(beforeNoun);
					}
				} else {
					stack.push(beforeNoun);
				}
			}
		}

	}

	private boolean checkIfStackCanBeReduced(Symbol symbol) {
		Sentence sentence = new Sentence();
		Noun_Phrase noun_Phrase = new Noun_Phrase();
		Verb_Phrase verb_Phrase = new Verb_Phrase();

		if (checkifStackCanReducedTo_Adverb() == true) {
			Adverb adverb = new Adverb();
			adverb.setSymbol("Adverb");
			adverb.setAdverb_Value(symbol.getSymbol());
			stack.pop();
			stack.push(adverb);
			return true;
		} else if (checkifStackCanReduceTo_Noun() == true) {
			Noun noun = new Noun();
			noun.setSymbol("Noun");
			noun.setNoun_Value(symbol.getSymbol());
			stack.pop();
			stack.push(noun);
			return true;
		} else if (checkifStackCanReduceTo_Verb() == true) {
			Verb verb = new Verb();
			verb.setSymbol("Verb");
			verb.setVerb_Value(symbol.getSymbol());
			stack.pop();
			stack.push(verb);
			return true;
		} else if (checkifStackCanReduceTo_DescriptiveVerb() == true) {
			Description_Verb desc_verb = new Description_Verb();
			desc_verb.setSymbol("Description_Verb");
			desc_verb.setDescriptionVerb_Value(symbol.getSymbol());
			stack.pop();
			stack.push(desc_verb);
			return true;
		} else if (checkifStackCanReduceTo_Preposition() == true) {
			Preposition preposition = new Preposition();
			preposition.setSymbol("Preposition");
			preposition.setPreposition_Value(symbol.getSymbol());
			stack.pop();
			stack.push(preposition);
			return true;
		} else if (checkifStackCanReduceTo_Determiners() == true) {
			Determiner determiner = new Determiner();
			determiner.setSymbol("Determiner");
			determiner.setDet_Value(symbol.getSymbol());
			stack.pop();
			stack.push(determiner);
		}
		return false;
	}

	private boolean checkifStackCanReduceTo_Determiners() {
		Determiner determiner = new Determiner();
		return determiner.isDeterminer(stack.peek().getSymbol());
	}

	private boolean checkifStackCanReduceTo_Preposition() {
		Preposition preposition = new Preposition();
		return preposition.isPreposition(stack.peek().getSymbol());
	}

	private boolean checkifStackCanReduceTo_DescriptiveVerb() {
		Description_Verb desc_verb = new Description_Verb();
		return desc_verb.isDescriptionVerb(stack.peek().getSymbol());
	}

	private boolean checkifStackCanReducedTo_Adverb() {
		Adverb adverb = new Adverb();
		return adverb.isAdverb(stack.peek().getSymbol());
	}

	public boolean checkifStackCanReduceTo_Noun() {
		Noun noun = new Noun();
		return noun.isNoun(stack.peek().getSymbol());
	}

	public boolean checkifStackCanReduceTo_Verb() {
		Verb verb = new Verb();
		return verb.isVerb(stack.peek().getSymbol());
	}

	public void printStack() {

		Stack<Symbol> newStack = stack;

		System.out.println("---------------");
		int stackCount = newStack.size();
		for (int i = 0; i < stackCount; i++) {
			System.out.println("     " + newStack.pop().getSymbol());
			System.out.println("---------------");

		}

		System.out.println("     " + "E");
		System.out.println("---------------");
	}

	private boolean tokenize(String userInput) {
		return tokenizer.tokenize(userInput);
	}
}
