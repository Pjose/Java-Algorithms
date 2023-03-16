package com.pj.java.algorithms.general;

/*
 * Given a log of stock prices compute the maximum possible earning.
 */
public class MaxProfit {

	public static void main(String[] args) {
		
		int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
		//int[] A = {5, -7, 3, 5, -2, 4, -1};
		System.out.println(getMaxProfitSlice(A));
		//System.out.println(getGoldenMaxSlice(A));
		//System.out.println(getQuadraticMaxSlice(A));
		//System.out.println(getSlowMaxSlice(A));
		
	}
	
	private static int getMaxProfitSlice(int[] A) {
		int maxEnding = 0;
		int maxSlice = 0;
		int N = A.length;
		if(N != 0) {
			int profit = 0;
			for(int i = 1; i < N; i++) {
				profit = A[i] - A[i-1];
				maxEnding = Math.max(0, maxEnding + profit);
				maxSlice = Math.max(maxSlice, maxEnding);
			}
		}
		return maxSlice;
	}
	
	private static int getGoldenMaxSlice(int[] A) {
		int maxEnding = 0;
		int maxSlice = 0;
		if(A.length != 0) {
			for(int a : A) {
				maxEnding = Math.max(0, maxEnding + a);
				maxSlice = Math.max(maxSlice, maxEnding);
			}
		}
		return maxSlice;
	}
	
	private static int getQuadraticMaxSlice(int[] A) {
		int N = A.length;
		int result = 0;
		for(int p = 0; p < N; p++) {
			int sum = 0;
			for(int q = p; q < N; q++) {
				sum += A[q];
				result = Math.max(result, sum);
			}
		}
		return result;
	}
	
	private static int getSlowMaxSlice(int[] A) {
		int N = A.length;
		int result = 0;
		for(int p = 0; p < N; p++) {
			for(int q = p; q < N; q++) {
				int sum = 0;
				for(int i = p; i < q+1; i++) {
					sum += A[i];
					result = Math.max(result, sum);
				}
			}
		}
		return result;
	}
	
}
