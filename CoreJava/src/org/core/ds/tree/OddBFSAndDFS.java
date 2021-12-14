package org.core.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class OddBFSAndDFS {

	private static Node root = null;
	
	public static void main(String[] args) {
		OddBFSAndDFS tree = new OddBFSAndDFS();
		tree.insert(10);
		tree.insert(15);
		tree.insert(20);
		tree.insert(8);
		tree.insert(5);
		tree.insert(6);
		tree.insert(18);
		tree.insert(1);
		tree.insert(21);
		tree.insert(2);
		System.out.println("Odd level BFS");
		tree.oddLevelBfs();
		System.out.println();
		System.out.println("Odd level DFS inorder");
		tree.oddLevelInOrder();
	}
	
	/**
	 * Prints odd level data in DFS inorder
	 * 
	 */
	public void oddLevelInOrder() {
		inorder(root, true);
	}
	
	
	private void inorder(Node node, boolean isOdd) {
		if(node == null) {
			return;
		}
		if(isOdd) {
			System.out.print(node.data+" -> ");
		}
		inorder(node.left, !isOdd);
		inorder(node.right, !isOdd);
	}

	/**
	 * Prints odd level data in BFS
	 * 
	 */
	public void oddLevelBfs() {
		if (root != null) {
			Queue<Node> que = new LinkedList<Node>();
			que.add(root);
			boolean isOdd = true;
			Node node;
			while (true) {
				int count = que.size();
				if (count == 0) {
					break;
				}
				while (count != 0) {
					node = que.poll();
					if(isOdd) {
						System.out.print(node.data+" -> ");
					}
					if(node.left != null) que.add(node.left);
					if(node.right != null) que.add(node.right);
					count--;
				}
				isOdd = !isOdd;
			}
		}
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if(node == null) {
			return new Node(data);
		}
		else if(data <= node.data) {
			node.left = insert(node.left, data);
		}
		else if(data > node.data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
}
