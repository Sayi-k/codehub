package org.core.ds.tree;

public class BinarySearchTree {
	private static Node root;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(7);
		tree.insert(16);

		System.out.println("5 present? : " + tree.search(5));
		System.out.println("Inorder print");
		tree.printInorder(root);

		tree.delete(15);
		System.out.println("Inorder print");
		tree.printInorder(root);
	}

	private void delete(int data) {
		this.delete(root, data);
	}

	private Node delete(Node root, int data) {
		if (null == root) {
			return root;
		} else if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		}
		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (null == root.left) {
				return root.right;
			} else if (null == root.right) {
				return root.left;
			}
			// node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
			root.data = minVlaue(root.right);
			// Delete the inorder successor 
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	private int minVlaue(Node root) {
		int min = root.data;
		while (root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}

	private void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}

	private boolean search(int data) {
		return this.serach(root, data);
	}

	private boolean serach(Node root, int data) {
		if (null == root) {
			return false;
		} else if (root.data == data) {
			return true;
		} else if (data < root.data) {
			return serach(root.left, data);
		} else if (data > root.data) {
			return serach(root.right, data);
		}
		return false;
	}

	private void insert(int data) {
		root = this.insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (null == root) {
			root = new Node(data);
		} else if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		}
		return root;
	}
}
