package org.core.ds.graph.adjacencylist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<Node, List<Node>> adjacencyMap;
	boolean directed;
	
	public Graph(boolean directed) {
		this.adjacencyMap = new HashMap<>();
		this.directed = directed;
	}
	
	public void addEdge(Node source, Node destination) {
		if(!adjacencyMap.containsKey(source)) {
			adjacencyMap.put(source, null);
		}
		if(!adjacencyMap.containsKey(destination)) {
			adjacencyMap.put(destination, null);
		}
		addEdgeHelper(source, destination);
		if(!directed) {
			addEdgeHelper(destination, source);
		}
	}

	private void addEdgeHelper(Node source, Node destination) {
		List<Node> adjancyList = adjacencyMap.get(source);
		if(null == adjancyList) {
			adjancyList = new LinkedList<>();
		}
		if(!adjancyList.contains(destination)) {
			adjancyList.add(destination);
		}
		adjacencyMap.put(source, adjancyList);
	}
	
	public void printEdges() {
	    for (Node node : adjacencyMap.keySet()) {
	        System.out.print("The " + node.name + " has an edge towards: ");
	        if(null != adjacencyMap.get(node)) {
	        	for (Node neighbor : adjacencyMap.get(node)) {
		            System.out.print(neighbor.name + " ");
		        }
	        }
	        System.out.println();
	    }
	}
	
	public boolean hasEdge(Node source, Node destination) {
	    return null != adjacencyMap.get(source) && adjacencyMap.get(source).contains(destination);
	}
}
