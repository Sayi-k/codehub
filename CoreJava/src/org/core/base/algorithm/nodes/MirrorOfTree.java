package org.core.base.algorithm.nodes;

public class MirrorOfTree {

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
		MirrorOfTree mirror = new MirrorOfTree();
		mirror.mirror(tree.root);
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
