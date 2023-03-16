package com.pj.java.algorithms.general;

public class MaxDoubleSliceSum {

	public static void main(String[] args) {
		
		int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
		System.out.println(getMaxDblSliceSum(A));

	}
	
	private static int getMaxDblSliceSum(int[] A) {
		int max = 0;
		int N = A.length;
		int[] start = new int[N];
		int[] end = new int[N];
		for(int i = 1; i < N-1; i++) {
			start[i] = Math.max(A[i], start[i-1] + A[i]);
			if(start[i] < 0)
				start[i] = 0;
		}
		
		for(int i = N-2; i > 0; i--) {
			end[i] = Math.max(A[i], end[i+1] + A[i]);
			if(end[i] < 0)
				end[i] = 0;
		}
		
		for(int i = 1; i < N-1; i++) {
			max = Math.max(start[i-1] + end[i+1], max);
		}
		
		return max;
	}

}
