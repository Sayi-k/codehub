package org.core.base.algorithm.nodes;

public class HeightOfTree {

	public static void main(String[] args) {
		NodeH head = new NodeH(1);
		head.left = new NodeH(2);
		head.right = new NodeH(3);
		head.left.left = new NodeH(4);
		head.left.left.left = new NodeH(5);
		head.left.left.left.left = new NodeH(6);
		head.left.left.left.right = new NodeH(7);
		System.out.println("Height of Tree: " + new BTree().findHeight(head));
	}
}

class NodeH {
	int value;
	NodeH left, right;

	public NodeH(int val) {
		value = val;
	}
}

class BTree {
	public int findHeight(NodeH node) {
		if (null == node) {
			return 0;
		}
		int lH = findHeight(node.left);
		int rH = findHeight(node.right);
		if (lH > rH) {
			return lH + 1;
		} else {
			return rH + 1;
		}
	}
}
