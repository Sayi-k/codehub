package org.core.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	private static Node root;
	public static void main(String[] args) {
		BreadthFirstSearch tree = new BreadthFirstSearch();
		tree.insert(20);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(35);
		tree.insert(1);
		tree.printBFS(root);
	}
	private void printBFS(Node root) {
		if(null != root) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()) {
				Node n = q.poll();
				System.out.println(n.data);
				if(n.left != null) q.add(n.left) ;
				if(n.right != null) q.add(n.right);
			}
		}
	}
	private void insert(int data) {
		root = insert(root, data);
	}
	private Node insert(Node root, int data) {
		if(null == root) {
			return new Node(data);
		}
		else if(data < root.data) {
			root.left = insert(root.left, data);
		}else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		return root;
	}
}
