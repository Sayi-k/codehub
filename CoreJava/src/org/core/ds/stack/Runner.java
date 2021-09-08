package org.core.ds.stack;

public class Runner {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		System.out.println("\nIs empty = "+stack.isEmpty());
		stack.push(10);
		stack.show();
		stack.push(20);
		stack.show();
		stack.push(30);
		stack.show();
		stack.push(40);
		stack.show();
		stack.push(50);
		stack.show();
		System.out.println("\nPopped val = "+stack.pop());
		stack.show();
		System.out.println("\nPopped val = "+stack.pop());
		stack.show();
		System.out.println("\nPopped val = "+stack.pop());
		stack.show();
		System.out.println("\nSize = "+stack.size());
		System.out.println("\nIs empty = "+stack.isEmpty());
	}
}
