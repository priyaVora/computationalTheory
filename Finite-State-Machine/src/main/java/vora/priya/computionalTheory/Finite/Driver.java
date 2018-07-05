package vora.priya.computionalTheory.Finite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Driver {


	public static void main(String[] args) throws IOException {
		System.out.println("Chat Service has Started...");
	
		State_Machine machine = new State_Machine();
		Driver driver = new Driver();
		boolean run = true;
		while(run) { 			
			driver.chat(machine);
		}
	}
	
	
	public String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("USER: ");

		String readline = " " + reader.readLine() + " ";
		return readline;
	}
	public void chat(State_Machine machine) throws IOException { 
	System.out.println("CHATBOT: " + chatBot_Message(machine, readInput()));
	} 
	public String chatBot_Message(State_Machine machine, String testString) {
		String[] greeting_Response = {"Hello there","Hi there, today is such a beautiful day!", "Finally someone is here to talk! Hi! "};
		String[] non_greeting_Response = {"A hi would be nice...","Wow...No greetings these days..."};
		Random rand = new Random();
		
		boolean hi_Exist = machine.state_machineHelper(testString);
		if(hi_Exist == true) { 			
			int random =rand.nextInt(greeting_Response.length);
			return greeting_Response[random];
		} else { 
			int random =rand.nextInt(non_greeting_Response.length);
			return non_greeting_Response[random];
		}
	}

	
}
