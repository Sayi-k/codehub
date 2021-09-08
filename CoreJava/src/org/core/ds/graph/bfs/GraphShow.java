package org.core.ds.graph.bfs;

public class GraphShow {

	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.printEdge();
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.bfsSearch(2); 
	}

}
