package org.core.ds.tree;

public class MinAndMaxBST {
	private Node root;
	public static void main(String[] args) {
		MinAndMaxBST tree = new MinAndMaxBST();
		tree.insert(40);
		tree.insert(20);
		tree.insert(30);
		tree.insert(50);
		tree.insert(10);
		tree.insert(65);
		tree.insert(45);
		tree.insert(5);
		tree.printInorder();
		System.out.println("Min in tree is: "+tree.findMin());
		System.out.println("Max in tree is: "+tree.findMax());
	}
	
	private int findMax() {
		return findMax(root);
	}

	private int findMin() {
		return findMin(root);
	}

	private void printInorder() {
		printInorder(root);
	}

	public MinAndMaxBST() {
		root = null;
	}
	
	private int findMin(Node root) {
		if(null == root) {
			System.out.println("Tree is empty...");
			return 0;
		}else if(null == root.left) {
			return root.data;
		}
		return findMin(root.left);
	}
	
	private int findMax(Node root) {
		if(null == root) {
			System.out.println("Tree is empty...");
			return 0;
		}else if(null == root.right) {
			return root.data;
		}
		return findMax(root.right);
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
		}
		else if(data > root.data) {
			root.right = insert(root.right, data);
		}	
		return root;
	}
	
	private void printInorder(Node root) {
		if(null != root) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}
}
