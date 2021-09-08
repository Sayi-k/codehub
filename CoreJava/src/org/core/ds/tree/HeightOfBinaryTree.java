package org.core.ds.tree;

public class HeightOfBinaryTree {
	private static Node root;
	public static void main(String[] args) {
		HeightOfBinaryTree tree = new HeightOfBinaryTree();
		tree.insert(20);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.printInorder(root);
		System.out.println("Height of tree is: "+tree.findHeightOfTree());
	}
	
	private void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}
	private int findHeightOfTree() {
		return findHeightOfTree(root);
	}
	private int findHeightOfTree(Node root) {
		if(null == root) {
			return -1;
		}
		int leftHeight = findHeightOfTree(root.left);
		int rightHeight = findHeightOfTree(root.right);
		return Math.max(leftHeight, rightHeight)+1;
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
