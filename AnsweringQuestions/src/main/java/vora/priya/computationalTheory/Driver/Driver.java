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
					if(parseTree != null) { 
						boolean valid_response = parseTree.isCityInfo(userInput);
						// System.out.println("VALID: " + valid_response);
						String inputType = driver.reconginzeInputType(parseTree);
						
						if(inputType != null) { 
							if (inputType.equals("Info")) {
								// add to the network
								// System.out.println("Type: Info");
								System.out.println("> Ok.");
								addToGraph(
										parseTree.getSentenceRecognized().getCityComboInfo().getCityOne().getCityName_Value(),
										parseTree.getSentenceRecognized().getCityComboInfo().getCityTwo().getCityName_Value(),
										Integer.parseInt(parseTree.getSentenceRecognized().getDistanceInfo().getDistanceNumber()
												.getDistanceValue()));
								if (prims.getGraphPrims() == null) {
									// System.out.println("Graph is still null");
								}
							} else if (inputType.equals("Question")) {
								// get the shortest path
								// System.out.println("Type: Question");
							} else if (inputType.equals("Request")) {
								// System.out.println("Type: Request");
								String requestInput = userInput.trim();
								requestInput = parseBuildRequest(requestInput);
								if(requestInput != null) { 									
									getShortestPath(requestInput);
								} else { 
									System.out.println(">Sorry, I don't udnerstand");
								}
							} else {

							}
						} else { 
							System.out.println(">Sorry did not understand what you said.");
						}
					} else { 
						System.out.println(">Wait what?");
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
		prims.operateFindPaths(tempCities);
		String path = prims.getShortestPath();
		Integer distance = prims.getShortestPathDistance();
		System.out.println(" >Shortest Path: " + path);
		System.out.println(" >Total Distance: " + distance);
		getPathForEach(path);
	}

	public static void getPathForEach(String path) {
		path = path.trim();
		String[] diffCities = path.split(" ");
		int counter = 0;
		int size = diffCities.length;
		System.out.println(" ");
		while (counter != size - 1) {
			String currentCity = diffCities[counter];
			String nextCity = diffCities[counter + 1];

			System.out.print(currentCity + " ");
			System.out.print(nextCity + " ");
			prims.getGraphPrims().getSpecficAdjacentNodes(currentCity, nextCity);
			counter++;
		}
	}

	public static String parseBuildRequest(String requestInput) {
		// System.out.println("Original: " + requestInput);
		requestInput = requestInput.replace("Build", "");
		requestInput = requestInput.replace("a ", "");
		requestInput = requestInput.replace("tour", "");
		requestInput = requestInput.replace("connecting", "");
		requestInput = requestInput.replace("and", "");
		requestInput = requestInput.trim();
		requestInput = requestInput.replace("  ", " ");
		// System.out.println("Original Modified: " + requestInput);
		System.out.println("The shortest tour connecting " + requestInput + " is: ");
		String[] cityList = requestInput.split(",");

		int counter = 0;
		String cityWanted = "";
		for (String string : cityList) {
			// System.out.println(string.trim());
			cityWanted += string.trim() + " ";
		}

		return cityWanted;
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
