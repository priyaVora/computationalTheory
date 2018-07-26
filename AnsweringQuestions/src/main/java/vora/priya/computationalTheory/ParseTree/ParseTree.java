package vora.priya.computationalTheory.ParseTree;

import java.util.ArrayList;
import java.util.Stack;

import vora.priya.computationalTheory.Tokenizer.Tokenizer;

public class ParseTree {
	private CityInfo sentenceRecognized;
	private CityQuestion sentenceQuestion;

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
		checkifCityComboInfo();
		checkifDistanceInfo();
		checkifCityInfoExist();
		checkifCityQuestionExist();
		boolean validInfo = checkIfStackContainsAValidCityInfo();
		boolean validQuestion = checkIfStackContainsAValidCityQuestion();
		if (validInfo == true) {
			sentenceQuestion = null;
		} else if (validQuestion == true) {
			sentenceRecognized = null;
		} else {
			return false;
		}
		// printStack();
		return validInfo;
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
		checkIfDescriptionInfoExist();

	}

	private void checkifCityInfoExist() {
		CityComboInfo cityComboInfo = new CityComboInfo();
		DescriptionInfo descriptionInfo = new DescriptionInfo();
		DistanceInfo distanceInfo = new DistanceInfo();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("City Combo Info")) {
				cityComboInfo = (CityComboInfo) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Description Info")) {
						descriptionInfo = (DescriptionInfo) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Distance Info")) {
								distanceInfo = (DistanceInfo) stack.pop();
								CityInfo cityInfo = new CityInfo();
								cityInfo.setCityComboInfo(cityComboInfo);
								cityInfo.setDescriptionInfo(descriptionInfo);
								cityInfo.setDistanceInfo(distanceInfo);
								cityInfo.setSymbol("City Info");
								stack.push(cityInfo);
							}
						} else {
							stack.push(descriptionInfo);
							stack.push(cityComboInfo);

						}
					} else {
						stack.push(cityComboInfo);
					}
				} else {
					stack.push(cityComboInfo);
				}

			}
		}

	}

	private void checkifCityQuestionExist() {
		QuestionPartTwo partTwo = new QuestionPartTwo();
		Nominative_Case nominativeCase = new Nominative_Case();
		QuestionPartOne partOne = new QuestionPartOne();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Part Two")) {
				partTwo = (QuestionPartTwo) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Nominative Case")) {
						nominativeCase = (Nominative_Case) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Part One")) {
								partOne = (QuestionPartOne) stack.pop();

								CityQuestion question = new CityQuestion();
								question.setSymbol("City Question");
								question.setNominative(nominativeCase);
								question.setQuestionOne(partOne);
								question.setQuestionTwo(partTwo);
								stack.push(question);
							}
						} else {
							stack.push(nominativeCase);
							stack.push(partTwo);

						}
					} else {
						stack.push(nominativeCase);
					}
				} else {
					stack.push(partTwo);
				}

			}
		}

	}

	private void checkifCityComboInfo() {
		CityName city2 = new CityName();
		Conjunction conjunction = new Conjunction();
		CityName city1 = new CityName();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("City")) {
				city2 = (CityName) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Conjunction")) {
						conjunction = (Conjunction) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("City")) {
								city1 = (CityName) stack.pop();

								CityComboInfo cityCombo = new CityComboInfo();
								cityCombo.setCityOne(city1);
								cityCombo.setConjunction(conjunction);
								cityCombo.setCityTwo(city2);
								cityCombo.setSymbol("City Combo Info");
								stack.push(cityCombo);
								checkifTourRequestExist();
							}
						} else {
							stack.push(conjunction);
							stack.push(city2);

						}
					} else {
						stack.push(city2);
					}
				} else {
					stack.push(city2);
				}

			}
		}

	}

	public void checkIfQuestionPartOneExist() {
		Determiner determiner2 = new Determiner();
		Verb verb = new Verb();
		Determiner determiner1 = new Determiner();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Determiner")) {
				determiner2 = (Determiner) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Verb")) {
						verb = (Verb) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Determiner")) {
								determiner1 = (Determiner) stack.pop();

								QuestionPartOne partOne = new QuestionPartOne();
								partOne.setDeterminer2(determiner2);
								partOne.setDeterminer(determiner1);
								partOne.setVerb(verb);
								partOne.setSymbol("Part One");
								stack.push(partOne);
							}
						} else {
							stack.push(verb);
							stack.push(determiner2);

						}
					} else {
						stack.push(determiner2);
					}
				} else {
					stack.push(determiner2);
				}

			}
		}
	}

	public void checkIfQuestionPartTwoExist() {
		Noun noun = new Noun();
		Determiner determiner = new Determiner();
		Preposition preposition = new Preposition();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Noun")) {
				noun = (Noun) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Determiner")) {
						determiner = (Determiner) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Preposition")) {
								preposition = (Preposition) stack.pop();

								QuestionPartTwo partTwo = new QuestionPartTwo();
								partTwo.setDeterminer(determiner);
								partTwo.setNoun(noun);
								partTwo.setPreposition(preposition);
								partTwo.setSymbol("Part Two");
								stack.push(partTwo);
							}
						} else {
							stack.push(determiner);
							stack.push(noun);

						}
					} else {
						stack.push(noun);
					}
				} else {
					stack.push(noun);
				}

			}
		}
	}

	public void combineCityNames() {
		CityName cityOne = new CityName();
		CityName cityTwo = new CityName();
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("City")) {
				cityOne = (CityName) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("City")) {
						cityTwo = (CityName) stack.pop();
						CityName cityName = new CityName();

						String cityNameCombination = cityTwo.getCityName_Value() + " " + cityOne.getCityName_Value();
						System.out.println("NEW CITY NAME : " + cityNameCombination);
						cityName.setSymbol("City");
						cityName.setCityName_Value(cityNameCombination);
						stack.push(cityName);

						// DescriptionInfo descriptionInfo = new DescriptionInfo();
						// descriptionInfo.setNoun(noun);
						// descriptionInfo.setVerb(verb);
						// descriptionInfo.setSymbol("Description Info");
						// stack.push(descriptionInfo);
					} else {
						stack.push(cityOne);
					}
				} else {
					stack.push(cityOne);
				}
			}
		}

	}

	public void checkIfDescriptionInfoExist() {
		Verb verb = new Verb();
		Noun noun = new Noun();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Verb")) {
				verb = (Verb) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Noun")) {
						noun = (Noun) stack.pop();
						DescriptionInfo descriptionInfo = new DescriptionInfo();
						descriptionInfo.setNoun(noun);
						descriptionInfo.setVerb(verb);
						descriptionInfo.setSymbol("Description Info");
						stack.push(descriptionInfo);
					} else {
						stack.push(verb);
					}
				} else {
					stack.push(verb);
				}
			}
		}
	}

	private boolean checkIfStackContainsAValidCityInfo() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("City Info")) {
				if (stack.size() == 1) {
					sentenceRecognized = (CityInfo) stack.peek();
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

	private boolean checkIfStackContainsAValidCityQuestion() {
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("City Question")) {
				if (stack.size() == 1) {
					sentenceQuestion = (CityQuestion) stack.peek();
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
						nom.setSymbol("Nominative Case");
						stack.push(nom);
					} else {
						stack.push(noun);
					}
				} else {

					// noun.setSymbol("Noun");
					stack.push(noun);
				}
			}
		}
	}

	public void checkifTourRequestExist() {
		CityComboInfo comboInfo = new CityComboInfo();
		BuildingPart build = new BuildingPart();
		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("City Combo Info")) {
				comboInfo = (CityComboInfo) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Building Part")) {
						build = (BuildingPart) stack.pop();
						TourRequest request = new TourRequest();
						request.setBuildingPart(build);
						request.setCityCOmboInfo(comboInfo);
						request.setSymbol("Tour Request");
						stack.push(request);
						// Nominative_Case nom = new Nominative_Case();
						// nom.setAdjective(adjective);
						// nom.setNoun(noun);
						// nom.setSymbol("Nominative Case");
						// stack.push(nom);
					} else {
						stack.push(build);
					}
				} else {

					// noun.setSymbol("Noun");
					stack.push(build);
				}
			}
		}
	}

	private boolean checkIfStackCanBeReduced(Symbol symbol) {
		if (checkIfStackReduceTo_Determiner() == true) {
			Determiner det = new Determiner();
			det.setSymbol("Determiner");
			det.setDeterminer_Value(symbol.getSymbol());
			stack.pop();
			stack.push(det);
			checkIfQuestionPartOneExist();
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
			checkifNomExist();
			checkIfQuestionPartTwoExist();
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
		}

		else if (checkIfStackReduceTo_Preposition() == true) {
			Preposition preposition = new Preposition();
			preposition.setSymbol("Preposition");
			preposition.setPrep_Value(symbol.getSymbol());
			stack.pop();
			stack.push(preposition);
			return true;
		} else if (checkIfStackReduceTo_Verb() == true) {
			Verb verb = new Verb();
			verb.setSymbol("Verb");
			verb.setVerb_Value(symbol.getSymbol());
			stack.pop();
			stack.push(verb);
			checkIfBuildingPart();
			return true;
		} else if (checkifStackCanReduceTo_Adjective() == true) {
			Adjective adjective = new Adjective();
			adjective.setSymbol("Adjective");
			adjective.setAdjectiveValue(symbol.getSymbol());
			stack.pop();
			stack.push(adjective);
			return true;
		} else if (checkifStackCanReduceT0_Build() == true) {
			Build build = new Build();
			build.setBuild_Value(symbol.getSymbol());
			build.setSymbol("Build Set");
			stack.pop();
			stack.push(build);
			return true;
		} else if (checkifStackCanReduceT0_Tour() == true) {
			Tour tour = new Tour();
			tour.setTour_value(symbol.getSymbol());
			tour.setSymbol("Tour Set");
			stack.pop();
			stack.push(tour);
			return true;
		}

		else {
			CityName cityName = new CityName();
			cityName.setSymbol("City");
			cityName.setCityName_Value(symbol.getSymbol());
			stack.pop();
			stack.push(cityName);
			combineCityNames();
			return true;
		}
	}

	public void checkIfBuildingPart() {
		Verb verb = new Verb();
		Tour tour = new Tour();
		Determiner determiner = new Determiner();
		Build build = new Build();

		if (!(stack.isEmpty())) {
			if (stack.peek().getSymbol().equals("Verb")) {
				verb = (Verb) stack.pop();
				if (!(stack.isEmpty())) {
					if (stack.peek().getSymbol().equals("Tour Set")) {
						tour = (Tour) stack.pop();
						if (!(stack.isEmpty())) {
							if (stack.peek().getSymbol().equals("Determiner")) {
								determiner = (Determiner) stack.pop();
								if (!(stack.isEmpty())) {
									if (stack.peek().getSymbol().equals("Build Set")) {
										build = (Build) stack.pop();
										BuildingPart buildingPart = new BuildingPart();
										buildingPart.setVerb(verb);
										buildingPart.setDet(determiner);
										buildingPart.setBuild(build);
										buildingPart.setTourset(tour);
										buildingPart.setSymbol("Building Part");
										stack.push(buildingPart);

									} else {
										stack.push(determiner);
										stack.push(tour);
										stack.push(verb);
									}
								} else {
									stack.push(determiner);
									stack.push(tour);
									stack.push(verb);
								}
							}
						} else {
							stack.push(tour);
							stack.push(verb);

						}
					} else {
						stack.push(verb);
					}
				} else {
					stack.push(verb);
				}

			}
		}

	}

	private boolean checkifStackCanReduceT0_Tour() {
		Tour tour = new Tour();
		return tour.isTour(stack.peek().getSymbol());
	}

	private boolean checkifStackCanReduceT0_Build() {
		Build build = new Build();
		return build.isBuild(stack.peek().getSymbol());
	}

	private boolean checkIfStackReduceTo_Preposition() {
		Preposition prep = new Preposition();
		return prep.isPrep(stack.peek().getSymbol());
	}

	public boolean checkifStackCanReduceTo_Adjective() {
		Adjective adjective = new Adjective();
		return adjective.isAdjective(stack.peek().getSymbol());
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

	public CityInfo getSentenceRecognized() {
		return sentenceRecognized;
	}

	public void setSentenceRecognized(CityInfo sentenceRecognized) {
		this.sentenceRecognized = sentenceRecognized;
	}

	public CityQuestion getSentenceQuestion() {
		return sentenceQuestion;
	}

	public void setSentenceQuestion(CityQuestion sentenceQuestion) {
		this.sentenceQuestion = sentenceQuestion;
	}

}
