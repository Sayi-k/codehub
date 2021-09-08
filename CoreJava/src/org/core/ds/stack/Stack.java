package org.core.ds.stack;

public class Stack {

	int[] stack = new int[2];
	int top;
	
	public void push(int data) {
		if(size()==stack.length) {
			incrementStack();
		}
		stack[top] = data;
		top++;
	}
	
	private void incrementStack() {
		int[] arr = new int[size()*2];
		System.arraycopy(stack, 0, arr, 0, size());
		stack = arr;
	}

	public int pop() {
		if(0==top) {
			System.out.println("Stack is empty");
		}
		top--;
		int val = stack[top];
		stack[top] = 0;
		if(top <= val60Perc()) {
			decrementStack();
		}
		return val;
	}
	
	private void decrementStack() {
		int[] arr = new int[size()];
		System.arraycopy(stack, 0, arr, 0, size());
		stack = arr;
	}

	public int val60Perc(){
		return (int)Math.round(stack.length*.6);
	}
	
	public void show() {
		for(int data: stack) {
			System.out.print(data+"->");
		}
		System.out.println();
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		if(0==top) {
			return true;
		}
		return false;
	}
}
