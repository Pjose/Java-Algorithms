package com.pj.java.algorithms.general;

public class PrefixSumArray {

	public static void main(String[] args) {
		
		int[] a = { 3, 6, 2, 8, 9, 2 };
		//int[] a = {3, 6};
		int[][] q = { { 2, 3 }, 
					  { 4, 6 }, 
					  { 1, 5 }, 
					  { 3, 6 } }; 
		//int[][] q = {{1, 2}};
		int n = a.length;
		int[] pf = new int[n + 1];
		//pf[0] = 0;
		for(int i = 0; i < n; i++) {
			pf[i + 1] = pf[i] + a[i];
		}
		for(int num : pf)
			System.out.print(num + ", ");
		
		System.out.println();
		for(int i = 0; i < q.length; i++) {
			int l = q[i][0];
			int r = q[i][1];
			
			System.out.print(pf[r] - pf[l - 1] + ", ");
		}

	}

}
