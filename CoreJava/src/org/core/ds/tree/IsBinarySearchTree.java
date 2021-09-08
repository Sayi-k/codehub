package org.core.ds.tree;

public class IsBinarySearchTree {
	private static Node root;
	public static void main(String[] args) {
		IsBinarySearchTree tree = new IsBinarySearchTree();
		tree.insert(20);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(35);
		tree.insert(1);
		System.out.println("Is BST = "+isBST());
		Node n = new Node(20);
		n.left = new Node(10);
		n.right = new Node(30);
		n.right.right = new Node(5);
		root = n;
		System.out.println("Is BST = "+isBST());
	}

	private static boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(Node root, int min, int max) {
		if(null == root) {
			return true;
		}
		if(root.data < min || root.data > max) {
			return false;
		}
		return (isBST(root.left, min, root.data) && isBST(root.right, root.data, max));
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
