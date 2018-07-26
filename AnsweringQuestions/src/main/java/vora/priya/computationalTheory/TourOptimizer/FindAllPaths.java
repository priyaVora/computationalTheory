package vora.priya.computationalTheory.TourOptimizer;

import java.io.IOException;

public class FindAllPaths {

	public FindAllPaths() {

	}
	
	public static void main(String[] args) throws IOException {
		GraphPrims<Character> graphPrims = new GraphPrims<Character>();
		Prims<Character> prims = new Prims<Character>();
		prims.start();

	}
	

	
//	
//	 private void findPaths(GraphPrims graph, int currentVertex, int destinationVertex) {
//		    currentPath.push(currentVertex); // Push current vertex on the stack
//		    visited[currentVertex] = true;
//		     
//		    if (currentVertex == destinationVertex) {
//		      visited[currentVertex] = false;
//		    }
//		 
//		    if (currentVertex == destinationVertex && currentPath.size() != 1) {
//		      printPath();
//		    } else {
//		      // For each linked list of vertices adjacent to current vertex
//		      for (int i : graph.adjacentVertices(currentVertex)) { 
//		        if (!visited[i])
//		          findPaths(graph, i, destinationVertex);
//		        }
//		      }
//		      
//		    currentPath.pop(); // Pop the stack
//		    visited[currentVertex] = false;
//		  }
	
}
