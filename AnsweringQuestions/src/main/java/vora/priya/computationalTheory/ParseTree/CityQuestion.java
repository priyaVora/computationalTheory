package vora.priya.computationalTheory.ParseTree;

public class CityQuestion extends Symbol {
	private QuestionPartOne questionOne;
	private QuestionPartTwo questionTwo;
	private Nominative_Case nominative;

	public CityQuestion() {

	}

	public QuestionPartOne getQuestionOne() {
		return questionOne;
	}

	public void setQuestionOne(QuestionPartOne questionOne) {
		this.questionOne = questionOne;
	}

	public QuestionPartTwo getQuestionTwo() {
		return questionTwo;
	}

	public void setQuestionTwo(QuestionPartTwo questionTwo) {
		this.questionTwo = questionTwo;
	}

	public Nominative_Case getNominative() {
		return nominative;
	}

	public void setNominative(Nominative_Case nominative) {
		this.nominative = nominative;
	}

	@Override
	public String toString() {
		return "CityQuestion [questionOne=" + questionOne + ", questionTwo=" + questionTwo + ", nominative="
				+ nominative + "]";
	}

}
