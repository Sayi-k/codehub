package org.core.base.tricks;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println(getInt());
	}

	public static int getInt() {
		try {
			throw new Exception();
		} catch (Exception exc) {
			//System.exit(0);
			return 1;
		} finally {
			return 2;
		}
	}
}
