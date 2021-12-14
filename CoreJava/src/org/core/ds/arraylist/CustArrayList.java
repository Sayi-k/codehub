package org.core.ds.arraylist;

public class CustArrayList {
	private int capacity = 10;
	private Object[] data;
	private int size;
	
	public CustArrayList () {
		data = new Object[capacity];
	}
	
	private void increaseSize() {
		capacity = capacity*2;
		Object[] newData = new Object[capacity];
		for(int i=0; i<size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	
	public void add(Object obj) {
		if(size == data.length) {
			increaseSize();
		}
		data[size++] = obj;
	}
	
	public Object get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	public void remove(int index) {
		checkIndex(index);
		for(int i=index; i<size-1; i++) {
			data[i] = data[i+1];
		}
		size--;
	}

	private void checkIndex(int index) {
		if(index < 0) {
			throw new RuntimeException("Index below zero");
		}
		if(index >= size) {
			throw new RuntimeException("Array index out of bound");
		}
	}
	
	public void display() {
		System.out.print("\n");
		for(int i=0; i<size; i++) {
			System.out.print(String.format("%s->", data[i]));
		}
		System.out.print("\n");
	}
}
