package org.core.base;

import java.io.UnsupportedEncodingException;

public class ConverstionTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String name = "Ram";
		byte[] nameBytes = name.getBytes("UTF-8");
		System.out.println("Bytes: " + nameBytes);

		String newName = new String(nameBytes, "UTF-8");
		System.out.println("Name: " + newName);

		Byte bObj = new Byte("10");
		System.out.println(bObj.longValue());

		Byte b = (byte) -129;
		System.out.println(b);
	}

}
