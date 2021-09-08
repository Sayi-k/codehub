package org.core.ds.graph.dfs;

public class GraphShow {

	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        g.printEdge();
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.dfsSearch(2); 
	}

}
