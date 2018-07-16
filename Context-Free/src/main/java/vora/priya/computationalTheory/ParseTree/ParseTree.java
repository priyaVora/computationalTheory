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
			if (checkIfStackCanBeReduced(symbol) == true) {
				checkifNomExist();
			}
			counter = 0;
		}

		checkifNomExist();
		boolean valid = checkIfStackContainsAValidSentence();
		// if(valid == true) {
		// Sentence sentence = stack.peek();
		// } else {
		//
		// }
		return valid;
	}

	public boolean checkIfStackContainsAValidSentence() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Sentence")) {
				if (stack.size() == 1) {
					sentenceRecognized = (Sentence) stack.peek();
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
		Noun noun = new Noun();
		Adjective adjective = new Adjective();
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Noun")) {
				noun = (Noun) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Adjective")) {
						adjective = (Adjective) stack.pop();
						Nominative_Case nom = new Nominative_Case();
						nom.setAdjective(adjective);
						nom.setNoun(noun);
						nom.setSymbol("Nom");
						stack.push(nom);
					} else {
						Nominative_Case nom = new Nominative_Case();
						nom.setSymbol("Nom");
						nom.setAdjective(null);
						nom.setNoun(noun);
						stack.push(nom);
					}
				} else {

					// noun.setSymbol("Noun");
					stack.push(noun);
				}
			}
		}

		checkIfNounPhraseExist();
	}

	private void checkIfNounPhraseExist() {
		Nominative_Case nom = new Nominative_Case();
		Determiner determiner = new Determiner();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Nom")) {
				nom = (Nominative_Case) stack.pop();
				if (stack.peek().getSymbol().equals("Determinant")) {
					determiner = (Determiner) stack.pop();
					Noun_Phrase noun_phrase = new Noun_Phrase();
					noun_phrase.setSymbol("NP");
					noun_phrase.setDeterminer(determiner);
					noun_phrase.setNominative_Case(nom);
					stack.push(noun_phrase);
				} else {
					// Nominative_Case nom = new Nominative_Case();
					// nom.setSymbol("Nom");
					stack.push(nom);
				}
			}
			checkIfVerbPhrase();
		}
	}

	private void checkIfSentence() {
		Verb_Phrase vp = new Verb_Phrase();
		Noun_Phrase np = new Noun_Phrase();
		
		
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("VP")) {
				vp = (Verb_Phrase) stack.pop();
				if (stack.peek().getSymbol().equals("NP")) {
					np = (Noun_Phrase) stack.pop();
					Sentence sentence = new Sentence();
					sentence.setSymbol("Sentence");
					sentence.setNoun_Phrase(np);
					sentence.setVerb_Phrase(vp);
					stack.push(sentence);
				} else { 
					stack.push(vp);
				}
			}
		}
	}

	private void checkIfVerbPhrase() {
		Noun_Phrase np = new Noun_Phrase();
		Verb verb = new Verb();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("NP")) {
				np = (Noun_Phrase) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Verb")) {
						verb = (Verb) stack.pop();
						Verb_Phrase verb_phrase = new Verb_Phrase();
						verb_phrase.setSymbol("VP");
						verb_phrase.setNoun_Phrase(np);
						verb_phrase.setVerb(verb);
						stack.push(verb_phrase);
					}
				} else {
					
					stack.push(np);
				}
			}
		}
		checkIfSentence();
	}

	public boolean checkIfStackCanBeReduced(Symbol symbol) {
		Sentence sentence = new Sentence();
		Noun_Phrase noun_phrase = new Noun_Phrase();
		Verb_Phrase verb_phrase = new Verb_Phrase();

		if (checkifStackCanReduceTo_Determinant() == true) {
			Determiner det = new Determiner();
			det.setSymbol("Determinant");
			det.setDeterminer_Value(symbol.getSymbol());
			stack.pop();
			stack.push(det);
			return true;
		} else if (checkifStackCanReduceTo_Noun() == true) {
			Noun noun = new Noun();
			noun.setSymbol("Noun");
			noun.setNoun_Value(symbol.getSymbol());
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
			adjective.setAdjectiveValue(symbol.getSymbol());
			stack.pop();
			stack.push(adjective);
			return true;
		} else if (checkifStackCanReduceTo_Verb() == true) {
			Verb verb = new Verb();
			verb.setSymbol("Verb");
			verb.setVerb_Value(symbol.getSymbol());
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

	public Sentence getSentenceRecognized() {
		return sentenceRecognized;
	}

	public void setSentenceRecognized(Sentence sentenceRecognized) {
		this.sentenceRecognized = sentenceRecognized;
	}

}
