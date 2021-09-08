package org.core.ds.graph.adjacencymatrix;

public class GraphShow {

	public static void main(String[] args) {
		Graph graph = new Graph(5, false, true);

        graph.addEdge(0, 2, 19);
        graph.addEdge(0, 3, -2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 22); // The default weight is 0 if weighted == true
        graph.addEdge(1, 4, 34);
        graph.addEdge(2, 3, 21);
        graph.addEdge(3, 4, 12);

        graph.printMatrix();

        System.out.println();
        System.out.println();

        graph.printEdges();

        System.out.println();
        System.out.println("Does an edge from 1 to 0 exist?");
        if (graph.hasEdge(0,1)) {
            System.out.println("Yes");
        }
        else System.out.println("No");
	}

}
