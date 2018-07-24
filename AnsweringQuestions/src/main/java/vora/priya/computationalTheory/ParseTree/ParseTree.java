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

	private boolean tokenize(String userInput) {
		return tokenizer.tokenize(userInput);
	}

	public boolean isCityInfo(String userInput) {
		boolean isTokenize = tokenize(userInput.trim());
		if (isTokenize == true) {
			return grammerCheck(userInput);

		} else {
			return false;
		}
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
				checkifDistanceInfo();
			}
			counter = 0;
		}
		checkifDistanceInfo();

		boolean valid = checkIfStackContainsAValidCityInfo();
		printStack();
		return valid;
	}

	private void checkifDistanceInfo() {
		Determiner determiner = new Determiner();
		DistanceNumber number = new DistanceNumber();
		KM kilometer = new KM();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Kilometer")) {
				kilometer = (KM) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Distance Number")) {
						number = (DistanceNumber) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Determiner")) {
								determiner = (Determiner) stack.pop();

								DistanceInfo distanceInfo = new DistanceInfo();
								distanceInfo.setSymbol("Distance Info");
								distanceInfo.setDeteriminer(determiner);
								distanceInfo.setDistanceNumber(number);
								distanceInfo.setKilometers(kilometer);
								stack.push(distanceInfo);
							}
						} else {
							stack.push(number);
							stack.push(kilometer);

						}
					}
				} else {
					stack.push(kilometer);
				}

			}
		}

	}

	private boolean checkIfStackContainsAValidCityInfo() {
		return false;
	}

	private boolean checkIfStackCanBeReduced(Symbol symbol) {
		if (checkIfStackReduceTo_Determiner() == true) {
			Determiner det = new Determiner();
			det.setSymbol("Determiner");
			det.setDeterminer_Value(symbol.getSymbol());
			stack.pop();
			stack.push(det);
			return true;
		} else if (checkIfStackReduceTo_Number() == true) {
			DistanceNumber number = new DistanceNumber();
			number.setSymbol("Distance Number");
			number.setDistanceValue(symbol.getSymbol());
			stack.pop();
			stack.push(number);
			return true;
		} else if (checkIfStackReduceTo_KM() == true) {
			KM kilometers = new KM();
			kilometers.setSymbol("Kilometer");
			kilometers.setKm_Value(symbol.getSymbol());
			stack.pop();
			stack.push(kilometers);
			return true;
		} else if (checkIfStackReduceTo_Noun() == true) {
			Noun noun = new Noun();
			noun.setSymbol("Noun");
			noun.setNoun_Value(symbol.getSymbol());
			stack.pop();
			stack.push(noun);
			return true;
		} else if (checkIfStackReduceTo_Conjunction() == true) {
			Conjunction conjunction = new Conjunction();
			conjunction.setSymbol("Conjunction");
			conjunction.setConjunction_Value(symbol.getSymbol());
			stack.pop();
			stack.push(conjunction);
			return true;
		} else if (checkIfStackReduceTo_Verb() == true) {
			Verb verb = new Verb();
			verb.setSymbol("Verb");
			verb.setVerb_Value(symbol.getSymbol());
			stack.pop();
			stack.push(verb);

			return true;
		} else {
			CityName cityName = new CityName();
			cityName.setSymbol("City");
			cityName.setCityName_Value(symbol.getSymbol());
			stack.pop();
			stack.push(cityName);
			return true;
		}
	}

	public boolean checkIfStackReduceTo_Conjunction() {
		Conjunction conjunction = new Conjunction();
		return conjunction.isConjunction(stack.peek().getSymbol());
	}

	public boolean checkIfStackReduceTo_Verb() {
		Verb verb = new Verb();
		return verb.isVerb(stack.peek().getSymbol());
	}

	public boolean checkIfStackReduceTo_Noun() {
		Noun noun = new Noun();
		return noun.isNoun(stack.peek().getSymbol());
	}

	private boolean checkIfStackReduceTo_KM() {
		KM kilometers = new KM();
		return kilometers.isKM(stack.peek().getSymbol());
	}

	private boolean checkIfStackReduceTo_Number() {
		DistanceNumber number = new DistanceNumber();
		return number.isNumber(stack.peek().getSymbol());
	}

	private boolean checkIfStackReduceTo_Determiner() {
		Determiner determiner = new Determiner();
		return determiner.isDeterminant(stack.peek().getSymbol());
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

	public Tokenizer getTokenizer() {
		return tokenizer;
	}

	public void setTokenizer(Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public Stack<Symbol> getStack() {
		return stack;
	}

	public void setStack(Stack<Symbol> stack) {
		this.stack = stack;
	}

}
