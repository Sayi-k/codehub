package org.core.base.algorithm.nodes;

public class DepthFirstSearchTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.right.left = new Node(7);
		tree.root.right.right.left = new Node(8);

		tree.postOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
	}

}

class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
	}
}

class BinaryTree {
	public Node root;

	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.key + " ");
	}

	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
}