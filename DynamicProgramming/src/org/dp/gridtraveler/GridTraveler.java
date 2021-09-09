package org.dp.gridtraveler;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

	private static Map<String, Long> memo = new HashMap<>();
	private static long res;
	//private static String key;
	
	public static void main(String[] args) {
		System.out.println(gridTravel(1,1));
		memo.clear();
		System.out.println(gridTravel(2,3));
		memo.clear();
		System.out.println(gridTravel(3,3));
		memo.clear();
		System.out.println(gridTravel(18,18));
		memo.clear();
	}

	private static long gridTravel(int r, int c) {
		String key = r+","+c; //Ex: 43,2
		if(memo.containsKey(key)) return memo.get(key);
		
		if(r == 1 && c == 1) return 1;
		if(r == 0 || c== 0) return 0;
		
		res = gridTravel(r-1, c) + gridTravel(r, c-1);
		memo.put(key, res);
		//System.out.format("Inputs %s, %s = %s",r, c, memo);System.out.println();
		return res;
	}

}
