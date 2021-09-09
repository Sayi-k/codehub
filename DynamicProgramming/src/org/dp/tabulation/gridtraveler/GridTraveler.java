package org.dp.tabulation.gridtraveler;

public class GridTraveler {

	public static void main(String[] args) {
		System.out.println(gridTravel(1,1));//1
		System.out.println(gridTravel(2,3));//3
		System.out.println(gridTravel(3,3));//6
		System.out.println(gridTravel(18,18));//2333606220
	}

	private static long gridTravel(int m, int n) {
		long[][] tab = new long[m+1][n+1];
		tab[1][1] = 1;
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if (j+1 <= n) tab[i][j+1] += tab[i][j];
				if (i+1 <= m) tab[i+1][j] += tab[i][j];
			}
		}
		return tab[m][n];
	}
}
