package voar.priya.computationalTheory.tape;

public class Tape {
	private char[] tapeArray;
	private int head = 226;

	public Tape(String equation) {
		createTape(equation);
		System.out.println("Print: ");
		printTape();
	}

	public static void main(String[] args) {
		Tape tape = new Tape("126+19");

	}

	private void createTape(String equation) {
		System.out.println("Start");
		tapeArray = new char[450 + equation.length()];
		tapeArray[head] = '=';
		char[] equationArray = equation.toCharArray();

		int counter = 0;
		for (int i = 0; i < tapeArray.length; i++) {
			if (i < head) {
				tapeArray[i] = 'E';
			} else if (i > head && i <= 232) {
				tapeArray[i] = equationArray[counter];
				counter++;
			} else if(i != 226) { 
				tapeArray[i] = 'E';
			}
		}

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
		for (int i = 0; i < tapeArray.length; i++) {
			System.out.print(tapeArray[i]);
		}
	}

	private void shiftLeft() {
		head--;
	}

	private void shiftRight() {
		head++;
	}
}
