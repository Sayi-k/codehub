package org.core.base.innerclass;

public class InnerClassTest {

	public static void main(String[] args) {
		new Outer().new MemberInnerClass().print();
		new Outer.NestedStaticClass().print();
		new Outer().localInner();
		Outer anonymousInnerClass = new Outer() {
			public void print() {
				System.out.println("Inside AnonymousInnerClass");
			}
		};
		anonymousInnerClass.print();
	}
}

class Outer {

	public class MemberInnerClass {
		public void print() {
			System.out.println("Inside MemberInnerClass");
		}
	}

	public static class NestedStaticClass {
		public void print() {
			System.out.println("Inside NestedStaticClass");
		}
	}

	public void localInner() {
		final class LocalInnerClass {
			public void print() {
				System.out.println("Inside LocalInnerClass");
			}
		}

		new LocalInnerClass().print();
	}

	public void print() {
		// TODO Auto-generated method stub

	}
}
