package org.core.base.dataStructure;

public class MinInStack {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(3);
		stack.push(5);
		stack.push(8);
		stack.push(6);
		stack.push(2);
		stack.push(1);
		System.out.println("Min = " + stack.getMin());
		stack.display();
		stack.pop();
		System.out.println("Min = " + stack.getMin());
		stack.display();
	}
}

class SingleNode {
	public int value;
	public int min;
	public SingleNode next;

	SingleNode(int val, int min) {
		this.value = val;
		this.min = min;
	}
}

class Stack {
	SingleNode top;

	public void push(int val) {
		if (null == top) {
			top = new SingleNode(val, val);
			return;
		}
		SingleNode node = new SingleNode(val, Math.min(val, top.min));
		node.next = top;
		top = node;
	}

	public void pop() {
		if (null == top) {
			return;
		}
		if (null == top.next) {
			top = null;
			return;
		}
		SingleNode node = top.next;
		top.next = null;
		top = node;
	}

	public int getMin() {
		if (null != top) {
			return top.min;
		}
		return -1;
	}

	public void display() {
		SingleNode node = top;
		while (null != node) {
			System.out.print("[val=" + node.value + ",min=" + node.min + "]->");
			node = node.next;
		}
		System.out.println();
	}
}
