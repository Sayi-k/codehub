package org.core.ds.tree;

public class MirrorOfTree {

	static Node root;
	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.right.left = new Node(7);
		root.right.right.left = new Node(8);
		MirrorOfTree mirror = new MirrorOfTree();
		mirror.mirror(root);
	}

	public Node mirror(Node node) {
		if (null == node) {
			return node;
		}
		Node l = mirror(node.left);
		Node r = mirror(node.right);
		node.left = r;
		node.right = l;
		return node;
	}
}
