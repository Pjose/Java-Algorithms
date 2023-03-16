package com.pj.java.algorithms.general;

import java.util.Arrays;
/*
 * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 */
public class MaxProductOfThree {

	public static void main(String[] args) {
		
		int[] A = {-3, 1, 2, -2, 5, 6};
		//int[] A = {-5, 5, -5, 4};
		//int[] A = {-4, -6, 3, 4, 5};
		//int [] A = {-3, 1, 2, -2, 5, 6};
		//int [] A = { -3, 1, -100, 2, -2, 5, 6  };
		//int [] A = { -3, 1, -100};
		//int [] A = { -3, 1, 0, -100};
		//int [] A = { -3, 1, 2, 0, -100};
		//int [] A = { -3, 1, 2, 0, -100};
		//System.out.println(getMaxProdOfThree(A));
		//System.out.println(getMaxProductOfThree(A));
		//System.out.println(getMaxProdOf3(A));
		System.out.println(getMaxProdOf3(A));

	}
	
	//Good for positive integers
	private static int getMaxProdOfThree(int[] A) {
		int maxProd = 0;
		if(A.length > 2) {
			int N = A.length;
			Arrays.sort(A);
			maxProd = A[N-1] * A[N-2] * A[N-3];
		}
		
		return maxProd;
	}
	
	private static int getMaxProductOfThree(int[] A) {
		int maxProd = 0;
		if(A.length > 2) {
			int N = A.length;
			Arrays.sort(A);
			maxProd = A[N-1] * A[N-2] * A[N-3];
			for(int i = 0; i < N-2; i++) {
				int prod = A[i] * A[i+1] * A[i+2];
				if(prod > maxProd) {
					maxProd = prod;
				}
			}
		}
		
		return maxProd;
	}
	
	private static int getMaxProdOf3(int[] A) {
		int maxProd = 0;
		if(A.length > 2) {
			int N = A.length;
			//Arrays.sort(A);
			maxProd = A[N-1] * A[N-2] * A[N-3];
			for(int i = 0; i < N-2; i++) {
				int prod = A[i] * A[i+1] * A[i+2];
				if(prod > maxProd) {
					maxProd = prod;
				}
			}
			Arrays.sort(A);
			int prod = A[N-1] * A[N-2] * A[N-3];
			if(prod > maxProd) {
				maxProd = prod;
			}
			prod = A[0] * A[1] * A[N-1];
			if(prod > maxProd) {
				maxProd = prod;
			}
		}
		return maxProd;
	}
	
	private static int getMaxProdThree(int[] A) {
		int maxProd = 0;
		if(A.length > 2) {
			int N = A.length;
			//Arrays.sort(A);
			maxProd = A[N-1] * A[N-2] * A[N-3];
			for(int i = 0; i < N-2; i++) {
				int prod = A[i] * A[i+1] * A[i+2];
				if(prod > maxProd) {
					maxProd = prod;
				}
			}
			Arrays.sort(A);
			int prod = A[N-1] * A[N-2] * A[N-3];
			if(prod > maxProd) {
				maxProd = prod;
			}
			prod = A[0] * A[1] * A[N-1];
			if(prod > maxProd) {
				maxProd = prod;
			}
		}
		return maxProd;
	}

}
