package org.core.ds.tree;

import java.util.Stack;

public class ZigzagDisplayBST {
	private static Node root = null;

	public static void main(String[] args) {
		ZigzagDisplayBST tree = new ZigzagDisplayBST();
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
		
		tree.zigzagDisplay();
	}
	
	private void zigzagDisplay() {
		if(root != null) {
			Stack<Node> currentLevel = new Stack<>();
			Stack<Node> nextLevel = new Stack<>();
			boolean leftToRight = true;
			currentLevel.push(root);
			
			while(currentLevel.size() != 0) {
				Node node = currentLevel.pop();
				System.out.print(node.data+" -> ");
				if(leftToRight) {
					if(node.left != null) nextLevel.push(node.left);
					if(node.right != null) nextLevel.push(node.right);
				}
				else if(!leftToRight) {
					if(node.right != null) nextLevel.push(node.right);
					if(node.left != null) nextLevel.push(node.left);
				}
				
				if(currentLevel.size() == 0) {
					leftToRight = !leftToRight;
					Stack<Node> temp = currentLevel;
					currentLevel = nextLevel;
					nextLevel = temp;
				}
			}
		}
	}

	private void insert(int data) {
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
