package vora.priya.computationalTheory.Tokenizer;

import java.util.ArrayList;

import vora.priya.computationalTheory.StateMachine.State_Machine;

public class Tokenizer {
	ArrayList<String> tokenizerList = new ArrayList<String>();

	State_Machine machine = new State_Machine();

	public Tokenizer() {

	}

	// This tokenizer should be able to utilize the state machines and add the word
	// passed in to the tokenizer list if the state machine proofs the word valid
	
	public boolean tokenize(String word) { 
		word = word.trim();
		boolean input_Exist = machine.is_Word(word);
		 //System.out.println("  Is Word: " + input_Exist);
		 	
		 int counter = 0;
		 if(machine.getCurrentRecognizedWord() != null) { 
			char[] val = machine.getCurrentRecognizedWord().toCharArray();
			String recognizedWord = "";
			
			
			loop:for (int i = 0; i < val.length; i++) {
				if((val[i] + "").trim().length() > 0) { 
					if(machine.is_Word(val[i]+ "") == true) { 
						recognizedWord += val[i];						
					}
					if((i+1) == val.length) { 
						//System.out.println("Token: "+ recognizedWord);
						tokenizerList.add(counter, recognizedWord);
						counter++;
					}
				} else if(!((val[i] + "").trim().length() > 0)) { 
					if(recognizedWord != null || recognizedWord.equals("")) { 
						if(recognizedWord.trim().length() > 0) { 							
							//System.out.println("Token: "+ recognizedWord);
							tokenizerList.add(counter, recognizedWord);
							counter++;
						}
						recognizedWord = "";
					}
					
				}
			}
		 }
		return input_Exist;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	public ArrayList<String> getTokenizerList() {
		return tokenizerList;
	}

	public void setTokenizerList(ArrayList<String> tokenizerList) {
		this.tokenizerList = tokenizerList;
	}

	public State_Machine getMachine() {
		return machine;
	}

	public void setMachine(State_Machine machine) {
		this.machine = machine;
	}
}
