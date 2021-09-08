package org.core.ds.graph.dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
	LinkedList<Integer>[] adj;
	int count;
	
	public DFSGraph(int count) {
		this.count = count;
		adj = new LinkedList[count];
		for(int i =0; i< count; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int src, int dest) {
		if(src < count && !adj[src].contains(dest)) {
			adj[src].add(dest);
		}
	}
	
	public void printEdge() {
		int i=0;
		for(LinkedList<Integer> list : adj) {
			System.out.print("The " + i++ + " has an edge towards: ");
			list.stream().forEach(n->System.out.print(n +" -> "));
			System.out.println();
		}
	}
	
	private void dfs(int n, boolean[] visited) {
		visited[n] = true;
		System.out.print(n+" ");
		Iterator<Integer> itr = adj[n].listIterator();
		while(itr.hasNext()) {
			int i = itr.next();
			if(!visited[i]) {
				dfs(i,visited);
			}
		}
		
	}
	
	public void dfsSearch(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean[] visited = new boolean[count]; 
  
        // Call the recursive helper function to print DFS traversal 
        dfs(v, visited); 
    } 
}
