package vora.priya.computationalTheory.TourOptimizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Prims<T> {
	GraphPrims<T> graphPrims = new GraphPrims<T>();
	private ArrayList<T> shortest_Path = new ArrayList<T>();
	Set<T> individualVertices = new HashSet<T>();
	ArrayList<List<EdgePrims<T>>> mstCollection = new ArrayList<List<EdgePrims<T>>>();
	Map<Integer, Integer> cableMap = new HashMap<Integer, Integer>();
	public Integer totalCableLength = 0;

	public static Comparator<EdgePrims> edgePrioritySetter = new Comparator<EdgePrims>() { // online solution to set
																							// priority
		public int compare(EdgePrims edge1, EdgePrims edge2) {
			return edge1.getDistance() - edge2.getDistance();
		}
	};

	public GraphPrims<T> getGraphPrims() {
		return graphPrims;
	}

	public void setGraphPrims(GraphPrims<T> graphPrims) {
		this.graphPrims = graphPrims;
	}

	public List<EdgePrims<T>> getMinSpanTree(GraphPrims<T> graph) {
		EdgePrims<T> previousValidMinEdge = null;
		Queue<EdgePrims<T>> edgesAvailable = new PriorityQueue<EdgePrims<T>>(10, edgePrioritySetter);
		List<EdgePrims<T>> listMinEdges = new ArrayList<EdgePrims<T>>();
		Set<T> unvisitedVertices = new HashSet<T>();
		unvisitedVertices.addAll(graph.getVertices());

		T sourceVertex = unvisitedVertices.iterator().next();
		unvisitedVertices.remove(sourceVertex);
		int theCount = 0;

		while (!unvisitedVertices.isEmpty()) {
			int edgeCount = 0;
			for (Entry<T, Integer> e : graph.getEdges(sourceVertex).entrySet()) {
				edgeCount++;
				/* dont add a duplicate edge */
				if (unvisitedVertices.contains(e.getKey())) {
					Integer value = e.getValue();
					T key = e.getKey();
					edgesAvailable.add(new EdgePrims<T>(sourceVertex, key, value));
				}
			}

			// System.out.println("Number of Edges: " + edgeCount);
			// if (edgeCount == 1) {
			// System.out.println("EDGE IS ONE!");
			// System.out.println(sourceVertex);
			// } else {
			// // add to not lead list
			// }
			/* fetch the edge with least distance */
			EdgePrims<T> minEdge = edgesAvailable.poll();
			if (minEdge != null) {
				previousValidMinEdge = minEdge;
				while (!unvisitedVertices.contains(minEdge.getTarget())) {
					minEdge = edgesAvailable.poll();
				}

				listMinEdges.add(minEdge);

				sourceVertex = minEdge.getTarget();
			} else if (minEdge == null) {
				sourceVertex = previousValidMinEdge.getTarget();
			}

			if (unvisitedVertices.contains(sourceVertex)) {
				unvisitedVertices.remove(sourceVertex);
				// System.out.println(" Source removed: " + sourceVertex);
			} else {
				if (theCount == 0) {
					edgeCount = 0;
					// System.out.println("New MST: \n");
					Integer c = 0;
					// this.print(listMinEdges);
					mstCollection.add(listMinEdges);
					listMinEdges = new ArrayList<EdgePrims<T>>();
					theCount++;
				}
				sourceVertex = unvisitedVertices.iterator().next();
				unvisitedVertices.remove(sourceVertex);
				// System.out.println(" Source removed: " + sourceVertex);
			}
		}

		mstCollection.add(listMinEdges);
		return listMinEdges;
	}

	private void getData() throws IOException {
		int lineCount = 0;
		String pathToFile = "City.txt";
		File file = new File(pathToFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;

		while ((st = br.readLine()) != null) {
			if (!(st.contains("//"))) {
				st = st.trim();
				if (lineCount != 0) {
					String[] splitSt = st.split(",");
					String startVertex = splitSt[0];
					for (int i = 1; i < splitSt.length; i++) {
						String[] splitWeight = splitSt[i].split(":");
						T startV = (T) startVertex;
						T v2 = (T) splitWeight[0];

						graphPrims.addEdge(startV, v2, Integer.parseInt(splitWeight[1]));

					}
				}
				lineCount++;
			}
		}
		this.runMinSpanTree(graphPrims);

		br.close();
	}

	public void runMinSpanTree(GraphPrims<T> graphPrims) {
		getMinSpanTree(graphPrims);
		cableLengthCalculator();
		int mstCount = 1;
		for (List<EdgePrims<T>> eachMST : mstCollection) {
			print(eachMST, mstCount, 12);
			mstCount++;
			System.out.println(" ");
		}
	}

	public void cableLengthCalculator() {
		int mstCount = 1;
		for (List<EdgePrims<T>> eachMST : mstCollection) {
			int cableLength = 0;
			for (EdgePrims<T> edgePrims : eachMST) {
				cableLength += edgePrims.getDistance();
			}
			cableMap.put(mstCount, cableLength);
			totalCableLength += cableLength;
			mstCount++;
			System.out.println(" ");
		}
	}

	public List<String> findCityNames() {
		individualVertices = new HashSet<T>();
		List<String> listOfCities = new ArrayList<String>();

		for (List<EdgePrims<T>> eachMST : mstCollection) {
			for (EdgePrims<T> eachEdge : eachMST) {
				if (!individualVertices.contains(eachEdge.getSource())) {
					individualVertices.add(eachEdge.getSource());
				}
				if (!individualVertices.contains(eachEdge.getTarget())) {
					individualVertices.add(eachEdge.getTarget());
				}
			}

			// System.out.println("####################################");
			for (T eachVertice : individualVertices) {
				// System.out.print(eachVertice + " ");
				String each = eachVertice + " ";
				listOfCities.add(each);
			}

		}
		return listOfCities;

	}

	public void operateFindPaths(Prims prims) {

		List<String> allCities = findCityNames();
		System.out.println("*****************************");
		for (String eachCity : allCities) {
			List<String> otherCities = findOtherCityNames(eachCity);
			System.out.println(" ");
			for (String eachOtherCity : otherCities) {
				prims.getGraphPrims().findAllPaths(prims.getGraphPrims(), eachCity.trim(), eachOtherCity.trim());
			}
			System.out.println("-------------------------------------------------");

		}
	}

	public List<String> findOtherCityNames(String currentCity) {
		List<String> cityNames = findCityNames();
		List<String> otherCityNames = new ArrayList<String>();

		System.out.println(" ");
		System.out.print(currentCity + ": ");
		for (String each_city : cityNames) {
			if (!(each_city.trim().equals(currentCity.trim()))) {
				System.out.print(each_city + " ");
				otherCityNames.add(each_city);
			}
		}
		return otherCityNames;
	}

	public void print(List<EdgePrims<T>> mstList, int count, int cableLength) {
		System.out.println("\nMST " + count);
		System.out.print("\nCities on Tour: ");
		individualVertices = new HashSet<T>();

		for (EdgePrims<T> eachEdge : mstList) {
			if (!individualVertices.contains(eachEdge.getSource())) {
				individualVertices.add(eachEdge.getSource());
			}
			if (!individualVertices.contains(eachEdge.getTarget())) {
				individualVertices.add(eachEdge.getTarget());
			}
		}

		for (T eachVertice : individualVertices) {
			System.out.print(eachVertice + " ");
		}
		System.out.println("\nCable Needed :" + cableMap.get(count) + " feet");
		System.out.println(" ");
		// for (EdgePrims<T> edgePrims : mstList) {
		// System.out.println(edgePrims.toString());
		// }

		System.out.println("\n Total Cable Required: " + totalCableLength + " ft");
	}

	private static String promptUserFileath() {
		boolean endLoop = false;
		String path = null;
		while (endLoop == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a valid path to a file: \n");
			String line;
			try {
				line = br.readLine().trim();
				path = line;
				File file = new File(path);
				if (!file.isDirectory()) {
					if (file.exists()) {
						endLoop = true;
					}
				} else {
					endLoop = false;
				}
			} catch (IOException e) {

				endLoop = false;
				e.printStackTrace();
			}
		}
		return path;
	}

	@SuppressWarnings("unchecked")
	public Integer findEdgeValue(Prims prims, String source, String dest) {

		System.out.println("\n\n");
		T sourceValue = (T) source.trim();
		Map<T, Integer> set = prims.getGraphPrims().getEdges(sourceValue);
		Integer distanceValue = set.get(sourceValue);
		
		for (Entry<T, Integer> t : set.entrySet()) {
			String name = (String) t.getKey();
			if(dest.trim().equals(name.trim())) { 				
				Integer distance = t.getValue();
				System.out.println("Distance: " + distance);
			}
		}
		return distanceValue;
	}

	public static void main(String[] args) throws IOException {
		GraphPrims<Character> graphPrims = new GraphPrims<Character>();
		Prims<Character> prims = new Prims<Character>();
		prims.start();

		System.out.println("///////////////////////////////////////////////////////");
		// prims.findCityNames();
		System.out.println("\n\n");
		// prims.findOtherCityNames("Shanghai");
		prims.operateFindPaths(prims);
		System.out.println("\n\n");
		prims.getGraphPrims().findAllPaths(prims.getGraphPrims(), "Shanghai", "Berlin");
		System.out.println("///////////////////////////////////////////////////////");
		prims.findEdgeValue(prims, "London", "Paris");
	}

	void start() throws IOException {
		this.getData();
	}
}
