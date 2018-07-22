package voar.priya.computationalTheory.tape;

public class Tape {
	private char[] tapeArray;
	private int head = 226;
	String equation;

	public Tape(String equation) {
		createTape(equation);
		this.equation = equation;
	}

	private void createTape(String equation) {
		tapeArray = new char[450 + equation.length()];
		tapeArray[head] = '=';
		char[] equationArray = equation.toCharArray();

		int counter = 0;
		for (int i = 0; i < tapeArray.length; i++) {
			if (i < head) {
				tapeArray[i] = 'E';
			} else if (i > head && i <= (head + equation.length())) {
				tapeArray[i] = equationArray[counter];
				counter++;
			} else if (i != 226) {
				tapeArray[i] = 'E';
			}
		}

	}

	public String getAnswer() {
		int head = 226;

		char current = this.tapeArray[head];
		String answer = "";
		int counter = 0;
		while (current != 'E') {
			head--;
			current = this.tapeArray[head];
			answer += current;
		}
		answer = answer.replace("E", "");
		String updateAnswer = "";
		for (int i = answer.length() - 1; i >= 0; i--) {
			updateAnswer += answer.charAt(i);
		}
		return updateAnswer;
	}

	public void tapeOverWrite(String direction, char write) {
		if (direction.equals("Right")) {
			shiftRight();
		} else if (direction.equals("Left")) {
			shiftLeft();
		}

		tapeArray[head] = write;
	}

	public void printTape() {
		for (int i = 110; i < (head + equation.length() + ((equation.length()))); i++) {
			System.out.print(tapeArray[i]);
		}
	}

	public void shiftLeft() {
		head--;
	}

	public void shiftRight() {
		head++;
	}

	public char[] getTapeArray() {
		return tapeArray;
	}

	public void setTapeArray(char[] tapeArray) {
		this.tapeArray = tapeArray;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

}
