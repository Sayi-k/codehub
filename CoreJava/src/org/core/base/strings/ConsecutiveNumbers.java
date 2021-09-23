package org.core.base.strings;

public class ConsecutiveNumbers {

	public static void main(String[] args) {
		String s1 = "23242526";
		System.out.println(String.format("Is '%s' consecutive sequenced numbere?: %s ", s1, isConsecutiveNum(s1)));
		String s2 = "234567";
		System.out.println(String.format("Is '%s' consecutive sequenced numbere?: %s ", s2, isConsecutiveNum(s2)));
		String s3 = "345328";
		System.out.println(String.format("Is '%s' consecutive sequenced numbere?: %s ", s3, isConsecutiveNum(s3)));
		String s4 = "444445";
		System.out.println(String.format("Is '%s' consecutive sequenced numbere?: %s ", s4, isConsecutiveNum(s4)));
	}

	private static boolean isConsecutiveNum(String str) {
		int len = str.length();
		for(int i=0; i<len/2; i++) {
			String newStr = str.substring(0, i+1);
			int intVal = Integer.parseInt(newStr);
			while(newStr.length() < len) {
				newStr = newStr + ++intVal;
			}
			if(newStr.equals(str)) {
				return true;
			}
		}
		return false;
	}

}
