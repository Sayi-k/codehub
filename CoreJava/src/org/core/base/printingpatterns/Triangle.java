package org.core.base.printingpatterns;

public class Triangle {

	public static void main(String[] args) {
		int n = 10;
		pringNormalTriangle(n);
		printReverseTriangle(n);
		printTriangle(n);
	}

	private static void printTriangle(int n) {
		int space = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			space--;
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		space = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			space++;
			for (int j = 0; j < 2 * (n - i) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printReverseTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (j <= i) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void pringNormalTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
