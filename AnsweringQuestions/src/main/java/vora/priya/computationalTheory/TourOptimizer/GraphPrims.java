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

	Map<String, Integer> globalAllPathToDistance = new HashMap<String, Integer>();

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

	@SuppressWarnings("unchecked")
	public Integer findEdgeValue(String source, String dest) {
		T sourceValue = (T) source.trim();
		Map<T, Integer> set = this.getEdges(sourceValue);
		Integer distanceValue = set.get(sourceValue);

		Integer distance = 0;
		for (Entry<T, Integer> t : set.entrySet()) {
			String name = (String) t.getKey();
			if (dest.trim().equals(name.trim())) {
				distance = t.getValue();
				// System.out.println("Distance: " + distance);
			}
		}
		return distance;
	}

	public Integer findFullPathValue(String path) {
		// System.out.println("\nPath: " + path);
		path = path.replace("----->", " ");
		// System.out.println("\nReplaced Path: " + path);

		String[] eachCity = path.split(" ");
		int counter = 0;
		int totalDistance = 0;
		while (counter != eachCity.length - 1) {
			Integer distanceValue = findEdgeValue(eachCity[counter], eachCity[counter + 1]);
			totalDistance += distanceValue;
			counter++;
		}
		System.out.println("Total Distance: " + totalDistance);
		return totalDistance;
	}

	Stack<String> currentPath = new Stack<String>();
	List<String> visitedList = new ArrayList<String>();

	public List<String> findAllPaths(GraphPrims graphs, String currentVertex, String destinationVertex) {
		String foundPath = "";
		List<String> listOfAllPaths = new ArrayList<String>();
		visitedList = new ArrayList<String>();
		currentPath = new Stack<String>();

		findPaths(graphs, currentVertex.trim(), destinationVertex.trim(), foundPath, listOfAllPaths);

		for (String string : listOfAllPaths) {
			System.out.println("\nFound Path: " + string);
			Integer distance = findFullPathValue(string);

			globalAllPathToDistance.put(string, distance);
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

		if (currentVertex.trim().equals(destinationVertex.trim()) && currentPath.size() != 1) {

			// System.out.println(" CURRENT: " + currentVertex);
			foundPath += currentVertex;
			// System.out.println("Found Path " + foundPath);
			listOfAllPaths.add(foundPath);
			foundPath = "";

		} else {
			for (String adjNode : getAdjacentNodes(currentVertex)) {
				if (!(visitedList.contains(adjNode))) {

					// System.out.println("\n----------Current: " + currentVertex + "-------");
					if (!foundPath.contains(currentVertex)) {
						foundPath += currentVertex + "----->";
					}
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

	public Map<String, Integer> getGlobalAllPathToDistance() {
		return globalAllPathToDistance;
	}

	public void setGlobalAllPathToDistance(Map<String, Integer> globalAllPathToDistance) {
		this.globalAllPathToDistance = globalAllPathToDistance;
	}

	// public List<Vertex<T>> getAllVertex() {
	// // TODO Auto-generated method stub
	// return null;
	// }
}
