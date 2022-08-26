package org.core.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(2);
		intList.add(4);
		intList.add(7);
		intList.add(1);
		
		Iterator<Integer> itr = intList.iterator();
		ListIterator<Integer> listItr = intList.listIterator();
		
		/*Iterate list using Iterator*/
		/*
		 * while(itr.hasNext()) { int val = itr.next(); if(val == 1) itr.remove(); }
		 */
		System.out.println(intList);
		
		/*Iterate list using ListIterator*/
		while(listItr.hasNext()) {
			int val = listItr.next();
			if(val == 2 ) {
				listItr.remove();
				listItr.add(11);
			}
			if(val == 4) {
				listItr.set(44);
			}
		}
		System.out.println(intList);
		
		while(listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}
	}

}
