package vora.priya.computationalTheory.TourOptimizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class GraphPrims<T> implements Iterable<T> {

	private final Map<T, Map<T, Integer>> graph;

	public GraphPrims() {
		graph = new HashMap<T, Map<T, Integer>>();
	}

	public void addEdge(T vertex1, T vertex2, int distance) {
		if (vertex1 == null || vertex2 == null) {
			throw new NullPointerException();
		}

		if (!graph.containsKey(vertex1)) {
			graph.put(vertex1, new HashMap<T, Integer>());
		}
		if (!graph.containsKey(vertex2)) {
			graph.put(vertex2, new HashMap<T, Integer>());
		}
		graph.get(vertex1).put(vertex2, distance);
		graph.get(vertex2).put(vertex1, distance);
	}

	public Set<T> getVertices() {
		return Collections.unmodifiableSet(graph.keySet());
	}

	public Map<T, Integer> getEdges(T source) {
		if (source == null) {
			throw new NullPointerException();
		}
		return Collections.unmodifiableMap(graph.get(source));
	}

	public void removeEdges(T vertex1, T vertex2) {
		if (vertex1 == null || vertex2 == null) {
			throw new NullPointerException();
		} else if (!graph.containsKey(vertex1) || !graph.containsKey(vertex2)) {

		} else {

			graph.get(vertex1).remove(vertex2);
			graph.get(vertex2).remove(vertex1);
		}
	}

	public Iterator<T> iterator() {
		return graph.keySet().iterator();
	}

	public boolean containsNode(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	Stack<String> currentPath = new Stack<String>();
	List<String> visitedList = new ArrayList<String>();

	public List<String> findAllPaths(GraphPrims graphs, String currentVertex, String destinationVertex) {
		String foundPath = "";
		List<String> listOfAllPaths = new ArrayList<String>();
		findPaths(graphs, currentVertex, destinationVertex, foundPath, listOfAllPaths);

		for (String string : listOfAllPaths) {
			System.out.println("Found Path: " + string);
		}
		return listOfAllPaths;
	}

	public List<String> findPaths(GraphPrims graphs, String currentVertex, String destinationVertex, String foundPath,
			List<String> listOfAllPaths) {
		currentPath.push(currentVertex);
		visitedList.add(currentVertex);

		if (currentVertex.equals(destinationVertex)) {
			visitedList.remove(currentVertex);
		}

		if (currentVertex.equals(destinationVertex) && currentPath.size() != 1) {

			// System.out.println(" CURRENT: " + currentVertex);
			foundPath += currentVertex;
			// System.out.println("Found Path " + foundPath);
			listOfAllPaths.add(foundPath);
			foundPath = "";

		} else {
			for (String adjNode : getAdjacentNodes(currentVertex)) {
				if (!(visitedList.contains(adjNode))) {

					// System.out.println("\n----------Current: " + currentVertex + "-------");
					foundPath += currentVertex + "----->";
					findPaths(graphs, adjNode, destinationVertex, foundPath, listOfAllPaths);
				}
			}
		}
		return listOfAllPaths;
	}

	public ArrayList<String> getAdjacentNodes(String node) {
		ArrayList<String> neighboursList = new ArrayList<String>();
		Set<String> keys = (Set<String>) graph.keySet();
		for (String key : keys) {
			if (key.equals(node)) {

				Map<T, Integer> mapOfConnections = graph.get(key);

				int counter = 0;
				for (Entry<T, Integer> entry : mapOfConnections.entrySet()) {
					String keyOfCity = (String) entry.getKey();
					Integer value = entry.getValue();
					neighboursList.add(counter, keyOfCity);
				}

				// neighboursList = (ArrayList<String>) graph.get(key);
				return new ArrayList<String>(neighboursList);
			}
		}
		return new ArrayList<String>();
	}

	// public List<Vertex<T>> getAllVertex() {
	// // TODO Auto-generated method stub
	// return null;
	// }
}
