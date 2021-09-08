package org.core.ds.graph.bfs;

import java.util.LinkedList;
import java.util.ListIterator;

public class BFSGraph {
	LinkedList<Integer>[] adj;
	int count;
	
	public BFSGraph(int count) {
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
	
	public void bfsSearch(int node) {
		boolean[] visited = new boolean[count];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		int n = 0;
		System.out.println("BFS result...!!!");
		while(queue.size() != 0) {
			n = queue.pop();
			System.out.print(n+" - ");
			ListIterator<Integer> itr = adj[n].listIterator();
			while(itr.hasNext()) {
				n = itr.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
}
