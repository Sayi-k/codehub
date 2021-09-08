package org.core.ds.graph.adjacencymatrix;

public class Graph {
	int numberOfNodes;
	float[][] adjencyMatrix;
	boolean weighted;
	boolean directed;
	
	public Graph(int numberOfNodes, boolean directed, boolean weighted) {
		this.numberOfNodes = numberOfNodes;
		adjencyMatrix = new float[numberOfNodes][numberOfNodes];
		this.directed = directed;
		this.weighted = weighted;
	}
	
	public void addEdge(int source, int destination, float weight) {
		float value = 1;
		if(weighted) {
			value = weight;
		}
		adjencyMatrix[source][destination] = value;
		if(!directed) {
			adjencyMatrix[destination][source] = value;
		}
	}
	
	public boolean hasEdge(int source, int destination) {
		return (adjencyMatrix[source][destination] != 0.0);
	}
	
	public Float getEdgeValue(int source, int destination) {
	    if (!weighted || adjencyMatrix[source][destination] == 0.0)
	        return null;
	    return adjencyMatrix[source][destination];
	}
	
	public void printMatrix() {
	    for (int i = 0; i < numberOfNodes; i++) {
	        for (int j = 0; j < numberOfNodes; j++) {
	            // We only want to print the values of those positions that have been marked as set
	                System.out.format("%8s", String.valueOf(adjencyMatrix[i][j]));
	        }
	        System.out.println();
	    }
	}
	
	public void printEdges() {
		for(int i =0; i<numberOfNodes; i++) {
			System.out.print("Node " + i + " is connected to: ");
			for(int j=0; j<numberOfNodes; j++) {
				if(adjencyMatrix[i][j] != 0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
}
