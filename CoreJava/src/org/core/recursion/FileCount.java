package org.core.recursion;

import java.io.File;

public class FileCount {

	public static final String FOLDER_PATH = "C:\\Users\\612463408\\Documents\\tmp";
	
	public static void main(String[] args) {
		int numberOfFiles = getFileCount(new File(FOLDER_PATH));
		System.out.println("Number of files = "+numberOfFiles);
	}

	private static int getFileCount(File file) {
		int count = 0;
		if(file.exists()) {
			for(File fi:file.listFiles()) {
				if(fi.isFile()) {
					count++;
				}
				if(fi.isDirectory()) {
					count += getFileCount(fi);
				}
			}
		}else {
			System.out.println("File not found");
		}
		return count;
	}

}
