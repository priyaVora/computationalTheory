package vora.priya.computationalTheory.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.ProgressMonitor;

import vora.priya.computationalTheory.ParseTree.ParseTree;
import vora.priya.computationalTheory.StateMachine.State_Machine;
import vora.priya.computationalTheory.Tokenizer.Tokenizer;
import vora.priya.computationalTheory.TourOptimizer.GraphPrims;
import vora.priya.computationalTheory.TourOptimizer.Prims;

public class Driver {
	GraphPrims<Character> graphPrims = new GraphPrims<Character>();
	static Prims<String> prims = new Prims<String>();

	public static void main(String[] args) {
		System.out.println("\n> Hi I'm tour-guide Eliza. Please enter your map.");
		Driver driver = new Driver();
		boolean run = true;

		loop: while (run) {
			ParseTree parseTree = new ParseTree();
			try {
				String userInput = driver.readInput().trim();
				if (userInput.equals("0")) {
					break loop;
				} else {
					boolean valid_response = parseTree.isCityInfo(userInput);
					// System.out.println("VALID: " + valid_response);
					String inputType = driver.reconginzeInputType(parseTree);
					if (inputType.equals("Info")) {
						// add to the network
						// System.out.println("Type: Info");
						System.out.println("> Ok.");
						addToGraph(parseTree.getSentenceRecognized().getCityComboInfo().getCityOne().getCityName_Value(),
								parseTree.getSentenceRecognized().getCityComboInfo().getCityTwo().getCityName_Value(),
								Integer.parseInt(parseTree.getSentenceRecognized().getDistanceInfo().getDistanceNumber()
										.getDistanceValue()));
					} else if (inputType.equals("Question")) {
						// get the shortest path
						System.out.println("Type: Question");
					} else if (inputType.equals("Request")) {
						System.out.println("Type: Request");
						
						getShortestPath("Shanghai Moscow Berlin Paris");
					} else {

					}
					// parseTree.printStack();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void addToGraph(String source, String destination, int distance) throws IOException {
		prims.addEdgeToGraph(source, destination, distance);
		prims.addEdgeToGraph(destination, source, distance);
		// String tempCities = "Shanghai Moscow Berlin Paris";
		// prims.operateFindPaths(prims, tempCities);

	}

	public static void getShortestPath(String tempCities) {
		prims.operateFindPaths(prims, tempCities);
		String path = prims.getShortestPath();
		Integer distance = prims.getShortestPathDistance();
		System.out.println("Shorest Path: " + path);
		System.out.println("Shortest Distance: " + distance);
	}

	public String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> ");

		String readline = reader.readLine();
		return readline;
	}

	public String reconginzeInputType(ParseTree parseTree) {

		if (parseTree.getSentenceQuestion() != null && parseTree.getSentenceRecognized() == null) {
			return "Question";
		} else if (parseTree.getSentenceRecognized() != null && parseTree.getSentenceQuestion() == null) {
			return "Info";
		} else if (parseTree.getTourRequest() != null) {
			return "Request";
		}

		else {
			return null;
		}
	}

}
