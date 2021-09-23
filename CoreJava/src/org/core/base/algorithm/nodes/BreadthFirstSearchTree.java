package org.core.base.algorithm.nodes;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTree {

	public static void main(String[] args) {
		Binary_Tree tree = new Binary_Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.right.left = new Node(7);
		tree.root.right.right.left = new Node(8);

		tree.levelSearch(tree.root);
	}

}

class Binary_Tree {
	Node root;

	public void levelSearch(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.key + " ");
			if (null != node.left) {
				queue.add(node.left);
			}
			if (null != node.right) {
				queue.add(node.right);
			}
		}
	}
}
